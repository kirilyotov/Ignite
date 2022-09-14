package digital.lights.factory;


import digital.lights.configuration.Configuration;
import org.apache.commons.cli.CommandLine;

import java.lang.reflect.InvocationTargetException;

import static digital.lights.path.validator.PathValidator.*;

public class ConfigurationReaderFactory {

    private static String firstLetterToUpper(String line) {
        return line.substring(0, 1).toUpperCase() + line.substring(1);
    }

    private static String getFileType(CommandLine cmd) {
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


    public static Configuration crete(CommandLine cmd) {
        String fileExtension = firstLetterToUpper(getFileType(cmd));

        String className = ConfigurationReader.class.getPackageName() + "." + fileExtension +
                ConfigurationReader.class.getSimpleName();

        ConfigurationReader configurationReader;

        try {
            Class<?> configuration = Class.forName(className);
            configurationReader = (ConfigurationReader) configuration.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException("File type not found!");
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Problem with reading file!");
        }

        return configurationReader.create(cmd);
    }

}
