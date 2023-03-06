package es.susosise;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class CalendarioController {

    @FXML private DatePicker dpkFechaElegida;
    @FXML private Label lblAviso;

    @FXML
    private void avisar() throws IOException {
        LocalDate fechaElegida = dpkFechaElegida.getValue();
        if (fechaElegida == null) {
            lblAviso.setText("Primero tienes que usar el calendario para elegir el dia del aviso.");
        } else {
            lblAviso.setText("Has elegido el dia " + fechaElegida.toString() + ".");
        }
    }
    
    @FXML
    private void volverAPantallaPrincipal() throws IOException {
        App.setRoot("pantalla_principal");
    }

}

