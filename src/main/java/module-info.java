module com.example.musica {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.lang3;

    opens com.example.musica to javafx.fxml;
    exports com.example.musica;
    exports com.example.musica.library;
    opens com.example.musica.library to javafx.fxml;
    exports com.example.musica.config;
    opens com.example.musica.config to javafx.fxml;
    exports com.example.musica.controllers;
    opens com.example.musica.controllers to javafx.fxml;
}