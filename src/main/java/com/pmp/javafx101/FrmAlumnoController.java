/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.javafx101;

import com.pmp.dao.Alumno;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author richarddj
 */
public class FrmAlumnoController implements Initializable {

    @FXML
    private TextField txtCuenta;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtGrado;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtTelefono;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    /**
     * Initializes the controller class.
     */
    
    boolean confirmAction;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnAceptar_click(ActionEvent event) {
        this.confirmAction = true;
        App.closeModal(event);
    }

    @FXML
    private void btnCancelar_click(ActionEvent event) {
        this.confirmAction = false;
        App.closeModal(event);
    }

    
    private Alumno _alumno;
    
    
    public void setAlumnoObject( Alumno cliente) {
        _alumno = cliente;
        refreshUX();
    }
    
    private void refreshUX(){
        txtCuenta.setText(_alumno.getCuenta());
        txtNombre.setText(_alumno.getNombre());
        txtGrado.setText(String.valueOf(_alumno.getGrado()));
        txtTelefono.setText(String.valueOf(_alumno.getTelefono()));
        txtEdad.setText(String.valueOf(_alumno.getEdad())); 
    }
    
    public void setMode(String mode) {
        switch (mode) {
            case "INS":
                txtGrado.setText("");
                txtTelefono.setText("");
                txtEdad.setText("");
            case "UPD":
                break;
            case "DEL", "DSP":
                txtCuenta.setEditable(false);
                txtNombre.setEditable(false);
                txtGrado.setEditable(false);
                txtTelefono.setEditable(false);
                txtEdad.setEditable(false);
                if(mode == "DSP") btnAceptar.setVisible(false);
                break;
        }
    }
    
    public Alumno getAlumnoObject(){
        refreshObjFromUx();
        return _alumno;
    }
    private void refreshObjFromUx(){
        _alumno.setCuenta(txtCuenta.getText());
        _alumno.setNombre(txtNombre.getText());
        _alumno.setGrado(Integer.parseInt(txtGrado.getText()));
        _alumno.setTelefono(txtTelefono.getText());
        _alumno.setEdad(Integer.parseInt(txtEdad.getText()));
    }
    public boolean isConfirmAction() {
        return confirmAction;
    }
}
