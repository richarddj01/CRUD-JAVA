
package com.pmp.dao;

public class Alumno {


    
    public int getId() {
        return _id;
    }
    
    public void setId(int _id) {
        this._id = _id;
    }

    public String getCuenta() {
        return _cuenta;
    }

    public void setCuenta(String _cuenta) {
        this._cuenta = _cuenta;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getGrado() {
        return _grado;
    }

    public void setGrado(int _grado) {
        this._grado = _grado;
    }

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    public int getEdad() {
        return _edad;
    }

    public void setEdad(int _edad) {
        this._edad = _edad;
    }
    
    private int _id; 
    private String _cuenta;
    private String _nombre;
    private int _grado;
    private String _telefono;
    private int _edad;    
    
}
