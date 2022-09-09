package digital.lights.factory;

import digital.lights.configuration.Configuration;
import digital.lights.parser.CmdParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

interface ConfigurationReaderTest {
    ConfigurationReader configurationReader();

    String[] args();

    String expectedLogPath();

    String expectedLogLevel();

    @Test
    default void createAssertCorrectConfigurationPerimeters(String[] args, String s, String expectedLogLevel) throws ParseException {
        //Arrange
        CommandLine cmd = CmdParser.parse(args());

        //Act
        Configuration configuration = configurationReader().create(cmd);

        //Arrange
        assertTrue(expectedLogPath().equals(configuration.getLogFilePath()));
        assertTrue(expectedLogLevel().equals(configuration.getLogLevel()));
    }


}