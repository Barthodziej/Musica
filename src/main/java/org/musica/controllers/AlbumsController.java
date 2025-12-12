package org.musica.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.musica.liblistcells.AlbumListCell;
import org.musica.ApplicationContext;
import org.musica.database.LibraryDAO;
import org.musica.dto.AlbumMenuEntry;
import org.musica.services.MenuEntryService;

public class AlbumsController {

    @FXML
    ListView<AlbumMenuEntry> albumsListView;

    @FXML
    public void initialize() {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();
        MenuEntryService menuEntryService = ApplicationContext.getInstance().getMenuEntryService();

        ObservableList<AlbumMenuEntry> albumMenuEntries;

        try {
            albumMenuEntries = FXCollections.observableArrayList(menuEntryService.getAlbumMenuEntries());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load album list!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            albumMenuEntries = FXCollections.observableArrayList();
        }

        albumsListView.setItems(albumMenuEntries);
        albumsListView.setCellFactory(listView -> new AlbumListCell());

    }

}
