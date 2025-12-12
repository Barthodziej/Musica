package org.musica.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MusicaController {

    @FXML
    public void openSettings(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
            Parent root = loader.load();
            Stage settingsStage = new Stage();
            settingsStage.setTitle("Musica: Settings");
            settingsStage.setScene(new Scene(root));
            settingsStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void openLibrary(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("library.fxml"));
            Parent root = loader.load();
            Stage settingsStage = new Stage();
            settingsStage.setTitle("Musica: Library");
            Scene libraryScene = new Scene(root);
            libraryScene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());
            settingsStage.setScene(libraryScene);
            settingsStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
