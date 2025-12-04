package com.example.musica.library;

import java.io.Serializable;

public class Track implements Serializable {

    private String id;
    private String title;
    private String releaseId;
    private String[] artistIds;
    private boolean hasLyrics;
    private int duration;
    private String[] genres;
    private String file;

    public Track() {
        id = "";
        title = "";
        releaseId = "";
        artistIds = new String[0];
        hasLyrics = false;
        duration = 0;
        genres = new String[0];
        file = "";
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

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public String[] getArtistIds() {
        return artistIds;
    }

    public void setArtistIds(String[] artistIds) {
        this.artistIds = artistIds;
    }

    public boolean isHasLyrics() {
        return hasLyrics;
    }

    public void setHasLyrics(boolean hasLyrics) {
        this.hasLyrics = hasLyrics;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Track title: ").append(title).append(" [").append(id).append("]\n");
        builder.append("Artists:\n");
        for (String artist : artistIds) {
            builder.append("- [").append(artist).append("]\n");
        }
        builder.append("Release: [").append(releaseId).append("]").append("\n");
        builder.append("Genres:\n");
        for (String genre : genres) {
            builder.append("- [").append(genre).append("]\n");
        }
        return builder.toString();
    }
}
