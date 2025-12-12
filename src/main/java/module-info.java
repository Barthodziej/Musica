module com.example.musica {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.lang3;
    requires javafx.base;
    requires javafx.graphics;

    exports org.musica.database;
    opens org.musica.database to javafx.fxml;
    exports org.musica.config;
    opens org.musica.config to javafx.fxml;
    exports org.musica.controllers;
    opens org.musica.controllers to javafx.fxml;
    opens org.musica to javafx.fxml;
    exports org.musica;
    exports org.musica.entities;
    opens org.musica.entities to javafx.fxml;
    exports org.musica.liblistcell;
    opens org.musica.liblistcell to javafx.fxml;
}