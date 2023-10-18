module com.masanz.almacen.almacendematerial {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.masanz.almacen.almacendematerial to javafx.fxml;
    exports com.masanz.almacen.almacendematerial;
}