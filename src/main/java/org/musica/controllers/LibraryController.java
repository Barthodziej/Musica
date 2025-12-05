package org.musica.controllers;

import org.musica.ApplicationContext;
import org.musica.library.Album;
import org.musica.library.Artist;
import org.musica.library.Track;
import org.musica.library.database.LibraryDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LibraryController {

    @FXML
    ListView<String> artistsListView;
    @FXML
    ListView<String> albumsListView;
    @FXML
    ListView<String> releasesListView;
    @FXML
    ListView<String> tracksListView;


    @FXML
    public void initialize() {

        ObservableList<String> artistNames;

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        try {
            Artist[] artists = libraryDAO.loadArtists();
            artistNames = Arrays.stream(artists).map(Artist::getName).collect(Collectors.toCollection(FXCollections::observableArrayList));
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load track list!");
            alert.setContentText(e.getMessage());

            artistNames = FXCollections.observableArrayList();
        }

        artistsListView.setItems(artistNames);


        ObservableList<String> albumNames;

        try {
            Album[] albums = libraryDAO.loadAlbums();
            albumNames = Arrays.stream(albums).map(Album::getTitle).collect(Collectors.toCollection(FXCollections::observableArrayList));
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load album list!");
            alert.setContentText(e.getMessage());

            albumNames = FXCollections.observableArrayList();
        }

        albumsListView.setItems(albumNames);


        ObservableList<String> trackNames;

        try {
            Track[] tracks = libraryDAO.loadTracks();
            trackNames = Arrays.stream(tracks).map(Track::getTitle).collect(Collectors.toCollection(FXCollections::observableArrayList));
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Could not load track list!");
            alert.setContentText(e.getMessage());

            trackNames = FXCollections.observableArrayList();
        }

        tracksListView.setItems(trackNames);
    }


}
