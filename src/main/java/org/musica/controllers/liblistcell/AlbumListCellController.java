package org.musica.controllers.liblistcell;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.File;

public class AlbumListCellController {

    @FXML
    public ImageView coverView;
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

    public void setCover(String coverPath) {
        coverView.setImage(new Image(new File(coverPath).toURI().toString(), coverView.getFitWidth(), coverView.getFitHeight(), false, true));
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setArtistNames(String artistNames) {
        this.artistNames.setText(artistNames);
    }

}
