package com.example.musica.library.database.filesystemlibrary;

import com.example.musica.config.Config;

public class LibraryPathProviderImpl implements LibraryPathProvider {

    Config config;

    public LibraryPathProviderImpl(Config config) {
        this.config = config;
    }

    private String getArtistsPath() throws Exception {
        return config.loadDataConfig() + "/Artists";
    }

    private String getAlbumsPath() throws Exception {
        return config.loadDataConfig() + "/Albums";
    }

    private String getReleasesPath() throws Exception {
        return config.loadDataConfig() + "/Releases";
    }

    private String getTracksPath() throws Exception {
        return config.loadDataConfig() + "/Tracks";
    }

    @Override
    public String getArtistListPath() throws Exception {
        return getArtistsPath() + "/list.txt";
    }

    @Override
    public String getAlbumListPath() throws Exception {
        return getAlbumsPath() + "/list.txt";
    }

    @Override
    public String getReleaseListPath() throws Exception {
        return getReleasesPath() + "/list.txt";
    }

    @Override
    public String getTrackListPath() throws Exception {
        return getTracksPath() + "/list.txt";
    }

    @Override
    public String getArtistDataPath(String artistId) throws Exception {
        return getArtistsPath() + "/" + artistId + "/data.json";
    }

    @Override
    public String getAlbumDataPath(String albumId) throws Exception {
        return getAlbumsPath() + "/" + albumId + "/data.json";
    }

    @Override
    public String getAlbumCoverPath(String albumId) throws Exception {
        return getAlbumsPath() + "/" + albumId + "/cover.png";
    }

    @Override
    public String getReleaseDataPath(String releaseId) throws Exception {
        return getReleasesPath() + "/" + releaseId + "/data.json";
    }

    @Override
    public String getReleaseCoverPath(String releaseId) throws Exception {
        return getReleasesPath() + "/" + releaseId + "/cover.png";
    }

    @Override
    public String getTrackDataPath(String trackId) throws Exception {
        return getTracksPath() + "/" + trackId + "/data.json";
    }

    @Override
    public String getTrackLyricsPath(String trackId) throws Exception {
        return getTracksPath() + "/" + trackId + "/lyrics.lrc";
    }
}
