module es.susosise {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.susosise to javafx.fxml;
    exports es.susosise;
}
