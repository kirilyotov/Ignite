package digital.lights.factory;

import digital.lights.configuration.Configuration;
import org.apache.commons.cli.CommandLine;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

public class ConfigurationReaderFactory {

    //TODO: Move checks in other class and make tests!
    //TODO: Create custom exception!

    private static boolean hasExtension(String line, int index){
        String extension = line.substring(index).trim();
        return Pattern.matches("^[.]\\w*$", extension);
    }

    //Possible character list a-z, A-Z, \, /, .,
    private static boolean isCorrectPath(String line){
        return Pattern.matches("^\\s*[.\\w\\s\\\\/]*\\s*$", line);
    }

    private static boolean hasSymbolsAfterDot(String line, int index){
        return  index > 0 && index != line.length();
    }
    private static String firstLetterToUpper(String line) {
        return line.substring(0, 1).toUpperCase() + line.substring(1);
    }

    private static String getFileType(CommandLine cmd) {
        String line = cmd.getOptionValue("c");
        int index = line.lastIndexOf(".");

        if(!isCorrectPath(line)){
            throw new IllegalArgumentException("Not correct path!");
        }

        if(!hasSymbolsAfterDot(line, index) || !hasExtension(line, index)){
            throw new IllegalArgumentException("Not correct extension!");
        }

        return line.substring(index + 1);
    }


    public static Configuration crete(CommandLine cmd) {

        String fileExtension = firstLetterToUpper(getFileType(cmd));

        String className = ConfigurationReader.class.getPackageName() + fileExtension +
                ConfigurationReader.class.getName() ;

        ConfigurationReader configurationReader;

        try {
            Class<?> configuration = Class.forName(className);
            configurationReader = (ConfigurationReader) configuration.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException("File type not found!");
        } catch (InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return configurationReader.create(cmd);
    }

}
