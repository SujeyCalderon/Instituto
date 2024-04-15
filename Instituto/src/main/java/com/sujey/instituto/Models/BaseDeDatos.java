package com.sujey.instituto.Models;

import java.util.ArrayList;


public interface BaseDeDatos {
    boolean addStudent (ArrayList<Student>estudiantes);

     void save(Student student);

    void update (Student student);

}
