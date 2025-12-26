package org.musica.dto;

import java.nio.file.Path;

public class ArtistMenuEntry {

    private String ID;
    private Path avatarPath;
    private String name;
    private int albumsCount;
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Path getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(Path avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlbumsCount() {
        return albumsCount;
    }

    public void setAlbumsCount(int albumsCount) {
        this.albumsCount = albumsCount;
    }
}
