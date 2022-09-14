package digital.lights.path.validator;


import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class PathValidator {
    public static boolean hasExtension(String path) {
        return getExtension(path) != "";
    }

    public static String getExtension(String fileName) {
        return FilenameUtils.getExtension(fileName);
    }

    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }

    public static boolean fileExists(String path) {
        File tempFile = new File(path);
        return tempFile.exists();
    }
}
