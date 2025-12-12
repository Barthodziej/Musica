package org.musica.liblistcell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import org.musica.controllers.liblistcell.TrackListCellController;
import org.musica.dto.TrackMenuEntry;

import java.io.IOException;

public class TrackListCell extends ListCell<TrackMenuEntry> {

    private final HBox graphicContainer;
    TrackListCellController controller;

    public TrackListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("track-list-cell.fxml"));
        try {
            graphicContainer = loader.load();
            controller = loader.getController();
        }
        catch (IOException e) {
            throw new RuntimeException("Could not load FXML fox TrackListCell", e);
        }
    }

    @Override
    protected void updateItem(TrackMenuEntry trackMenuEntry, boolean empty) {
        super.updateItem(trackMenuEntry, empty);

        if (empty || trackMenuEntry == null) {
            setText(null);
            setGraphic(null);
            //System.out.println("Empty! " + trackMenuEntry + " " + empty);
        }
        else {
            controller.setTitle(trackMenuEntry.getTitle());
            controller.setArtistNames(String.join(", ", trackMenuEntry.getArtistNames()));
            setGraphic(graphicContainer);
        }
    }
}
