package com.pmp.javafx101;

import com.pmp.dao.Alumno;
import com.pmp.dao.AlumnosModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController implements Initializable{
    int contador = 0;
        
    enum FormMode {
        INS,
        UPD,
        DEL,
        DSP
    }
    
    @FXML
    private TableView tblAlumnos;
    @FXML
    private TableColumn clmNombre;
    @FXML
    private TableColumn clmGrado;
    @FXML
    private TableColumn clmEdad;
    @FXML
    private TableColumn clmCuenta;
    @FXML
    private TableColumn clmTelefono;
    private ObservableList<AlumnoAdapter> listaDeAlumnos;
    private AlumnosModel alumnosModel; //Ready
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnMostrar;
    @FXML
    private Button btnEliminar;
    
    FormMode mode;
    
    
    private void reloadData(){
        listaDeAlumnos = FXCollections.observableArrayList(
                AlumnosAdapterFactory.getFromAlumnoArrayList(
                        alumnosModel.obtenerAlumnos()
                ));
        this.tblAlumnos.getItems().clear();
        this.tblAlumnos.getItems().addAll(listaDeAlumnos);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        alumnosModel = new AlumnosModel();
        
        this.clmCuenta.setCellValueFactory(new PropertyValueFactory<AlumnoAdapter, String>("cuenta"));
        this.clmNombre.setCellValueFactory(new PropertyValueFactory<AlumnoAdapter, String>("nombre"));
        this.clmGrado.setCellValueFactory(new PropertyValueFactory<AlumnoAdapter, String>("grado"));
        this.clmTelefono.setCellValueFactory(new PropertyValueFactory<AlumnoAdapter, String>("telefono"));
        this.clmEdad.setCellValueFactory(new PropertyValueFactory<AlumnoAdapter, String>("edad"));

        reloadData();
    }
    
    
    
    private Alumno loadAlumnoFrm(Alumno alumno) throws IOException {
        try {
            FXMLLoader win = App.getFXMLLoader("frmAlumno");
            Parent winObject = win.load();
            FrmAlumnoController alumnosWin = (FrmAlumnoController) win.getController();
            alumnosWin.setAlumnoObject(alumno);
            alumnosWin.setMode(mode.name());
            App.loadFXMLModal(winObject);
            if (alumnosWin.isConfirmAction()){
                return alumnosWin.getAlumnoObject();
            }
            return null;
        } catch (IOException ex) {
            System.err.println(ex);
            return null;
        }
                
    }
    
    @FXML
    private void btnNuevo_click(ActionEvent event) {
        try {
            mode = FormMode.INS;
            Alumno formData = loadAlumnoFrm(new Alumno());
            if (formData != null) {
                alumnosModel.agregarAlumno(formData);
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    
    @FXML
    private void btnEditar_click(ActionEvent event) {
         try {
            mode = FormMode.UPD;
            Alumno formData = loadAlumnoFrm(
                    ((AlumnoAdapter)tblAlumnos
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getAlumno()
            );
            if (formData != null) {
                alumnosModel.actualizarAlumno(formData);
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnMostrar_click(ActionEvent event) {
        try {
            mode = FormMode.DSP;
            Alumno formData = loadAlumnoFrm(
                    ((AlumnoAdapter)tblAlumnos
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getAlumno()
            );
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void btnEliminar_click(ActionEvent event) {
        try {
            mode = FormMode.DEL;
            Alumno formData = loadAlumnoFrm(
                    ((AlumnoAdapter)tblAlumnos
                            .getSelectionModel()
                            .getSelectedItem()
                    ).getAlumno()
            );
            if (formData != null) {
                alumnosModel.eliminarAlumno(formData.getId());
                reloadData();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
