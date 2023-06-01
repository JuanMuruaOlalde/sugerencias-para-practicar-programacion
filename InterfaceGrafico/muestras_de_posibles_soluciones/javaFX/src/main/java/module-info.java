module es.susosise {
    requires transitive javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    opens es.susosise to javafx.fxml;
    exports es.susosise;
    opens es.susosise.tabladatos to javafx.fxml;
    exports es.susosise.tabladatos;
}
