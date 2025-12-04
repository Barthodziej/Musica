package com.example.musica;

import com.example.musica.config.Config;
import com.example.musica.library.Album;
import com.example.musica.library.Artist;
import com.example.musica.library.Release;
import com.example.musica.library.Track;
import com.example.musica.library.database.FilesystemLibraryDAO;
import com.example.musica.library.database.filesystemlibrary.SimpleResourcePaths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.Arrays;
import java.util.LinkedList;
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

        Config config = new Config();


        ObservableList<String> artistNames;

        try {
            FilesystemLibraryDAO filesystemLibraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
            Artist[] artists = filesystemLibraryDAO.loadArtists();

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
            FilesystemLibraryDAO filesystemLibraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
            Album[] albums = filesystemLibraryDAO.loadAlbums();

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
            FilesystemLibraryDAO filesystemLibraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
            Track[] tracks = filesystemLibraryDAO.loadTracks();

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
