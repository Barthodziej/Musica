package org.musica.database.filesystemlibrary;

import org.musica.config.Config;
import java.nio.file.Paths;
import java.nio.file.Path;

public class LibraryPathProviderImpl implements LibraryPathProvider {

    Config config;

    public LibraryPathProviderImpl(Config config) {
        this.config = config;
    }

    private Path getArtistsPath() throws Exception {
        return Paths.get(config.loadDataConfig()).resolve("Artists");
    }

    private Path getArtistPath(String artistID) throws Exception {
        return getArtistsPath().resolve(artistID);
    }

    private Path getAlbumsPath() throws Exception {
        return Paths.get(config.loadDataConfig()).resolve("Albums");
    }

    private Path getAlbumPath(String albumID) throws Exception {
        return getAlbumsPath().resolve(albumID);
    }

    private Path getReleasesPath() throws Exception {
        return Paths.get(config.loadDataConfig()).resolve("Releases");
    }

    private Path getReleasePath(String releaseID) throws Exception {
        return getReleasesPath().resolve(releaseID);
    }

    private Path getTracksPath() throws Exception {
        return Paths.get(config.loadDataConfig()).resolve("Tracks");
    }

    private Path getTrackPath(String trackID) throws Exception {
        return getTracksPath().resolve(trackID);
    }

    @Override
    public Path getArtistListPath() throws Exception {
        return getArtistsPath().resolve("list.txt");
    }

    @Override
    public Path getAlbumListPath() throws Exception {
        return getAlbumsPath().resolve("list.txt");
    }

    @Override
    public Path getReleaseListPath() throws Exception {
        return getReleasesPath().resolve("list.txt");
    }

    @Override
    public Path getTrackListPath() throws Exception {
        return getTracksPath().resolve("list.txt");
    }

    @Override
    public Path getArtistDataPath(String artistID) throws Exception {
        return getArtistPath(artistID).resolve("data.json");
    }

    @Override
    public Path getArtistAvatarPath(String artistID) throws Exception {
        return getArtistPath(artistID).resolve("avatar.jpg");
    }

    @Override
    public Path getAlbumDataPath(String albumID) throws Exception {
        return getAlbumPath(albumID).resolve("data.json");
    }

    @Override
    public Path getAlbumCoverPath(String albumID) throws Exception {
        return getAlbumPath(albumID).resolve("cover.png");
    }

    @Override
    public Path getReleaseDataPath(String releaseID) throws Exception {
        return getReleasePath(releaseID).resolve("data.json");
    }

    @Override
    public Path getReleaseCoverPath(String releaseID) throws Exception {
        return getReleasePath(releaseID).resolve("cover.png");
    }

    @Override
    public Path getTrackDataPath(String trackID) throws Exception {
        return getTrackPath(trackID).resolve("data.json");
    }

    @Override
    public Path getTrackLyricsPath(String trackID) throws Exception {
        return getTrackPath(trackID).resolve("lyrics.lrc");
    }
}
