package org.musica.entities;
import java.io.Serializable;

public class Artist implements Serializable {
    private String id;
    private String name;
    private String[] genres;
    private String[] albumIds;

    public Artist() {
        id = "";
        name = "";
        genres = new String[0];
        albumIds = new String[0];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String[] getAlbumIds() {
        return albumIds;
    }

    public void setAlbumIds(String[] albumIds) {
        this.albumIds = albumIds;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Artist name: ").append(getName()).append(" [").append(getId()).append("]\n");
        sb.append("Album IDs:\n");
        for (String albumId : getAlbumIds()) {
            sb.append("- [").append(albumId).append("]\n");
        }
        sb.append("Genres:\n");
        for (String genre : getGenres()) {
            sb.append("- ").append(genre).append("\n");
        }
        return sb.toString();
    }
}
