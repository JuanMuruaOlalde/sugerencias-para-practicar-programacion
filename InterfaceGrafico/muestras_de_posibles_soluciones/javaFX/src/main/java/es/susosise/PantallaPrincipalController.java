package es.susosise;

import java.io.IOException;
import javafx.fxml.FXML;

public class PantallaPrincipalController {
    
    @FXML
    private void cargarPantallaHelloBenzirpi() throws IOException {
        App.setRoot("hello_benzirpi");
    }
    
    @FXML
    private void cargarPantallaBocatas() throws IOException {
        App.setRoot("bocatas");
    }
    
    @FXML
    private void cargarPantallaCalendario() throws IOException {
        App.setRoot("calendario");
    }
    
    @FXML
    private void cargarPantallaTablaConDatos() throws IOException {
        App.setRoot("tabla_con_datos");
    }
    
}
        