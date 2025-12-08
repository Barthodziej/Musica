package org.musica.services;

import org.musica.database.LibraryDAO;
import org.musica.dto.AlbumMenuEntry;
import org.musica.dto.TrackMenuEntry;
import org.musica.entities.Album;
import org.musica.entities.Artist;
import org.musica.entities.Track;

import java.util.Arrays;

public class MenuEntryService {

    LibraryDAO libraryDAO;

    public MenuEntryService(LibraryDAO libraryDAO) {
        this.libraryDAO = libraryDAO;
    }

    public TrackMenuEntry getTrackMenuEntry(String trackID) throws Exception {

        Track track = libraryDAO.loadTrack(trackID);

        String[] artistIDs = track.getArtistIds();
        Artist[] artists = new Artist[artistIDs.length];
        for (int i = 0; i < artistIDs.length; i++) {
            artists[i] = libraryDAO.loadArtist(artistIDs[i]);
        }

        TrackMenuEntry trackMenuEntry = new TrackMenuEntry();
        trackMenuEntry.setTitle(track.getTitle());
        trackMenuEntry.setArtistNames(Arrays.stream(artists).map(Artist::getName).toArray(String[]::new));

        return trackMenuEntry;

    }

    public TrackMenuEntry[] getTrackMenuEntries() throws Exception {

        Track[] tracks = libraryDAO.loadTracks();

        TrackMenuEntry[] trackMenuEntries = new TrackMenuEntry[tracks.length];
        for (int i = 0; i < tracks.length; i++) {
            String[] artistIDs = tracks[i].getArtistIds();
            Artist[] artists = new Artist[artistIDs.length];
            for (int j = 0; j < artistIDs.length; j++) {
                artists[j] = libraryDAO.loadArtist(artistIDs[j]);
            }
            trackMenuEntries[i] = new TrackMenuEntry();
            trackMenuEntries[i].setTitle(tracks[i].getTitle());
            trackMenuEntries[i].setArtistNames(Arrays.stream(artists).map(Artist::getName).toArray(String[]::new));
        }
        return trackMenuEntries;
    }

    public AlbumMenuEntry getAlbumMenuEntry(String albumID) throws Exception {

        Album album = libraryDAO.loadAlbum(albumID);
        String coverPath = libraryDAO.loadAlbumCoverPath(albumID);

        String[] artistIDs = album.getArtistIds();
        Artist[] artists = new Artist[artistIDs.length];
        for (int i = 0; i < artistIDs.length; i++) {
            artists[i] = libraryDAO.loadArtist(artistIDs[i]);
        }

        AlbumMenuEntry albumMenuEntry = new AlbumMenuEntry();
        albumMenuEntry.setCoverPath(coverPath);
        albumMenuEntry.setTitle(album.getTitle());
        albumMenuEntry.setArtistNames(Arrays.stream(artists).map(Artist::getName).toArray(String[]::new));

        return albumMenuEntry;

    }

    public AlbumMenuEntry[] getAlbumMenuEntries() throws Exception {

        Album[] albums = libraryDAO.loadAlbums();

        AlbumMenuEntry[] albumMenuEntries = new AlbumMenuEntry[albums.length];
        for (int i = 0; i < albums.length; i++) {
            String coverPath = libraryDAO.loadAlbumCoverPath(albums[i].getId());
            String[] artistIDs = albums[i].getArtistIds();
            Artist[] artists = new Artist[artistIDs.length];
            for (int j = 0; j < artistIDs.length; j++) {
                artists[j] = libraryDAO.loadArtist(artistIDs[j]);
            }
            albumMenuEntries[i] = new AlbumMenuEntry();
            albumMenuEntries[i].setCoverPath(coverPath);
            albumMenuEntries[i].setTitle(albums[i].getTitle());
            albumMenuEntries[i].setArtistNames(Arrays.stream(artists).map(Artist::getName).toArray(String[]::new));
        }
        return albumMenuEntries;
    }
}
