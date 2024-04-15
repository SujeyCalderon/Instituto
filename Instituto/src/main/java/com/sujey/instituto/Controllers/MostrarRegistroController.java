package com.sujey.instituto.Controllers;

import com.sujey.instituto.App;
import com.sujey.instituto.Models.BaseDeDatos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MostrarRegistroController {
    private BaseDeDatos hBase;
    private BaseDeDatos mySql;
    private BaseDeDatos sql;

    public MostrarRegistroController(BaseDeDatos hBase, BaseDeDatos mySql, BaseDeDatos sql) {
        this.hBase = hBase;
        this.mySql = mySql;
        this.sql = sql;
    }

    @FXML
    private Button modificar;
    @FXML
    private Button ver;
    @FXML
    private TextField tex;

    @FXML
    private TextField tex2;

    @FXML
    private TextField tex3;

    @FXML
    private TextField tex4;

    @FXML
    private TextField tex5;

    @FXML
    private Button crear;
    @FXML
    private Button mostrar;


    @FXML
    private Button offWindow;

    @FXML
    void OnMouseClickedModificar(MouseEvent event) {
        Student selectedStudent = tableViewStudents.getSelectionModel().getSelectedItem();

        if (selectedStudent == null) {
            showErrorAlert("Debe seleccionar un estudiante");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/polimorfismoestudiante/saveStudent.fxml"));
                Parent root = loader.load();

                CrearStudentController controller = loader.getController();
                controller.initAttributes(selectedStudent);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                Student modifiedStudent = controller.getStudent();
                if (modifiedStudent != null) {
                    serviciosEscolares.updateInDatabases(selectedStudent, modifiedStudent);
                    tableViewStudents.refresh();
                    serviciosEscolares.printStudents();
                }
            } catch (IOException e) {
                showErrorAlert("Error al cargar la ventana de modificación");
            }
        }
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
    void OnMouseClickedVer(MouseEvent event) {

    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
