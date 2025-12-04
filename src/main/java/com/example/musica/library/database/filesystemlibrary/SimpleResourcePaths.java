package com.example.musica.library.database.filesystemlibrary;

public class SimpleResourcePaths implements ResourcePaths {

    // TODO: Do

    String libraryPath;

    public SimpleResourcePaths(String libraryPath) {
        this.libraryPath = libraryPath;
    }

    private String getArtistsPath() {
        return libraryPath + "/Artists";
    }

    private String getAlbumsPath() {
        return libraryPath + "/Albums";
    }

    private String getReleasesPath() {
        return libraryPath + "/Releases";
    }

    private String getTracksPath() {
        return libraryPath + "/Tracks";
    }

    @Override
    public String getArtistListPath() {
        return getArtistsPath() + "/list.txt";
    }

    @Override
    public String getAlbumListPath() {
        return getAlbumsPath() + "/list.txt";
    }

    @Override
    public String getReleaseListPath() {
        return getReleasesPath() + "/list.txt";
    }

    @Override
    public String getTrackListPath() {
        return getTracksPath() + "/list.txt";
    }

    @Override
    public String getArtistDataPath(String artistId) {
        return getArtistsPath() + "/" + artistId + "/data.json";
    }

    @Override
    public String getAlbumDataPath(String albumId) {
        return getAlbumsPath() + "/" + albumId + "/data.json";
    }

    @Override
    public String getAlbumCoverPath(String albumId) {
        return getAlbumsPath() + "/" + albumId + "/cover.png";
    }

    @Override
    public String getReleaseDataPath(String releaseId) {
        return getReleasesPath() + "/" + releaseId + "/data.json";
    }

    @Override
    public String getReleaseCoverPath(String releaseId) {
        return getReleasesPath() + "/" + releaseId + "/cover.png";
    }

    @Override
    public String getTrackDataPath(String trackId) {
        return getTracksPath() + "/" + trackId + "/data.json";
    }

    @Override
    public String getTrackLyricsPath(String trackId) {
        return getTracksPath() + "/" + trackId + "/lyrics.lrc";
    }
}
