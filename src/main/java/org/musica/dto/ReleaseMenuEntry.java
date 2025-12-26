package org.musica.dto;

import java.nio.file.Path;

public class ReleaseMenuEntry {

    private String ID;
    private Path coverPath;
    private String title;
    private String releaseDate;
    private String[] artistNames;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Path getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(Path coverPath) {
        this.coverPath = coverPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String[] getArtistNames() {
        return artistNames;
    }

    public void setArtistNames(String[] artistNames) {
        this.artistNames = artistNames;
    }
}
