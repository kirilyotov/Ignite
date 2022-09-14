package digital.lights.Utils;

import org.apache.commons.cli.CommandLine;

import static digital.lights.path.validator.PathValidator.*;

public class PublicConfigurationReaderFactory {

    public static String firstLetterToUpper(String line) {
        if (line.length() < 2)
            throw new IllegalArgumentException("Not correct line!");
        return line.substring(0, 1).toUpperCase() + line.substring(1);
    }

    public static String getFileType(CommandLine cmd) {
        String line = cmd.getOptionValue("c");

        if (!isValidPath(line)) {
            throw new IllegalArgumentException("Not correct path!");
        }

        if (!hasExtension(line)) {
            throw new IllegalArgumentException("Not correct extension!");
        }
        if (!fileExists(line)) {
            throw new IllegalArgumentException("File does not exists!");
        }
        return getExtension(line);
    }

}
