package org.musica.liblistcell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.musica.controllers.liblistcell.AlbumListCellController;
import org.musica.dto.AlbumMenuEntry;

import java.io.File;
import java.io.IOException;

public class AlbumListCell extends ListCell<AlbumMenuEntry> {

    AlbumListCellController controller;
    private HBox graphicContainer;

    public AlbumListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("album-list-cell.fxml"));
        try {
            graphicContainer = loader.load();
            controller = loader.getController();
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
            controller.setCover(albumMenuEntry.getCoverPath());
            controller.setTitle(albumMenuEntry.getTitle());
            controller.setArtistNames(String.join(", ", albumMenuEntry.getArtistNames()));
            setGraphic(graphicContainer);
        }
    }
}
