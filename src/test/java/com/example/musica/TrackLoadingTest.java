package com.example.musica;

import org.musica.ApplicationContext;
import org.musica.entities.Track;
import org.musica.database.LibraryDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackLoadingTest {

    String trackId = "2c8ae407-d979-4e4e-9c35-d19aa6609339";

    @Test
    public void invalidNameThrowsException() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        assertThrows(IllegalArgumentException.class, () -> libraryDAO.loadTrack("szczur"));

    }

    @Test
    public void isNotNull() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        Track actual = libraryDAO.loadTrack(trackId);

        assertNotNull(actual);

    }

    @Test
    public void loadsId() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        String expected = trackId;
        String actual = libraryDAO.loadTrack(trackId).getId();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsTitle() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        String expected = "Brave";
        String actual = libraryDAO.loadTrack(trackId).getTitle();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsReleaseId() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        String expected = "7f40da94-f18a-4dad-8145-8cd835cdab72";
        String actual = libraryDAO.loadTrack(trackId).getReleaseId();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsArtistIds() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        String[] expected = {
                "2638d1d6-47a4-42fb-9a70-782aaf48e14f"
        };
        String[] actual = libraryDAO.loadTrack(trackId).getArtistIds();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void loadsHasLyrics() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        boolean expected = false;
        boolean actual = libraryDAO.loadTrack(trackId).isHasLyrics();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsDuration() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        int expected = 619;
        int actual = libraryDAO.loadTrack(trackId).getDuration();

        assertEquals(expected, actual);

    }

    @Test
    public void loadsGenres() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        String[] expected = {
                "Death Doom Metal",
                "Gothic Metal"
        };
        String[] actual = libraryDAO.loadTrack(trackId).getGenres();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void loadsFile() throws Exception {

        LibraryDAO libraryDAO = ApplicationContext.getInstance().getLibraryDAO();

        String expected = "Katatonia/Brave-Murder-Day/Brave.mp3";
        String actual = libraryDAO.loadTrack(trackId).getFile();

        assertEquals(expected, actual);

    }

}