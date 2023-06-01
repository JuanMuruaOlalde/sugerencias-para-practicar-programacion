package es.susosise.tabladatos;

// Muchas gracias a Marco Jakob por compartir conocimiento y recursos con la comunidad.
// Este código tiene muchos elementos de este tutorial:
// https://code.makery.ch/es/library/javafx-tutorial/part2/


import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TablaConDatosController {

    @FXML
    private Label mensajes;

    @FXML
    private TableView<DatosPersona> tablaPersonas;
    @FXML
    private TableColumn<DatosPersona, String> columnaDNI;
    @FXML
    private TableColumn<DatosPersona, String> columnaNombre;
    @FXML
    private TableColumn<DatosPersona, String> columnaApellidos;
    @FXML
    private TableColumn<DatosPersona, LocalDate> columnaFechaDeNacimiento;

    @FXML
    private void initialize() {
        columnaDNI.setCellValueFactory(datoEnLaCasilla -> datoEnLaCasilla.getValue().dNIProperty()); 
        columnaNombre.setCellValueFactory(datoEnLaCasilla -> datoEnLaCasilla.getValue().nombreProperty()); 
        columnaApellidos.setCellValueFactory(datoEnLaCasilla -> datoEnLaCasilla.getValue().apellidosProperty()); 
        columnaFechaDeNacimiento.setCellValueFactory(datoEnLaCasilla -> datoEnLaCasilla.getValue().fechaDeNacimientoProperty()); 
        // columnaNombre.setCellFactory(datosEnLaColumna -> {
        //     @Override
        //     protected void updateItem(String datoEnLaCasilla, boolean vacio) {
        //         super.updateItem(datoEnLaCasilla, vacio);
        //         if (datoEnLaCasilla == null || empty) {
        //             setText(null);
        //             setStyle("");
        //         } else {
        //             setText("tiene valor");
        //         }
        //     }
        // });
        
        GestorDePersonas gestorPersonas = new GestorDePersonas();
        ObservableList<DatosPersona> personasParaPruebas = FXCollections.observableArrayList();
        personasParaPruebas.addAll(gestorPersonas.getAlgunasPersonasParaPruebas());
        tablaPersonas.setItems(personasParaPruebas);

        tablaPersonas.getSelectionModel().selectedItemProperty().addListener(
            (lista, valorAnterior, nuevoValor) -> mensajes.setText("Has seleccionado a " + nuevoValor.toString())
        );
    }


    @FXML
    private void volverAPantallaPrincipal() throws IOException {
        es.susosise.App.setRoot("pantalla_principal");
    }

}
