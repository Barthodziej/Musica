package com.example.musica.library;

import java.io.Serializable;

public class Album implements Serializable {
    private String id;
    private String title;
    private String[] artistIds;
    private boolean hasCover;
    private String[] genres;
    private String[] releaseIds;

    public Album() {
        id = "";;
        title = "";
        artistIds = new String[0];
        hasCover = false;
        genres = new String[0];
        releaseIds = new String[0];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getArtistIds() {
        return artistIds;
    }

    public void setArtistIds(String[] artistIds) {
        this.artistIds = artistIds;
    }

    public boolean isHasCover() {
        return hasCover;
    }

    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String[] getReleaseIds() {
        return releaseIds;
    }

    public void setReleaseIds(String[] releaseIds) {
        this.releaseIds = releaseIds;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Album title: ").append(getTitle()).append(" [").append(getId()).append("]\n");
        sb.append("Artist IDs:\n");
        for (String artistId : getArtistIds()) {
            sb.append("- [").append(artistId).append("]\n");
        }
        sb.append("Release IDs:\n");
        for (String releaseId : getReleaseIds()) {
            sb.append("- [").append(releaseId).append("]\n");
        }
        sb.append("Has cover?: ").append(isHasCover()).append("\n");
        sb.append("Genres:\n");
        for (String genre : getGenres()) {
            sb.append("- ").append(genre).append("\n");
        }
        return sb.toString();
    }
}
