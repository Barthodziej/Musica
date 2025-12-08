package org.musica.database;

import org.musica.entities.Album;
import org.musica.entities.Artist;
import org.musica.entities.Release;
import org.musica.entities.Track;

public interface LibraryDAO {

    Artist[] loadArtists() throws Exception;
    Artist loadArtist(String id) throws Exception;
    void saveArtist(Artist artist) throws Exception;
    void deleteArtist(String id) throws Exception;
    String loadArtistAvatarPath(String albumID) throws Exception;

    Album[] loadAlbums() throws Exception;
    Album loadAlbum(String id) throws Exception;
    void saveAlbum(Album album) throws Exception;
    void deleteAlbum(String id) throws Exception;
    String loadAlbumCoverPath(String albumID) throws Exception;

    Release[] loadReleases() throws Exception;
    Release loadRelease(String id) throws Exception;
    void saveRelease(Release release) throws Exception;
    void deleteRelease(String id) throws Exception;

    Track[] loadTracks() throws Exception;
    Track loadTrack(String id) throws Exception;
    void saveTrack(Track track) throws Exception;
    void deleteTrack(String id) throws Exception;
}
