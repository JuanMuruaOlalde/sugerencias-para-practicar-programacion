package InterfaceGrafico.muestras_de_posibles_soluciones.java.HelloBenzirpi_javafx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;


public class HelloBenzirpi {

    @FXML private javafx.scene.control.TextField nombre;
    @FXML private javafx.scene.control.Label saludo;

    
    @FXML
    private void saludar(ActionEvent evento) {
        saludo.setText("Hola, " + nombre.getText());
    }


}
