package org.example;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.apache.commons.io.FileUtils.moveFileToDirectory;
import static org.example.FileUtility.*;

public class ExtensionSortImpl implements SorterInterface {
    public String extensionBasedSort(String path) throws IOException {
        if (checkIfPathIsValid(path) && checkIfPathContainsFiles(path)) {
            createFolderDirectories(path);
            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();
            assert listOfFiles != null;
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String extension = FilenameUtils.getExtension(String.valueOf(file));
                    System.out.println(extension);

                    switch (extension) {
                        case "mp3", "aac", "ogg", "opus", "m4a", "flac", "alac", "ape", "wav", "aiff":
                            moveFileToDirectory(file, new File(String.valueOf(Path.of(FilenameUtils.concat(path, MUSIC_IDENTIFIER)))), false);
                            break;
                        case "pdf", "doc", "docx", "txt", "rtf", "odt", "ppt", "pptx", "xls", "xlsx", "html", "xml",
                             "csv":
                            moveFileToDirectory(file, new File(String.valueOf(Path.of(FilenameUtils.concat(path, DOCUMENTS_IDENTIFIER)))), false);
                            break;
                        case "jpeg", "jpg", "png", "gif", "tiff", "bmp", "raw", "psd", "svg", "heic", "webp":
                            moveFileToDirectory(file, new File(String.valueOf(Path.of(FilenameUtils.concat(path, PICTURES_IDENTIFIER)))), false);
                            break;
                        case "exe", "msi", "deb", "rpm", "apk", "dmg", "pkg":
                            moveFileToDirectory(file, new File(String.valueOf(Path.of(FilenameUtils.concat(path, INSTALLERS_PATH)))), false);
                            break;
                        case "mp4", "mov", "wmv", "avi", "mkv", "flv", "m4v", "3gp", "mts", "m2ts":
                            moveFileToDirectory(file, new File(String.valueOf(Path.of(FilenameUtils.concat(path, VIDEOS_PATH)))), false);
                            break;
                        case "zip", "rar", "7z", "tar", "tar.gz", "gz", "bz2", "xz", "z", "cab":
                            moveFileToDirectory(file, new File(String.valueOf(Path.of(FilenameUtils.concat(path, ZIP_FILES_PATH)))), false);
                            break;
                        default:
                            moveFileToDirectory(file, new File(String.valueOf(Path.of(FilenameUtils.concat(path, MISC_FILES_PATH)))), false);
                            break;
                    }
                }
            }
        }

        return "";
    }
}
