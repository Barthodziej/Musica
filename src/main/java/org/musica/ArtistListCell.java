package org.musica;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.musica.dto.ArtistMenuEntry;

import java.io.File;
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
        }
        else {
            // TODO: Avatar loading
            name.setText(artistMenuEntry.getName());
            avatarView.setImage(new Image(new File(artistMenuEntry.getAvatarPath()).toURI().toString(), avatarView.getFitWidth(), avatarView.getFitHeight(), false, true));
            albumsCount.setText(artistMenuEntry.getAlbumsCount() + " albums");
            setGraphic(graphicContainer);
        }
    }

}
