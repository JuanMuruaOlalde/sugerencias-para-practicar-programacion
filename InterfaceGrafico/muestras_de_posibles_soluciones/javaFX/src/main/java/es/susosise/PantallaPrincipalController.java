package es.susosise;

import java.io.IOException;
import javafx.fxml.FXML;

public class PantallaPrincipalController {
    
    @FXML
    private void cargarPantallaHelloBenzirpi() throws IOException {
        App.setRoot("hello_benzirpi");
    }
    
}
        