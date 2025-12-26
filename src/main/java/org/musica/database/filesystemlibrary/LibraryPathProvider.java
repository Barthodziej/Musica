package org.musica.database.filesystemlibrary;

import java.nio.file.Path;

public interface LibraryPathProvider {
     Path getArtistListPath() throws Exception;
     Path getAlbumListPath() throws Exception;
     Path getReleaseListPath() throws Exception;
     Path getTrackListPath() throws Exception;
     Path getArtistDataPath(String artistId) throws Exception;
     Path getArtistAvatarPath(String artistId) throws Exception;
     Path getAlbumDataPath(String albumId) throws Exception;
     Path getAlbumCoverPath(String albumId) throws Exception;
     Path getReleaseDataPath(String releaseId) throws Exception;
     Path getReleaseCoverPath(String releaseId) throws Exception;
     Path getTrackDataPath(String trackId) throws Exception;
     Path getTrackLyricsPath(String trackId) throws Exception;
}
