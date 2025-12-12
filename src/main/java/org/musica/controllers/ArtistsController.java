package org.musica.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.musica.ApplicationContext;
import org.musica.liblistcell.ArtistListCell;
import org.musica.database.LibraryDAO;
import org.musica.dto.ArtistMenuEntry;
import org.musica.services.MenuEntryService;

public class ArtistsController {

    @FXML
    ListView<ArtistMenuEntry> artistsListView;

    @FXML
    public void initialize() {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();
        MenuEntryService menuEntryService = ApplicationContext.getInstance().getMenuEntryService();

        ObservableList<ArtistMenuEntry> artistMenuEntries;

        try {
            artistMenuEntries = FXCollections.observableArrayList(menuEntryService.getArtistMenuEntries());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load track list!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            artistMenuEntries = FXCollections.observableArrayList();
        }

        artistsListView.setItems(artistMenuEntries);
        artistsListView.setCellFactory(_ -> new ArtistListCell());
    }

}
