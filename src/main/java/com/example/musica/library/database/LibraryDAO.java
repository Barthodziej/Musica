package com.example.musica.library.database;

import com.example.musica.library.Album;
import com.example.musica.library.Artist;
import com.example.musica.library.Release;
import com.example.musica.library.Track;

public interface LibraryDAO {

    Artist[] loadArtists() throws Exception;
    Artist loadArtist(String id) throws Exception;
    void saveArtist(Artist artist) throws Exception;
    void deleteArtist(String id) throws Exception;

    Album[] loadAlbums() throws Exception;
    Album loadAlbum(String id) throws Exception;
    void saveAlbum(Album album) throws Exception;
    void deleteAlbum(String id) throws Exception;

    Release[] loadReleases() throws Exception;
    Release loadRelease(String id) throws Exception;
    void saveRelease(Release release) throws Exception;
    void deleteRelease(String id) throws Exception;

    Track[] loadTracks() throws Exception;
    Track loadTrack(String id) throws Exception;
    void saveTrack(Track track) throws Exception;
    void deleteTrack(String id) throws Exception;
}
