package com.example.musica.library.database.filesystemlibrary;

public interface ResourcePaths {
    String getArtistListPath();
    String getAlbumListPath();
    String getReleaseListPath();
    String getTrackListPath();
    String getArtistDataPath(String artistId);
    String getAlbumDataPath(String albumId);
    String getAlbumCoverPath(String albumId);
    String getReleaseDataPath(String releaseId);
    String getReleaseCoverPath(String releaseId);
    String getTrackDataPath(String trackId);
    String getTrackLyricsPath(String trackId);
}
