package com.sujey.instituto.Controllers;

import com.sujey.instituto.App;
import com.sujey.instituto.Models.BaseDeDatos;
import com.sujey.instituto.Models.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CrearRegistroController {

    @FXML
    private Button guardar;
    @FXML
    private Button crear;
    @FXML
    private Button mostrar;
    @FXML
    private TextField tex2;

    @FXML
    private TextField tex3;

    @FXML
    private TextField tex4;

    @FXML
    private TextField tex5;



    @FXML
    private Button offWindow;

    @FXML
    void MouseClickGuardar(MouseEvent event) {
        int matricula = Integer.parseInt(tex2.getText());
        String nombre = tex3.getText();
        String apellidos = tex4.getText();
        String direccion = tex5.getText();

        Student nuevoEstudiante = new Student(matricula, nombre, apellidos, direccion);

        BaseDeDatos.save(nuevoEstudiante);

        Stage stage = (Stage) guardar.getScene().getWindow();
        stage.close();
    }
    @FXML
    void OnMouseClickedCrear(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("crearRegistro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("CREAR REGISTROS");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void OnMouseClickedMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mostrarRegistro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("MOSTRAR REGISTROS");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
