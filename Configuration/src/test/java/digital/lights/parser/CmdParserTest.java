package digital.lights.parser;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CmdParserTest {
    @Test
    void parse_AssertLogFileWithMoreThanOnePoint() {
        //Arrange
        String[] args = {"--log-level=warn", "--log-file=path.to.xml.xml"};
        String expectedMessage = "Unrecognized option: --log-file=path.to.xml.xml";

        //Act
        Exception exception = assertThrows(UnrecognizedOptionException.class,
                () ->
                {
                    CmdParser.parse(args);
                });
        String actualMessage = exception.getMessage();

        //Assert
        assertTrue(expectedMessage.contains(actualMessage));
    }

    @Test
    void parse_AssertNotGivenAllOptionsThrowsIllegalArgumentException() {
        //Arrange
        String[] args1 = {"--log-path=C:\\Temp"};
        String[] args2 = {"--log-level=warn"};
        String expectedMessage = "Not correct input!";

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,
                () ->
                {
                    CmdParser.getInstance(CmdParser.parse(args1));
                    CmdParser.getInstance(CmdParser.parse(args2));
                });
        //Assert
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));
    }

    @Test
    void parseAssertCorrectCommandLine() {
        //Arrange
        String[] args = {"--log-path=C:\\Temp", "--log-level=warn"};

        //Act + Assert
        assertDoesNotThrow(() -> CmdParser.parse(args));
    }

    @Test
    void getInstance_AssertNotCorrectCommandLineOptionThrowsIllegalArgumentException() {
        //Arrange
        String[] args = {"--unknown=config.ini"};
        //Act + Assert
        Exception exception = assertThrows(UnrecognizedOptionException.class,
                () ->
                {
                    CommandLine cmd = CmdParser.parse(args);
                });
    }
}