package com.sujey.instituto.Models;


public class Student {
    private int matricula;
    private String nombre;
    private String apellidos;
    private String direccion;

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMatricula() {
        return matricula;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public Student(int matricula, String nombre, String apellidos, String direccion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }
}
