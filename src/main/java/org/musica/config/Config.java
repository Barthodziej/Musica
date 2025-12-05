package org.musica.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Config {

    ConfigPathProvider configPathProvider;
    String mediaPath = null;
    String dataPath = null;


    public Config(ConfigPathProvider configPathProvider) {
        this.configPathProvider = configPathProvider;
    }

    public String loadMediaConfig() throws Exception {

        if (mediaPath != null) {
            return mediaPath;
        }

        File mediaConfigFile = configPathProvider.mediaConfigFilePath().toFile();

        if (!mediaConfigFile.exists()) {
            throw new Exception("Failed to load media config. Reason: The file does not exist!");
        }

        if (!mediaConfigFile.isFile()) {
            throw new Exception("Failed to load media config. Reason: The file is not a file!");
        }

        if (!mediaConfigFile.canRead()) {
            throw new Exception("Failed to load media config. Reason: The file is not readable!");
        }

        try (Scanner scanner = new Scanner(mediaConfigFile)) {
            mediaPath = scanner.nextLine();
            return mediaPath;
        }

    }

    public void saveMediaConfig(String mediaConfig) throws Exception {

        File mediaConfigFile = configPathProvider.mediaConfigFilePath().toFile();

        if (!mediaConfigFile.exists()) {
            throw new Exception("Failed to save media config. Reason: The file does not exist!");
        }

        if (!mediaConfigFile.isFile()) {
            throw new Exception("Failed to save media config. Reason: The file is not a file!");
        }

        if (!mediaConfigFile.canWrite()) {
            throw new Exception("Failed to save media config. Reason: The file is not writeable!");
        }

        try (FileWriter writer = new FileWriter(mediaConfigFile)) {
            writer.write(mediaConfig);
            mediaPath = mediaConfig;
        }
        catch (IOException e) {
            throw new Exception("Failed to save media config. Reason: Unknown...");
        }

    }

    public String loadDataConfig() throws Exception {

        if (dataPath != null) {
            return dataPath;
        }

        File dataConfigFile = configPathProvider.dataConfigFilePath().toFile();

        if (!dataConfigFile.exists()) {
            throw new Exception("Failed to load data config. Reason: The file does not exist!");
        }

        if (!dataConfigFile.isFile()) {
            throw new Exception("Failed to load data config. Reason: The file is not a file!");
        }

        if (!dataConfigFile.canRead()) {
            throw new Exception("Failed to load data config. Reason: The file is not readable!");
        }

        try (Scanner scanner = new Scanner(dataConfigFile)) {
            dataPath = scanner.nextLine();
            return dataPath;
        }

    }

    public void saveDataConfig(String dataConfig) throws Exception {

        File dataConfigFile = configPathProvider.dataConfigFilePath().toFile();

        if (!dataConfigFile.exists()) {
            throw new Exception("Failed to save data config. Reason: The file does not exist!");
        }

        if (!dataConfigFile.isFile()) {
            throw new Exception("Failed to save data config. Reason: The file is not a file!");
        }

        if (!dataConfigFile.canWrite()) {
            throw new Exception("Failed to save data config. Reason: The file is not writeable!");
        }

        try (FileWriter writer = new FileWriter(dataConfigFile)) {
            writer.write(dataConfig);
            dataPath = dataConfig;
        }
        catch (IOException e) {
            throw new Exception("Failed to save data config. Reason: Unknown...");
        }

    }

}
