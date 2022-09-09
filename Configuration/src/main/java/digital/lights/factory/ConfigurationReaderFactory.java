package digital.lights.factory;

import digital.lights.configuration.Configuration;
import org.apache.commons.cli.CommandLine;

import java.lang.reflect.InvocationTargetException;

public class ConfigurationReaderFactory {

    private static String getFileType(CommandLine cmd) {
        String[] line = cmd.getOptionValue("c").split("\\.");
        return line[line.length - 1];
    }

    private static String firstLetterToUpper(String line) {
        return line.substring(0, 1).toUpperCase() + line.substring(1);
    }

    public static Configuration crete(CommandLine cmd) {

        String fileExtension = firstLetterToUpper(getFileType(cmd));

        String className = "digital.lights.factory." + fileExtension + "ConfigurationReader";
        ConfigurationReader configurationReader;
        try {
            Class<?> configuration = Class.forName(className);
            configurationReader = (ConfigurationReader) configuration.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException("File type not found!");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return configurationReader.create(cmd);
    }

}
