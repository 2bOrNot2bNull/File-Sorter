package org.example;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtility {
    static final String MUSIC_IDENTIFIER = "Music";
    static final String DOCUMENTS_IDENTIFIER = "Documents";
    static final String PICTURES_IDENTIFIER = "Pictures";
    static final String INSTALLERS_PATH = "Installers";
    static final String VIDEOS_PATH = "Videos";
    static final String ZIP_FILES_PATH = "Zip Files";
    static final String MISC_FILES_PATH = "Miscellaneous";


    public static boolean checkIfPathIsValid(String path) {
        Path downloadPath = Paths.get(path);
        if (Files.exists(downloadPath)) {
            System.out.println("Path exists and is valid");
            return true;
        } else {
            System.out.println("Path is invalid");
            System.out.println("Aborting!");
            return false;
        }
    }

    public static boolean checkIfPathContainsFiles(String path){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        long numberOfFiles = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                numberOfFiles++;
            }
        }
        System.out.println("Files found are: "+numberOfFiles);
        return numberOfFiles > 0;
    }


    public static void createFolderDirectories(String path) throws IOException {
        Files.createDirectories(Path.of(FilenameUtils.concat(path, MUSIC_IDENTIFIER)));
        Files.createDirectories(Path.of(FilenameUtils.concat(path, DOCUMENTS_IDENTIFIER)));
        Files.createDirectories(Path.of(FilenameUtils.concat(path, PICTURES_IDENTIFIER)));
        Files.createDirectories(Path.of(FilenameUtils.concat(path, INSTALLERS_PATH)));
        Files.createDirectories(Path.of(FilenameUtils.concat(path, VIDEOS_PATH)));
        Files.createDirectories(Path.of(FilenameUtils.concat(path, ZIP_FILES_PATH)));
        Files.createDirectories(Path.of(FilenameUtils.concat(path, MISC_FILES_PATH)));
        System.out.println("Folders ready");
    }
}
