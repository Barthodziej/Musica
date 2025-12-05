package com.example.musica;

import com.example.musica.config.Config;
import com.example.musica.config.ConfigInitializer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class SettingsController {

    @FXML
    private TextField mediaPathField;
    @FXML
    private Tooltip mediaPathTooltip;
    @FXML
    private TextField dataPathField;
    @FXML
    private Tooltip dataPathTooltip;
    @FXML
    private VBox szczur;



    @FXML
    private void browseMedia(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose media path");
        File selectedDirectory = directoryChooser.showDialog(((Node) event.getTarget()).getScene().getWindow());
        mediaPathField.setText(selectedDirectory.getAbsolutePath());
        mediaPathField.requestFocus();
        Platform.runLater(() -> {
            mediaPathField.positionCaret(mediaPathField.getText().length());
        });
    }

    @FXML
    private void saveMediaPath(ActionEvent event) {

        ConfigInitializer configInitializer = ApplicationContext.getInstance().getConfigInitializer();
        Config config = ApplicationContext.getInstance().getConfig();

        try {
            if (!configInitializer.isInitialized()) {
                configInitializer.initialize();
            }
            config.saveMediaConfig(mediaPathField.getText());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not save media path!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    private void browseData(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose data path");
        File selectedDirectory = directoryChooser.showDialog(((Node) event.getTarget()).getScene().getWindow());
        dataPathField.setText(selectedDirectory.getAbsolutePath());
        dataPathField.requestFocus();
        Platform.runLater(() -> {
            dataPathField.positionCaret(mediaPathField.getText().length());
        });
    }

    @FXML
    private void saveDataPath(ActionEvent event) {

        ConfigInitializer configInitializer = ApplicationContext.getInstance().getConfigInitializer();
        Config config = ApplicationContext.getInstance().getConfig();

        try {
            if (!configInitializer.isInitialized()) {
                configInitializer.initialize();
            }
            config.saveDataConfig(dataPathField.getText());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not save data path!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    public void initialize() {

        Config config = ApplicationContext.getInstance().getConfig();

        try {
            mediaPathField.setText(config.loadMediaConfig());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load media path!");
            alert.setContentText(e.getMessage());
        }

        try {
            dataPathField.setText(config.loadDataConfig());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load data path!");
            alert.setContentText(e.getMessage());
        }

        mediaPathTooltip.textProperty().bind(mediaPathField.textProperty());
        dataPathTooltip.textProperty().bind(dataPathField.textProperty());

    }

}
