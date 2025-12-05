package org.musica;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.musica.dto.TrackMenuEntry;

import java.io.IOException;

public class AlbumListCell extends ListCell<TrackMenuEntry> {

    @FXML
    Text title;
    @FXML
    Text artistNames;
    @FXML
    private HBox graphicContainer;

    public AlbumListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("track-list-cell.fxml"));
        loader.setController(this);
        try {
            loader.load();
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
            System.out.println("Empty! " + trackMenuEntry + " " + empty);
        }
        else {
            title.setText(trackMenuEntry.getTitle());
            artistNames.setText(String.join(", ", trackMenuEntry.getArtistNames()));
            setGraphic(graphicContainer);
        }
    }
}
