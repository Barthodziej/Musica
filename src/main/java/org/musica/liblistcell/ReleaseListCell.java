package org.musica.liblistcell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.musica.controllers.liblistcell.ReleaseListCellController;
import org.musica.dto.ReleaseMenuEntry;

import java.io.File;
import java.io.IOException;

public class ReleaseListCell extends ListCell<ReleaseMenuEntry> {

    private ReleaseListCellController controller;
    private HBox graphicContainer;

    public ReleaseListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("release-list-cell.fxml"));
        try {
            graphicContainer = loader.load();
            controller = loader.getController();
        }
        catch (IOException e) {
            throw new RuntimeException("Could not load FXML fox ReleaseListCell", e);
        }
    }

    @Override
    protected void updateItem(ReleaseMenuEntry releaseMenuEntry, boolean empty) {
        super.updateItem(releaseMenuEntry, empty);

        if (empty || releaseMenuEntry == null) {
            setText(null);
            setGraphic(null);
            //System.out.println("Empty! " + trackMenuEntry + " " + empty);
        }
        else {
            controller.setCover(releaseMenuEntry.getCoverPath());
            controller.setTitle(releaseMenuEntry.getTitle());
            controller.setReleaseDate(releaseMenuEntry.getReleaseDate());
            controller.setArtistNames(String.join(", ", releaseMenuEntry.getArtistNames()));
            setGraphic(graphicContainer);
        }
    }
}
