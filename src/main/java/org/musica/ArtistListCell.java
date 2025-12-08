package org.musica;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.musica.dto.ArtistMenuEntry;

import java.io.IOException;

public class ArtistListCell extends ListCell<ArtistMenuEntry> {

    @FXML
    ImageView avatarView;
    @FXML
    Text name;
    @FXML
    Text albumsCount;
    @FXML
    private HBox graphicContainer;

    public ArtistListCell() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("artist-list-cell.fxml"));
        loader.setController(this);
        try {
            loader.load();
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
            System.out.println("Empty! " + artistMenuEntry + " " + empty);
        }
        else {
            // TODO: Avatar loading
            name.setText(artistMenuEntry.getName());
            albumsCount.setText(artistMenuEntry.getAlbumsCount() + " albums");
            setGraphic(graphicContainer);
            System.out.println("List cell set up, artist Name: " + artistMenuEntry.getName());
        }
    }

}
