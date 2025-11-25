module com.example.musica {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.musica to javafx.fxml;
    exports com.example.musica;
}