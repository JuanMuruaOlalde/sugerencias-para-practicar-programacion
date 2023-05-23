package es.susosise;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;

public class BocatasController {
    @FXML private TextField txtResultado;
    @FXML private RadioButton panNormal;
    @FXML private RadioButton panIntegral;
    @FXML private RadioButton panBagete;
    @FXML private RadioButton panDeMolde;
    @FXML private RadioButton lomo;
    @FXML private RadioButton tortillaJamonYork;
    @FXML private RadioButton tortillaAtun;
    @FXML private RadioButton tortillaQueso;
    @FXML private RadioButton calamares;
    @FXML private CheckBox cebollaFresca;
    @FXML private CheckBox cebollaCaramelizada;
    @FXML private CheckBox pimientos;
    @FXML private CheckBox queso;

    @FXML
    private void initialize() {
        panNormal.setSelected(true);
    }

    @FXML
    private void componerBocata() throws IOException {
        StringBuilder composicionDelBocata = new StringBuilder();
        composicionDelBocata.append("Bocata con ");
        if (panNormal.isSelected()) {
            composicionDelBocata.append("pan normal");
        }
        if (panIntegral.isSelected()) {
            composicionDelBocata.append("pan integral");
        }
        if (panBagete.isSelected()) {
            composicionDelBocata.append("pan bagete");
        }
        if (panDeMolde.isSelected()) {
            composicionDelBocata.append("pan de molde");
        }
        composicionDelBocata.append(", de ");
        if (lomo.isSelected()) {
            composicionDelBocata.append("lomo, ");
        }
        if (tortillaJamonYork.isSelected()) {
            composicionDelBocata.append("tortilla de jamon York, ");
        }
        if (tortillaAtun.isSelected()) {
            composicionDelBocata.append("tortilla de atun, ");
        }
        if (tortillaQueso.isSelected()) {
            composicionDelBocata.append("tortilla de queso, ");
        }
        if (calamares.isSelected()) {
            composicionDelBocata.append("calamares, ");
        }
        if (cebollaFresca.isSelected()) {
            composicionDelBocata.append("cebolla fresca, ");
        }
        if (cebollaCaramelizada.isSelected()) {
            composicionDelBocata.append("cebolla caramelizada, ");
        }
        if (pimientos.isSelected()) {
            composicionDelBocata.append("pimientos, ");
        }
        if (queso.isSelected()) {
            composicionDelBocata.append("queso, ");
        }
        composicionDelBocata.append(".");

        txtResultado.setText(composicionDelBocata.toString());
    }
    
    @FXML
    private void volverAPantallaPrincipal() throws IOException {
        App.setRoot("pantalla_principal");
    }

}
