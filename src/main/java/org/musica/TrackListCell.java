package org.musica.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.musica.dto.TrackMenuEntry;

import java.io.IOException;
import java.util.Arrays;

public class TrackListCell extends ListCell<TrackMenuEntry> {
    @FXML
    Text title;
    @FXML
    Text artistNames;

    private final HBox graphicContainer;

    public TrackListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("track-list-cell.fxml"));
        loader.setController(this);
        try {
            loader.load();
            this.graphicContainer = (HBox) loader.getNamespace().get("graphicContainer");
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
        }
        else {
            title.setText(trackMenuEntry.getTitle());
            artistNames.setText(Arrays.stream(trackMenuEntry.getArtistNames()).reduce("", (a, b) -> a + " " + b));
        }
    }
}
