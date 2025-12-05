/*
package org.musica.library;

import org.musica.config.Config;
import org.musica.config.ConfigPaths;
import org.musica.library.database.FilesystemLibraryDAO;
import org.musica.library.database.LibraryDAO;
import org.musica.library.database.filesystemlibrary.SimpleResourcePaths;

import java.util.stream.Stream;

public class LibrarySummarizer {

    private String formatDuration(int duration) {
        int seconds = duration % 60;
        int minutes = (duration / 60) % 60;
        int hours = duration / 3600;
        if (hours > 0) {
            String ss = (seconds < 10 ? "0" : "") + Integer.toString(seconds);
            String mm = (minutes < 10 ? "0" : "") + Integer.toString(minutes);
            String hh = Integer.toString(hours);
            return hh + ":" + mm + ":" + ss;
        }
        else {
            String ss = (seconds < 10 ? "0" : "") + Integer.toString(seconds);
            String mm = Integer.toString(minutes);
            return mm + ":" + ss;
        }
    }
    public String getReleaseData(String releaseId) {
        Config config = new Config();
        try {
            LibraryDAO libraryDAO = new FilesystemLibraryDAO(new SimpleResourcePaths(config.loadMediaConfig()));

            Release release = libraryDAO.loadRelease(releaseId);
            Track[] tracks = Stream.of(release.getTrackIds()).map(libraryDAO::loadTrack).toArray(Track[]::new);
            Album album = libraryDAO.loadAlbum(release.getAlbumId());
            Artist[] artists = Stream.of(album.getArtistIds()).map(libraryDAO::loadArtist).toArray(Artist[]::new);

            StringBuilder sb = new StringBuilder();

            sb.append("Release info:\n\n");
            for (Artist artist : artists) {
                sb.append(artist.getName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(" - ").append(album.getTitle()).append(" (").append(release.getDuration()).append(")\n");
            sb.append("Country: ").append(release.getCountry()).append("\n");
            sb.append("Label: ").append(release.getLabel()).append("\n");
            sb.append("Release date: ").append(release.getReleaseDate()).append("\n");
            sb.append(release.getFormat()).append(" (").append(release.getPackaging()).append(")").append("\n");
            sb.append("\n");
            sb.append(tracks.length).append(" tracks:\n");
            for (Track track : tracks) {
                sb.append("- ").append(track.getTitle()).append(" (").append(formatDuration(track.getDuration())).append(")\n");
            }
            return sb.toString();
        }
        catch (Exception e) {
            return "";
        }
    }

}

*/
