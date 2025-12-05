package com.example.musica.library.database.filesystemlibrary;

public interface LibraryPathProvider {
    String getArtistListPath() throws Exception;
    String getAlbumListPath() throws Exception;
    String getReleaseListPath() throws Exception;
    String getTrackListPath() throws Exception;
    String getArtistDataPath(String artistId) throws Exception;
    String getAlbumDataPath(String albumId) throws Exception;
    String getAlbumCoverPath(String albumId) throws Exception;
    String getReleaseDataPath(String releaseId) throws Exception;
    String getReleaseCoverPath(String releaseId) throws Exception;
    String getTrackDataPath(String trackId) throws Exception;
    String getTrackLyricsPath(String trackId) throws Exception;
}
