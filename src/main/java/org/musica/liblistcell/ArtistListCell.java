package org.musica.liblistcell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.musica.controllers.liblistcell.ArtistListCellController;
import org.musica.dto.ArtistMenuEntry;

import java.io.File;
import java.io.IOException;

public class ArtistListCell extends ListCell<ArtistMenuEntry> {

    private HBox graphicContainer;
    private ArtistListCellController controller;

    public ArtistListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("artist-list-cell.fxml"));
        try {
            graphicContainer = loader.load();
            controller = loader.getController();
        }
        catch (IOException e) {
            throw new RuntimeException("Could not load FXML fox ArtistListCell", e);
        }
    }

    @Override
    protected void updateItem(ArtistMenuEntry artistMenuEntry, boolean empty) {
        super.updateItem(artistMenuEntry, empty);

        if (empty || artistMenuEntry == null) {
            setText(null);
            setGraphic(null);
        }
        else {
            // TODO: Avatar loading
            controller.setName(artistMenuEntry.getName());
            controller.setAvatar(artistMenuEntry.getAvatarPath());
            controller.setAlbumsCount(artistMenuEntry.getAlbumsCount() + " albums");
            setGraphic(graphicContainer);
        }
    }

}
