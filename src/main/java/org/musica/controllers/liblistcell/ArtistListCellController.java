package org.musica.controllers.liblistcell;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.File;

public class ArtistListCellController {

    @FXML
    public ImageView avatarView;
    @FXML
    public Label name;
    @FXML
    public Label albumsCount;
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

    public void setAvatar(String avatarPath) {
        avatarView.setImage(new Image(new File(avatarPath).toURI().toString(), avatarView.getFitWidth(), avatarView.getFitHeight(), false, true));
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setAlbumsCount(String albumsCount) {
        this.albumsCount.setText(albumsCount);
    }

}
