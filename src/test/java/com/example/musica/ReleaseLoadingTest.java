package com.example.musica;

import com.example.musica.config.Config;
import com.example.musica.library.Release;
import com.example.musica.library.database.FilesystemLibraryDAO;
import com.example.musica.library.database.LibraryDAO;
import com.example.musica.library.database.filesystemlibrary.SimpleResourcePaths;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReleaseLoadingTest {

    String releaseId = "7f40da94-f18a-4dad-8145-8cd835cdab72";

    @Test
    public void invalidNameThrowsException() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        assertThrows(IllegalArgumentException.class, () -> libraryDAO.loadRelease("szczur"));

    }

    @Test
    public void isNotNull() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        Release actual = libraryDAO.loadRelease(releaseId);

        assertNotNull(actual);

    }

    @Test
    public void loadsId() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = releaseId;
        String actual = libraryDAO.loadRelease(releaseId).getId();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsAlbumId() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "e8d1d6de-3f41-4556-86d3-d5b287e870f0";
        String actual = libraryDAO.loadRelease(releaseId).getAlbumId();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsCountry() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "United Kingdom";
        String actual = libraryDAO.loadRelease(releaseId).getCountry();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsLabel() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "Peaceville";
        String actual = libraryDAO.loadRelease(releaseId).getLabel();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsReleaseDate() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "2006-11-06";
        String actual = libraryDAO.loadRelease(releaseId).getReleaseDate();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsFormat() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "CD";
        String actual = libraryDAO.loadRelease(releaseId).getFormat();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsPackaging() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "Jewel Case";
        String actual = libraryDAO.loadRelease(releaseId).getPackaging();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsHasCover() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        Boolean expected = true;
        Boolean actual = libraryDAO.loadRelease(releaseId).isHasCover();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsTrackIds() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String[] expected = {
                "2c8ae407-d979-4e4e-9c35-d19aa6609339",
                "a9a90433-4060-40f3-b65d-d3c782fd0185",
                "fe7ff2ba-6c7b-457c-b6db-ef2b75971a8e",
                "f9f9c31d-5772-4393-b47f-0a0659887c93",
                "ae0cf757-94ec-4e48-9f4e-1d0088aa1913",
                "1ed20de1-6047-4021-83f6-6650d77472c4",
                "4ce388c5-9bee-4df7-9676-368a41b94912",
                "7d13bca4-cecd-49ae-8195-2cca01cf1913",
                "254bf340-3aca-404f-a0ed-cc57d5564543"
        };
        String[] actual = libraryDAO.loadRelease(releaseId).getTrackIds();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void loadsDuration() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "1:00:10";
        String actual = libraryDAO.loadRelease(releaseId).getDuration();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsGenres() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String[] expected = {
                "Death Doom Metal",
                "Gothic Metal"
        };
        String[] actual = libraryDAO.loadRelease(releaseId).getGenres();

        assertArrayEquals(expected, actual);

    }

}
