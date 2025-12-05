package org.musica.config;

import java.io.File;
import java.io.IOException;

public class ConfigInitializer {

    ConfigPathProvider configPathProvider;

    public ConfigInitializer(ConfigPathProvider configPathProvider) {

        this.configPathProvider = configPathProvider;

    }

    public void initialize() throws Exception {

        if (isInitialized()) {
            throw new Exception("Failed to initialize config. Reason: It is already initialized!");
        }

        createConfigDirectory();
        createMediaConfigFile();
        createDataConfigFile();

    }

    public boolean isInitialized() {

        return configPathProvider.configDirectoryPath().toFile().exists();

    }

    private void createConfigDirectory() throws Exception {

        File configDirectory = configPathProvider.configDirectoryPath().toFile();

        if (configDirectory.exists()) {
            throw new Exception("Failed to create config directory. Reason: It already exists!");
        }

        if (!configDirectory.mkdir()) {
            throw new Exception("Failed to create config directory. Reason: Unknown...");
        }

    }

    private void createMediaConfigFile() throws Exception {

        File mediaConfigFile = configPathProvider.mediaConfigFilePath().toFile();

        if (mediaConfigFile.exists()) {
            throw new Exception("Failed to create media config file. Reason: It already exists!");
        }

        try {
            if (!mediaConfigFile.createNewFile()) {
                throw new Exception("Failed to create media config file. Reason: Unknown...");
            }
        }
        catch (IOException e) {
            throw new Exception("Failed to create media config file. Reason: Unknown...");
        }

    }

    private void createDataConfigFile() throws Exception {

        File dataConfigFile = configPathProvider.dataConfigFilePath().toFile();

        if (dataConfigFile.exists()) {
            throw new Exception("Failed to create data config file. Reason: It already exists!");
        }

        try {
            if (!dataConfigFile.createNewFile()) {
                throw new Exception("Failed to create data config file. Reason: Unknown...");
            }
        }
        catch (IOException e) {
            throw new Exception("Failed to create data config file. Reason: Unknown...");
        }

    }
}
