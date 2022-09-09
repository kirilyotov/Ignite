package digital.lights.factory;

import digital.lights.configuration.Configuration;
import digital.lights.parser.CmdParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfigurationReaderFactoryTest {
    @Test
    void createAssertCorrectConfigurationPerimeters()
            throws ParseException {
        String[] args1 = {"--configuration=config.ini"};
        String[] args2 = {"--configuration=my_config.xml"};
        String expectedLogPath = "C:\\Temp";
        String expectedLogLevel = "WARN";

        //Arrange
        CommandLine cmd1 = CmdParser.parse(args1);
        CommandLine cmd2 = CmdParser.parse(args2);

        //Act
        Configuration configuration1 = ConfigurationReaderFactory.crete(cmd1);
        Configuration configuration2 = ConfigurationReaderFactory.crete(cmd2);

        //Arrange
        assertTrue(expectedLogPath.equals(configuration1.getLogFilePath()));
        assertTrue(expectedLogLevel.equals(configuration1.getLogLevel()));

        assertTrue(expectedLogPath.equals(configuration2.getLogFilePath()));
        assertTrue(expectedLogLevel.equals(configuration2.getLogLevel()));
    }
}