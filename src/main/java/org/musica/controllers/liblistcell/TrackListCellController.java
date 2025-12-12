package org.musica.controllers.liblistcell;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class TrackListCellController {

    @FXML
    public Label title;
    @FXML
    public Label artistNames;
    @FXML
    public Button editButton;

    @FXML
    public void handleMouseEnter(MouseEvent event) {
        editButton.setVisible(true);
    }

    @FXML
    public void handleMouseExit(MouseEvent event) {
        editButton.setVisible(false);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setArtistNames(String artistNames) {
        this.artistNames.setText(artistNames);
    }

}
