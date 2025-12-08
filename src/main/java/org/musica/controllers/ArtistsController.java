package org.musica.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.musica.ApplicationContext;
import org.musica.database.LibraryDAO;
import org.musica.entities.Artist;
import org.musica.services.MenuEntryService;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArtistsController {

    @FXML
    ListView<String> artistsListView;

    @FXML
    public void initialize() {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();
        MenuEntryService menuEntryService = ApplicationContext.getInstance().getMenuEntryService();

        ObservableList<String> artistNames;

        try {
            Artist[] artists = libraryDAO.loadArtists();
            artistNames = Arrays.stream(artists).map(Artist::getName).collect(Collectors.toCollection(FXCollections::observableArrayList));
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load track list!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            artistNames = FXCollections.observableArrayList();
        }

        artistsListView.setItems(artistNames);
    }

}
