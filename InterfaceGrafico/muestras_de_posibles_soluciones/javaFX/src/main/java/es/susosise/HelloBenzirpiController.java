package es.susosise;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class HelloBenzirpiController {

    @FXML private TextField txtNombre;
    @FXML private Label lblSaludo;

    @FXML
    private void saludar() throws IOException {
        lblSaludo.setText("Hola, " + txtNombre.getText() + ".");
    }
    
    @FXML
    private void volverAPantallaPrincipal() throws IOException {
        App.setRoot("pantalla_principal");
    }

}


