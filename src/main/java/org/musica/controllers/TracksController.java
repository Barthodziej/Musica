package org.musica.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.musica.ApplicationContext;
import org.musica.liblistcells.TrackListCell;
import org.musica.database.LibraryDAO;
import org.musica.dto.TrackMenuEntry;
import org.musica.services.MenuEntryService;

public class TracksController {

    @FXML
    ListView<TrackMenuEntry> tracksListView;

    @FXML
    public void initialize() {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();
        MenuEntryService menuEntryService = ApplicationContext.getInstance().getMenuEntryService();

        ObservableList<TrackMenuEntry> trackMenuEntries;

        try {
            trackMenuEntries = FXCollections.observableArrayList(menuEntryService.getTrackMenuEntries());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load track list!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            trackMenuEntries = FXCollections.observableArrayList();
        }

        tracksListView.setItems(trackMenuEntries);
        tracksListView.setCellFactory(_ -> new TrackListCell());

    }

}
