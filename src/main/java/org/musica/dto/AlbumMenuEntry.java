package org.musica.dto;

import java.nio.file.Path;

public class AlbumMenuEntry {

    private String ID;
    private Path coverPath;
    private String title;
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

    public String[] getArtistNames() {
        return artistNames;
    }

    public void setArtistNames(String[] artistNames) {
        this.artistNames = artistNames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String artistName : artistNames) {
            sb.append(artistName).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" - ").append(title);
        return sb.toString();
    }

}
