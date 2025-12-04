package com.example.musica.library.database;

import com.example.musica.library.Album;
import com.example.musica.library.Artist;
import com.example.musica.library.Release;
import com.example.musica.library.Track;

import java.io.IOException;

public interface LibraryDAO {

    Artist[] loadArtists() throws Exception;
    Artist loadArtist(String id) throws IOException;
    void saveArtist(Artist artist);
    void deleteArtist(String id);

    Album[] loadAlbums() throws Exception;
    Album loadAlbum(String id);
    void saveAlbum(Album album);
    void deleteAlbum(String id);

    Release[] loadReleases() throws Exception;
    Release loadRelease(String id);
    void saveRelease(Release release);
    void deleteRelease(String id);

    Track[] loadTracks();
    Track loadTrack(String id);
    void saveTrack(Track track);
    void deleteTrack(String id);
}
