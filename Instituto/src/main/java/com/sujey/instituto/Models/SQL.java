package com.sujey.instituto.Models;

import java.util.ArrayList;

public class SQL implements BaseDeDatos {
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public boolean addStudent(ArrayList<Student> students) {
        return this.students.addAll(students);
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void update(Student student) {
        for (Student s : students) {
            if (s.getMatricula() == student.getMatricula()) {
                s.setNombre(student.getNombre());
                s.setApellidos(student.getApellidos());
                s.setDireccion(student.getDireccion());
                break;
            }
        }
    }
}
