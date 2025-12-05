package org.musica;

import org.musica.config.Config;
import org.musica.config.ConfigInitializer;
import org.musica.config.ConfigPathProvider;
import org.musica.database.FilesystemLibraryDAO;
import org.musica.database.LibraryDAO;
import org.musica.database.filesystemlibrary.LibraryPathProvider;
import org.musica.database.filesystemlibrary.LibraryPathProviderImpl;

public class ApplicationContext {

    private final ConfigPathProvider configPathProvider;
    private final ConfigInitializer configInitializer;
    private final Config config;
    private final LibraryPathProvider libraryPathProvider;
    private final LibraryDAO libraryDAO;

    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {

        configPathProvider = new ConfigPathProvider();
        configInitializer = new ConfigInitializer(configPathProvider);
        config = new Config(configPathProvider);
        libraryPathProvider = new LibraryPathProviderImpl(config);
        libraryDAO = new FilesystemLibraryDAO(libraryPathProvider);

    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public ConfigInitializer getConfigInitializer() {
        return configInitializer;
    }

    public LibraryDAO getLibraryDAO() {
        return libraryDAO;
    }

    public Config getConfig() {
        return config;
    }

}
