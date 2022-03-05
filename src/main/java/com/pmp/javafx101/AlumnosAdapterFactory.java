package com.pmp.javafx101;

import java.util.ArrayList;
import com.pmp.dao.Alumno;


public class AlumnosAdapterFactory {
    
    public static ArrayList<AlumnoAdapter> getFromAlumnoArrayList( ArrayList<Alumno> alumnos) {
        ArrayList<AlumnoAdapter> AlumnoAdapter = new ArrayList();
        alumnos.forEach( (alumno) -> AlumnoAdapter.add(new AlumnoAdapter(alumno)));
        return AlumnoAdapter;
    }
}
