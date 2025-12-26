package org.musica.database;

import org.musica.entities.Album;
import org.musica.entities.Artist;
import org.musica.entities.Release;
import org.musica.entities.Track;
import org.musica.database.filesystemlibrary.LibraryPathProvider;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.NotImplementedException;

public class FilesystemLibraryDAO implements LibraryDAO {

    LibraryPathProvider libraryPathProvider;

    public FilesystemLibraryDAO(LibraryPathProvider libraryPathProvider) {
        this.libraryPathProvider = libraryPathProvider;
    }

    @Override
    public Artist[] loadArtists() throws Exception {

        Path artistListPath = libraryPathProvider.getArtistListPath();

        try (Stream<String> lines = Files.lines(artistListPath)) {

            String[] artistIDs = lines.toArray(String[]::new);

            Artist[] artists = new Artist[artistIDs.length];
            for (int i  = 0; i < artistIDs.length; i++) {
                artists[i] = loadArtist(artistIDs[i]);
            }

            return artists;

        }
        catch (Exception e) {
            System.out.println("Couldn't load the artist list file!");
            System.out.println(e.getMessage());
        }
        return new Artist[0];
    }

    @Override
    public Artist loadArtist(String id) throws Exception {

        Path artistDataPath = libraryPathProvider.getArtistDataPath(id);
        File artistDataFile = artistDataPath.toFile();

        if (!artistDataFile.exists()) {
            throw new IllegalArgumentException("Artist data directory does not exist.");
        }

        Artist artist = new Artist();

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readerForUpdating(artist).readValue(artistDataFile);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return artist;
    }

    @Override
    public void saveArtist(Artist artist) throws Exception  {
        Path artistDataPath = libraryPathProvider.getArtistDataPath(artist.getId());
        try {
            File artistDataFile = artistDataPath.toFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(artistDataFile, artist);
        }
        catch (Exception e) {
            System.out.println("Couldn't save the artist data!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteArtist(String id) {
        // TODO: Do
        throw new NotImplementedException();
    }

    @Override
    public Path loadArtistAvatarPath(String artistID) throws Exception {
        return libraryPathProvider.getArtistAvatarPath(artistID);
    }

    @Override
    public Album[] loadAlbums() throws Exception {

        Path albumListPath = libraryPathProvider.getAlbumListPath();

        try (Stream<String> lines = Files.lines(albumListPath)) {

            String[] albumIDs = lines.toArray(String[]::new);

            Album[] albums = new Album[albumIDs.length];
            for (int i  = 0; i < albumIDs.length; i++) {
                albums[i] = loadAlbum(albumIDs[i]);
            }

            return albums;

        }
        catch (Exception e) {
            System.out.println("Couldn't load the album list file!");
            System.out.println(e.getMessage());
        }
        return new Album[0];
    }

    @Override
    public Album loadAlbum(String id) throws Exception {

        Path albumDataPath = libraryPathProvider.getAlbumDataPath(id);
        File albumDataFile = albumDataPath.toFile();

        if (!albumDataFile.exists()) {
            throw new IllegalArgumentException("Album data directory does not exist.");
        }

        Album album = new Album();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readerForUpdating(album).readValue(albumDataFile);
        }
        catch (Exception e) {
            System.out.println("Couldn't load the album data file!");
            System.out.println(e.getMessage());
        }
        return album;
    }

    @Override
    public void saveAlbum(Album album) throws Exception {
        try {
            File albumDataFile = libraryPathProvider.getAlbumDataPath(album.getId()).toFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(albumDataFile, album);
        }
        catch (Exception e) {
            System.out.println("Couldn't save the album data!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAlbum(String id) throws Exception {
        // TODO: Do
        throw new NotImplementedException();
    }

    @Override
    public Path loadAlbumCoverPath(String albumID) throws Exception {
        return libraryPathProvider.getAlbumCoverPath(albumID);
    }

    @Override
    public Release[] loadReleases() throws Exception {
        Path releaseListPath = libraryPathProvider.getReleaseListPath();

        try (Stream<String> lines = Files.lines(releaseListPath)) {

            String[] releaseIDs = lines.toArray(String[]::new);

            Release[] releases = new Release[releaseIDs.length];
            for (int i  = 0; i < releaseIDs.length; i++) {
                releases[i] = loadRelease(releaseIDs[i]);
            }

            return releases;

        }
        catch (Exception e) {
            System.out.println("Couldn't load the release list file!");
            System.out.println(e.getMessage());
        }
        return new Release[0];
    }

    @Override
    public Release loadRelease(String id) throws Exception {

        Path releaseDataPath = libraryPathProvider.getReleaseDataPath(id);
        File releaseDataFile = releaseDataPath.toFile();

        if (!releaseDataFile.exists()) {
            throw new IllegalArgumentException("Release data directory does not exist.");
        }

        Release release = new Release();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readerForUpdating(release).readValue(releaseDataFile);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return release;
    }

    @Override
    public void saveRelease(Release release) throws Exception {
        try {
            File releaseDataFile = libraryPathProvider.getReleaseDataPath(release.getId()).toFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(releaseDataFile, release);
        }
        catch (Exception e) {
            System.out.println("Couldn't save the release data!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRelease(String id) throws Exception {
        // TODO: Do
        throw new NotImplementedException();
    }

    @Override
    public Path loadReleaseCoverPath(String releaseID) throws Exception {
        return libraryPathProvider.getReleaseCoverPath(releaseID);
    }

    @Override
    public Track[] loadTracks() throws Exception {

        Path trackListPath = libraryPathProvider.getTrackListPath();

        try (Stream<String> lines = Files.lines(trackListPath)) {

            String[] trackIDs = lines.toArray(String[]::new);

            Track[] tracks = new Track[trackIDs.length];
            for (int i  = 0; i < trackIDs.length; i++) {
                tracks[i] = loadTrack(trackIDs[i]);
            }

            return tracks;

        }
        catch (Exception e) {
            System.out.println("Couldn't load the track list file!");
            System.out.println(e.getMessage());
        }
        return new Track[0];
    }

    @Override
    public Track loadTrack(String trackId) throws Exception {

        Path trackDataPath = libraryPathProvider.getTrackDataPath(trackId);
        File trackDataFile = trackDataPath.toFile();

        if (!trackDataFile.exists()) {
            throw new IllegalArgumentException("Track data directory does not exist.");
        }

        Track track = new Track();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readerForUpdating(track).readValue(trackDataFile);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return track;
    }

    @Override
    public void saveTrack(Track track) throws Exception {
        Path trackDataPath = libraryPathProvider.getTrackDataPath(track.getId());
        File trackDataFile = trackDataPath.toFile();
        if (!trackDataFile.exists()) {
            if (!trackDataFile.getParentFile().exists() && !trackDataFile.getParentFile().mkdirs()) {
                System.out.println("Couldn't make parent directories!");
            }
            try {
                trackDataFile.createNewFile();
            }
            catch (Exception e) {
                System.out.println("Couldn't create .json file!");
                System.out.println(e.getMessage());
            }

        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(trackDataFile, track);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteTrack(String id) throws Exception {
        // TODO: Do
        throw new NotImplementedException();
    }
}
