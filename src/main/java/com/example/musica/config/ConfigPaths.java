package com.example.musica.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigPaths {
    public Path rootPath() {
        return Paths.get(".");
    }
    public Path configDirectoryPath() {
        return rootPath().resolve("config");
    }
    public Path mediaConfigFilePath() {
        return configDirectoryPath().resolve("media.txt");
    }
    public Path dataConfigFilePath() {
        return configDirectoryPath().resolve("data.txt");
    }
}
