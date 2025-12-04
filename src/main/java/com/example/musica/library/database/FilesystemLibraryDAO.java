package com.example.musica.library.database;

import com.example.musica.library.Album;
import com.example.musica.library.Artist;
import com.example.musica.library.Release;
import com.example.musica.library.Track;
import com.example.musica.library.database.filesystemlibrary.ResourcePaths;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.NotImplementedException;

public class FilesystemLibraryDAO implements LibraryDAO {

    ResourcePaths resourcePaths;

    public FilesystemLibraryDAO(ResourcePaths resourcePaths) {
        this.resourcePaths = resourcePaths;
    }

    @Override
    public Artist[] loadArtists() {
        String artistListPath = resourcePaths.getArtistListPath();
        try {
            return Files.lines(Paths.get(artistListPath)).map(this::loadArtist).toArray(Artist[]::new);
        }
        catch (Exception e) {
            System.out.println("Couldn't load the artist list file!");
            System.out.println(e.getMessage());
        }
        return new Artist[0];
    }

    @Override
    public Artist loadArtist(String id) throws IllegalArgumentException {

        String artistDataPath = resourcePaths.getArtistDataPath(id);
        File artistDataFile = new File(artistDataPath);

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
    public void saveArtist(Artist artist) {
        String artistDataPath = resourcePaths.getArtistDataPath(artist.getId());
        try {
            File artistDataFile = new File(artistDataPath);
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
    public Album[] loadAlbums() {
        String albumListPath = resourcePaths.getAlbumListPath();
        try {
            return Files.lines(Paths.get(albumListPath)).map(this::loadAlbum).toArray(Album[]::new);
        }
        catch (Exception e) {
            System.out.println("Couldn't load the album list file!");
            System.out.println(e.getMessage());
        }
        return new Album[0];
    }

    @Override
    public Album loadAlbum(String id) {

        String albumDataPath = resourcePaths.getAlbumDataPath(id);
        File albumDataFile = new File(albumDataPath);

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
    public void saveAlbum(Album album) {
        try {
            File albumDataFile = new File(resourcePaths.getAlbumDataPath(album.getId()));
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(albumDataFile, album);
        }
        catch (Exception e) {
            System.out.println("Couldn't save the album data!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteAlbum(String id) {
        // TODO: Do
        throw new NotImplementedException();
    }

    @Override
    public Release[] loadReleases() {
        String releaseListPath = resourcePaths.getReleaseListPath();
        try {
            return Files.lines(Paths.get(releaseListPath)).map(this::loadRelease).toArray(Release[]::new);
        }
        catch (Exception e) {
            System.out.println("Couldn't load the release list file!");
            System.out.println(e.getMessage());
        }
        return new Release[0];
    }

    @Override
    public Release loadRelease(String id) {

        String releaseDataPath = resourcePaths.getReleaseDataPath(id);
        File releaseDataFile = new File(releaseDataPath);

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
    public void saveRelease(Release release) {
        try {
            File releaseDataFile = new File(resourcePaths.getReleaseDataPath(release.getId()));
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(releaseDataFile, release);
        }
        catch (Exception e) {
            System.out.println("Couldn't save the release data!");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRelease(String id) {
        // TODO: Do
        throw new NotImplementedException();
    }

    @Override
    public Track[] loadTracks() {
        String trackListPath = resourcePaths.getTrackListPath();
        try {
            return Files.lines(Paths.get(trackListPath)).map(this::loadTrack).toArray(Track[]::new);
        }
        catch (Exception e) {
            System.out.println("Couldn't load the track list file!");
            System.out.println(e.getMessage());
        }
        return new Track[0];
    }

    @Override
    public Track loadTrack(String trackId) {

        String trackDataPath = resourcePaths.getTrackDataPath(trackId);
        File trackDataFile = new File(trackDataPath);

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
    public void saveTrack(Track track) {
        String trackDataPath = resourcePaths.getTrackDataPath(track.getId());
        File trackDataFile = new File(trackDataPath);
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
    public void deleteTrack(String id) {
        // TODO: Do
        throw new NotImplementedException();
    }
}
