package lights.digital.commandline;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandLineTest {

//Test for singleton

    @Test
    void singletonClassTest() {
        //Arrange
        CommandLine commandLine1 = CommandLine.getInstance();
        CommandLine commandLine2 = CommandLine.getInstance();
        CommandLine commandLine3 = CommandLine.getInstance();

        //Act + Assert
        assertTrue(commandLine1 == commandLine2);
        assertTrue(commandLine1 == commandLine3);
    }


    @Test
    void checkNotThrowingExceptionWhenDataIsNotCorrect() {
        CommandLine commandLine = CommandLine.getInstance();

        //Arrange
        String line = "R\n3\nsomeText\n100\ncircle 3\nexit";

        System.setIn(new ByteArrayInputStream(line.getBytes()));

        //Act + Assert
        assertDoesNotThrow(() -> commandLine.run());
    }

}