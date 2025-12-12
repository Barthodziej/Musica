package org.musica.liblistcell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.musica.dto.AlbumMenuEntry;

import java.io.File;
import java.io.IOException;

public class AlbumListCell extends ListCell<AlbumMenuEntry> {

    @FXML
    ImageView coverView;
    @FXML
    Label title;
    @FXML
    Label artistNames;
    @FXML
    private HBox graphicContainer;

    public AlbumListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("album-list-cell.fxml"));
        loader.setController(this);
        try {
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException("Could not load FXML fox AlbumListCell", e);
        }
    }

    @Override
    protected void updateItem(AlbumMenuEntry albumMenuEntry, boolean empty) {
        super.updateItem(albumMenuEntry, empty);

        if (empty || albumMenuEntry == null) {
            setText(null);
            setGraphic(null);
        }
        else {
            coverView.setImage(new Image(new File(albumMenuEntry.getCoverPath()).toURI().toString(), coverView.getFitWidth(), coverView.getFitHeight(), false, true));
            title.setText(albumMenuEntry.getTitle());
            artistNames.setText(String.join(", ", albumMenuEntry.getArtistNames()));
            setGraphic(graphicContainer);
        }
    }
}
