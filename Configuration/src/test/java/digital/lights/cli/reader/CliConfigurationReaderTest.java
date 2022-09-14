package digital.lights.cli.reader;

import digital.lights.configuration.Configuration;
import digital.lights.parser.CmdParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CliConfigurationReaderTest {
    String logLevel = "warn";

    String[] createArgs(String logPath) {
        return new String[]{"--log-path=" + logPath, "--log-level=" + logLevel};
    }

    @Test
    void createAssertCorrectParameters() throws ParseException {
        //Arrange
        String expectedLogPath = "C:\\Temp";
        String[] args = createArgs(expectedLogPath);

        //Act
        CommandLine cmd = CmdParser.parse(args);
        Configuration configuration = CliConfigurationReader.create(cmd);

        //Assert
        assertTrue(expectedLogPath.contains(configuration.getLogFilePath()));
        assertTrue(logLevel.contains(configuration.getLogLevel()));
    }

    @Test
    void createAssertNotCorrectLogPathQuestionMarkInPath() throws ParseException {
        //Arrange
        String expectedLogPath = "C:\\Temp?";
        String[] args = createArgs(expectedLogPath);

        CommandLine cmd = CmdParser.parse(args);
        String expectedMessage = "Not correct logFilePath!";
        //Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    //Act
                    Configuration configuration = CliConfigurationReader.create(cmd);
                });
        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void createAssertNotCorrectLogPathEmptyStringGiven() throws ParseException {
        //Arrange
        String expectedLogPath = "";
        String[] args = createArgs(expectedLogPath);

        CommandLine cmd = CmdParser.parse(args);
        String expectedMessage = "Not correct logFilePath!";
        //Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    //Act
                    Configuration configuration = CliConfigurationReader.create(cmd);
                });
        String actualMessage = exception.getMessage();

        //Assert
        assertEquals(expectedMessage, actualMessage);
    }

}