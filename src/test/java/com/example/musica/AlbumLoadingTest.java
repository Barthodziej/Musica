package com.example.musica;

import com.example.musica.config.Config;
import com.example.musica.library.Album;
import com.example.musica.library.database.FilesystemLibraryDAO;
import com.example.musica.library.database.LibraryDAO;
import com.example.musica.library.database.filesystemlibrary.SimpleResourcePaths;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumLoadingTest {

    @Test
    public void invalidNameThrowsException() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
        assertThrows(IllegalArgumentException.class, () -> libraryDAO.loadAlbum("szczur"));

    }

    @Test
    public void isNotNull() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
        Album actual = libraryDAO.loadAlbum("e8d1d6de-3f41-4556-86d3-d5b287e870f0");
        assertNotNull(actual);

    }

    @Test
    public void loadsId() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "e8d1d6de-3f41-4556-86d3-d5b287e870f0";
        String actual = libraryDAO.loadAlbum("e8d1d6de-3f41-4556-86d3-d5b287e870f0").getId();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsTitle() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String expected = "Brave Murder Day";
        String actual = libraryDAO.loadAlbum("e8d1d6de-3f41-4556-86d3-d5b287e870f0").getTitle();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsArtistIds() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String[] expected = new String[] {
                "2638d1d6-47a4-42fb-9a70-782aaf48e14f"
        };
        String[] actual = libraryDAO.loadAlbum("e8d1d6de-3f41-4556-86d3-d5b287e870f0").getArtistIds();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void loadsHasCover() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        boolean expected = true;
        boolean actual = libraryDAO.loadAlbum("e8d1d6de-3f41-4556-86d3-d5b287e870f0").isHasCover();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsGenres() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String[] expected = new String[] {
                "Death Doom Metal",
                "Gothic Metal"
        };
        String[] actual = libraryDAO.loadAlbum("e8d1d6de-3f41-4556-86d3-d5b287e870f0").getGenres();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void loadsReleaseIds() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));

        String[] expected = new String[] {
                "7f40da94-f18a-4dad-8145-8cd835cdab72"
        };
        String[] actual = libraryDAO.loadAlbum("e8d1d6de-3f41-4556-86d3-d5b287e870f0").getReleaseIds();

        assertArrayEquals(expected, actual);

    }

}
