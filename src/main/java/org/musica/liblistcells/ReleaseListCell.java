package org.musica.liblistcells;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.musica.dto.ReleaseMenuEntry;
import org.musica.dto.TrackMenuEntry;

import java.io.File;
import java.io.IOException;

public class ReleaseListCell extends ListCell<ReleaseMenuEntry> {

    @FXML
    ImageView coverView;
    @FXML
    Label title;
    @FXML
    Label releaseDate;
    @FXML
    Label artistNames;
    @FXML
    private HBox graphicContainer;

    public ReleaseListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("release-list-cell.fxml"));
        loader.setController(this);
        try {
            loader.load();
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
            coverView.setImage(new Image(new File(releaseMenuEntry.getCoverPath()).toURI().toString(), coverView.getFitWidth(), coverView.getFitHeight(), false, true));
            title.setText(releaseMenuEntry.getTitle());
            releaseDate.setText(releaseMenuEntry.getReleaseDate());
            artistNames.setText(String.join(", ", releaseMenuEntry.getArtistNames()));
            setGraphic(graphicContainer);
        }
    }
}
