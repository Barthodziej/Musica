package com.example.musica;

import com.example.musica.config.Config;
import com.example.musica.library.Artist;
import com.example.musica.library.database.FilesystemLibraryDAO;
import com.example.musica.library.database.LibraryDAO;
import com.example.musica.library.database.filesystemlibrary.SimpleResourcePaths;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistLoadingTest {

    @Test
    public void invalidNameThrowsException() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
        assertThrows(IllegalArgumentException.class, () -> libraryDAO.loadArtist("szczur"));

    }

    @Test
    public void isNotNull() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
        Artist actual = libraryDAO.loadArtist("2638d1d6-47a4-42fb-9a70-782aaf48e14f");
        assertNotNull(actual);

    }

    @Test
    public void loadsId() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
        String actual = libraryDAO.loadArtist("2638d1d6-47a4-42fb-9a70-782aaf48e14f").getId();
        assertEquals("2638d1d6-47a4-42fb-9a70-782aaf48e14f", actual);

    }

    @Test
    public void loadsName() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
        String actual = libraryDAO.loadArtist("2638d1d6-47a4-42fb-9a70-782aaf48e14f").getName();
        assertEquals("Katatonia", actual);

    }

    @Test
    public void loadsGenres() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
        String[] actual = libraryDAO.loadArtist("2638d1d6-47a4-42fb-9a70-782aaf48e14f").getGenres();
        String[] expected = new String[] {
                "Alternative Metal",
                "Alternative Rock",
                "Progressive Metal",
                "Gothic Metal",
                "Death Doom Metal",
                "Melodic Black Metal"
        };
        assertArrayEquals(expected, actual);

    }

    @Test
    public void loadsAlbumIds() throws Exception {

        Config config = new Config();
        LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadDataConfig()));
        String[] actual = libraryDAO.loadArtist("2638d1d6-47a4-42fb-9a70-782aaf48e14f").getAlbumIds();
        String[] expected = new String[] {
                "e8d1d6de-3f41-4556-86d3-d5b287e870f0"
        };
        assertArrayEquals(expected, actual);

    }

}
