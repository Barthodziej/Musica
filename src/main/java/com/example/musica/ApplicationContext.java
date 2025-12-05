package com.example.musica;

import com.example.musica.config.Config;
import com.example.musica.config.ConfigInitializer;
import com.example.musica.config.ConfigPathProvider;
import com.example.musica.library.database.FilesystemLibraryDAO;
import com.example.musica.library.database.LibraryDAO;
import com.example.musica.library.database.filesystemlibrary.LibraryPathProvider;
import com.example.musica.library.database.filesystemlibrary.LibraryPathProviderImpl;

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
