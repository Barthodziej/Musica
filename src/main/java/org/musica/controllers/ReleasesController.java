package org.musica.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.musica.ApplicationContext;
import org.musica.database.LibraryDAO;
import org.musica.dto.AlbumMenuEntry;
import org.musica.dto.ReleaseMenuEntry;
import org.musica.liblistcells.AlbumListCell;
import org.musica.liblistcells.ReleaseListCell;
import org.musica.services.MenuEntryService;

public class ReleasesController {

    @FXML
    ListView<ReleaseMenuEntry> releasesListView;

    @FXML
    public void initialize() {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();
        MenuEntryService menuEntryService = ApplicationContext.getInstance().getMenuEntryService();

        ObservableList<ReleaseMenuEntry> releaseMenuEntries;

        try {
            releaseMenuEntries = FXCollections.observableArrayList(menuEntryService.getReleaseMenuEntries());
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load album list!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            releaseMenuEntries = FXCollections.observableArrayList();
        }

        releasesListView.setItems(releaseMenuEntries);
        releasesListView.setCellFactory(listView -> new ReleaseListCell());

    }

}
