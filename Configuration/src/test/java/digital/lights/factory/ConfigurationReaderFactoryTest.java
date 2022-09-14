package digital.lights.factory;


import digital.lights.Utils.PublicConfigurationReaderFactory;
import digital.lights.configuration.Configuration;
import digital.lights.parser.CmdParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationReaderFactoryTest {

    @Test
    void createAssertFileDoesNotExists()
            throws ParseException {
        //Arrange
        String[] args = {"--configuration=resources//my_confi.xml"};
        String expectedLogPath = "C:\\Temp";
        String expectedLogLevel = "WARN";


        CommandLine cmd = CmdParser.parse(args);

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    Configuration configuration = ConfigurationReaderFactory.crete(cmd);
                });
        assertEquals("File does not exists!", exception.getMessage());
    }

    @Test
    void createAssertCorrectConfigurationPerimetersXmlFileGiven()
            throws ParseException {
        //Arrange
        String[] args = {"--configuration=resources\\my_config.xml"};
        String expectedLogPath = "C:\\Temp";
        String expectedLogLevel = "WARN";

        CommandLine cmd = CmdParser.parse(args);

        //Act
        Configuration configuration = ConfigurationReaderFactory.crete(cmd);


        //Arrange
        assertTrue(expectedLogPath.equals(configuration.getLogFilePath()));
        assertTrue(expectedLogLevel.equals(configuration.getLogLevel()));
    }

    @Test
    void createAssertCorrectConfigurationPerimetersIniFileGiven()
            throws ParseException {
        //Arrange
        String[] args = {"--configuration=resources\\config.ini"};
        String expectedLogPath = "C:\\Temp";
        String expectedLogLevel = "WARN";

        CommandLine cmd = CmdParser.parse(args);

        //Act
        Configuration configuration = ConfigurationReaderFactory.crete(cmd);

        //Arrange
        assertTrue(expectedLogPath.equals(configuration.getLogFilePath()));
        assertTrue(expectedLogLevel.equals(configuration.getLogLevel()));
    }

    @Test
    void firstLetterToUpperAssertCorrectOutput() {
        //Arrange
        String xml = "xml";
        String expected = "Xml";
        //Act + Assert
        assertEquals(expected, PublicConfigurationReaderFactory.firstLetterToUpper(xml));
    }

    @Test
    void firstLetterToUpperAssertEmptyString() {
        //Arrange
        String xml = "";


        String expectedMessage = "Not correct line!";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {

                    PublicConfigurationReaderFactory.firstLetterToUpper(xml);

                });
        //Assert
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void firstLetterToUpperAssertNullString() {
        //Arrange
        String xml = null;

        //Act + Assert
        assertThrows(NullPointerException.class,
                () -> {
                    PublicConfigurationReaderFactory.firstLetterToUpper(xml);
                });
    }

    @Test
    void getFileTypeAssertValidPath() throws ParseException {
        //Arrange
        String[] args = {"--configuration=resources//my_config.xml"};
        CommandLine cmd = CmdParser.parse(args);

        String expected = "xml";
        //Act
        String actual = PublicConfigurationReaderFactory.getFileType(cmd);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getFileTypeAssertNotValidPath() throws ParseException {
        //Arrange
        String[] args = {"--configuration=resources//my_config.xml?"};
        CommandLine cmd = CmdParser.parse(args);

        String expected = "Not correct path!";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    PublicConfigurationReaderFactory.getFileType(cmd);
                });
        String actual = exception.getMessage();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getFileTypeAssertNoExtensionGiven() throws ParseException {
        String[] args = {"--configuration=resources//my_config"};
        CommandLine cmd = CmdParser.parse(args);

        String expected = "Not correct extension!";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    PublicConfigurationReaderFactory.getFileType(cmd);
                });
        String actual = exception.getMessage();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getFileTypeAssertFileDoesNotExists() throws ParseException {
        String[] args = {"--configuration=resources//my_config.unknown"};
        CommandLine cmd = CmdParser.parse(args);

        String expected = "File does not exists!";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    PublicConfigurationReaderFactory.getFileType(cmd);
                });
        String actual = exception.getMessage();
        //Assert
        assertEquals(expected, actual);
    }
}