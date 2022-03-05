package com.pmp.javafx101;
import com.pmp.dao.Alumno;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class AlumnoAdapter {

    
    public String getCuenta() {
        return cuenta.get();
    }

   
    public void setCuenta(String _cuenta) {
        this.cuenta.set(_cuenta);
    }

    
    public String getNombre() {
        return nombre.get();
    }

    
    public void setNombre(String _nombre) {
        this.nombre.set(_nombre);
    }

    
    public int getGrado() {
        return grado.get();
    }

    
    public void setGrado(int _grado) {
        this.grado.set(_grado);
    }

    
    public String getTelefono() {
        return telefono.get();
    }

    
    public void setTelefono(String _telefono) {
        this.telefono.set(_telefono);
    }

    
    public int getEdad() {
        return edad.get();
    }

    
    public void setEdad(int _edad) {
        this.edad.set(_edad); 
    }

   
    public int getId() {
        return id.get();
    }

   
    public void setId(int _id) {
        this.id.set(_id);
    }

    
    private Alumno _alumno;
    
    
    public Alumno getAlumno() {
        _alumno.setId(id.get()); 
        _alumno.setCuenta(cuenta.get());
        _alumno.setNombre(nombre.get());
        _alumno.setGrado(grado.get());
        _alumno.setTelefono(telefono.get());
        _alumno.setEdad(edad.get());
        return this._alumno;
    }
    
    public AlumnoAdapter(){
        this._alumno = new Alumno();
        cuenta = new SimpleStringProperty("");
        nombre = new SimpleStringProperty("");
        grado = new SimpleIntegerProperty(0);
        telefono = new SimpleStringProperty("");
        edad = new SimpleIntegerProperty(0);
    }
    public AlumnoAdapter(Alumno _Alumno){
        this._alumno = _Alumno;
        id = new SimpleIntegerProperty(0);
        cuenta = new SimpleStringProperty("");
        nombre = new SimpleStringProperty("");
        grado = new SimpleIntegerProperty(0);
        telefono = new SimpleStringProperty("");
        edad = new SimpleIntegerProperty(0);
        
        id.set(_alumno.getId());
        cuenta.set(_alumno.getCuenta());
        nombre.set(_alumno.getNombre());
        grado.set(_alumno.getGrado());
        telefono.set(_alumno.getTelefono());
        edad.set(_alumno.getEdad());  
    }
    
    
    private SimpleStringProperty cuenta;
    private SimpleStringProperty nombre;
    private SimpleIntegerProperty grado;
    private SimpleStringProperty telefono;
    private SimpleIntegerProperty edad;
    private SimpleIntegerProperty id;
}
