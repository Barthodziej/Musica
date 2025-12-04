package com.example.musica.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Config {

    public void initialize() throws Exception {

        if (isInitialized()) {
            throw new Exception("Failed to initialize config. Reason: It is already initialized!");
        }

        createConfigDirectory();
        createMediaConfigFile();
        createDataConfigFile();

    }

    public boolean isInitialized() {

        ConfigPaths configPaths = new ConfigPaths();
        return configPaths.configDirectoryPath().toFile().exists();

    }

    private void createConfigDirectory() throws Exception {

        ConfigPaths configPaths = new ConfigPaths();
        File configDirectory = configPaths.configDirectoryPath().toFile();

        if (configDirectory.exists()) {
            throw new Exception("Failed to create config directory. Reason: It already exists!");
        }

        if (!configDirectory.mkdir()) {
            throw new Exception("Failed to create config directory. Reason: Unknown...");
        }

    }

    private void createMediaConfigFile() throws Exception {

        ConfigPaths configPaths = new ConfigPaths();
        File mediaConfigFile = configPaths.mediaConfigFilePath().toFile();

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

    public String loadMediaConfig() throws Exception {

        ConfigPaths configPaths = new ConfigPaths();
        File mediaConfigFile = configPaths.mediaConfigFilePath().toFile();

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
            return scanner.nextLine();
        }

    }

    public void saveMediaConfig(String mediaConfig) throws Exception {

        ConfigPaths configPaths = new ConfigPaths();
        File mediaConfigFile = configPaths.mediaConfigFilePath().toFile();

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
        }
        catch (IOException e) {
            throw new Exception("Failed to save media config. Reason: Unknown...");
        }

    }

    private void createDataConfigFile() throws Exception {

        ConfigPaths configPaths = new ConfigPaths();
        File dataConfigFile = configPaths.dataConfigFilePath().toFile();

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

    public String loadDataConfig() throws Exception {

        ConfigPaths configPaths = new ConfigPaths();
        File dataConfigFile = configPaths.dataConfigFilePath().toFile();

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
            return scanner.nextLine();
        }

    }

    public void saveDataConfig(String dataConfig) throws Exception {

        ConfigPaths configPaths = new ConfigPaths();
        File dataConfigFile = configPaths.dataConfigFilePath().toFile();

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
        }
        catch (IOException e) {
            throw new Exception("Failed to save data config. Reason: Unknown...");
        }

    }

}
