package digital.lights.cli.reader;

import digital.lights.configuration.Configuration;
import digital.lights.parser.CmdParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CliConfigurationReaderTest {
    @Test
    void createAssertCorrectParameters() throws ParseException {
        //Arrange
        String expectedLogPath = "C:\\Temp";
        String expectedLogLevel = "warn";
        String[] args = {"--log-path=" + expectedLogLevel, "--log-level=" + expectedLogPath};

        //Act
        CommandLine cmd = CmdParser.parse(args);
        Configuration configuration = CliConfigurationReader.create(cmd);

        //Assert
        assertTrue(expectedLogPath.contains(configuration.getLogFilePath()));
        assertTrue(expectedLogLevel.contains(configuration.getLogLevel()));
    }
}