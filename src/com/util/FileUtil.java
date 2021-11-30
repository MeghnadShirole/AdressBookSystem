package com.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileUtil {

    String filePath;
    Path path;

    public FileUtil(String filePath) {
        this.filePath = filePath;
        path = Paths.get(filePath);
    }

    public List<String> readDataFromFile() throws IOException {
        return Files.readAllLines(path);
    }

    public void writeData(String data) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
    }
}