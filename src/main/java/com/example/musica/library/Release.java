package com.example.musica.library;

import org.apache.commons.lang3.NotImplementedException;

import java.io.Serializable;

public class Release implements Serializable {
    private String id;
    private String albumId;
    private String country;
    private String label;
    private String releaseDate;
    private String format;
    private String packaging;
    private boolean hasCover;
    private String[] trackIds;
    private String duration;
    private String[] genres;

    public Release() {
        id = "";
        albumId = "";
        country = "";
        label = "";
        releaseDate = "";
        format = "";
        packaging = "";
        hasCover = false;
        trackIds = new String[0];
        duration = "";
        genres = new String[0];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public boolean isHasCover() {
        return hasCover;
    }

    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }

    public String[] getTrackIds() {
        return trackIds;
    }

    public void setTrackIds(String[] trackIds) {
        this.trackIds = trackIds;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String toString() {
        // TODO: Do
        throw new NotImplementedException();
    }
}
