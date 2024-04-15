package com.sujey.instituto.Models;

import java.util.ArrayList;

public class Instituto {
    private BaseDeDatos baseDeDatos;
    private ArrayList<Student> estudiantes=new ArrayList<>();
    private ArrayList<BaseDeDatos> basesDeDatos = new ArrayList<>();

    public Instituto(BaseDeDatos... bases) {
        for (BaseDeDatos base : bases) {
            basesDeDatos.add(base);
        }
    }

    public Boolean addAlumno(Student student){
        return estudiantes.add(student);
    }

    public void addBaseDatos(){
        baseDeDatos.addStudent(estudiantes);
        for (BaseDeDatos base : basesDeDatos) {
            base.addStudent(estudiantes);
        }
    }

    public ArrayList<Student> getEstudiantes() {
        return estudiantes;
    }

    public void updateAlumno(Student student){
        for (BaseDeDatos base : basesDeDatos) {
            base.update(student);
        }
    }

    public void saveAlumno(Student student) {
        for (BaseDeDatos base : basesDeDatos){
            BaseDeDatos.save(student);
        }
    }
}
