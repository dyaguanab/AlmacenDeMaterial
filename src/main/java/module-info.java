module com.example.almacen {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.almacen to javafx.fxml;
    exports com.example.almacen;
}