package digital.lights.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {
    @Test
    void assertClassConstructor() {
        //Arrange
        String expectedLogFilePath = "C:\\Temp";
        String expectedLogLevel = "warn";

        //Act
        Configuration configuration = new Configuration(expectedLogFilePath, expectedLogLevel);

        //Assert
        assertEquals(expectedLogFilePath, configuration.getLogFilePath());
        assertEquals(expectedLogLevel, configuration.getLogLevel());
    }

    @Test
    void assertClassConstructorWithNullParametersThrowsIllegalArgumentException() {
        String logFilePath = "C:\\Temp";
        String logLevel = "warn";

        String expectedMessage = "Not given log-level or log-path!";
        Exception exception = assertThrows(IllegalArgumentException.class,
                () ->
                {
                    new Configuration(logFilePath, logLevel);
                    new Configuration(null, logLevel);
                    new Configuration(logFilePath, null);
                    new Configuration(null, null);
                });
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
    }
}