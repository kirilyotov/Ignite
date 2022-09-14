package digital.lights.path.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathValidatorTest {

    @Test
    void hasExtensionAssertFileNameWithMoreThanOneDot() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\config.a.file.test.ini";

        //Act + Assert
        assertTrue(PathValidator.hasExtension(path));
    }

    @Test
    void hasExtensionAssertFileNameWithOneDot() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\config.ini";

        //Act + Assert
        assertTrue(PathValidator.hasExtension(path));
    }

    @Test
    void hasExtensionAssertFileNameWithoutExtension() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\config";

        //Act + Assert
        assertFalse(PathValidator.hasExtension(path));
    }

    @Test
    void hasExtensionAssertFileNameWithoutSymbolsAfterDot() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\config.";

        //Act + Assert
        assertFalse(PathValidator.hasExtension(path));
    }

    @Test
    void hasExtensionAssertFileNameWithoutSymbolsBeforeDot() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\.ini";

        //Act + Assert
        assertTrue(PathValidator.hasExtension(path));
    }

    @Test
    void getExtensionAssertFileNameWithoutExtension() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\file";
        String expected = "";

        //Act + Assert
        assertEquals(expected, PathValidator.getExtension(path));
    }

    @Test
    void getExtensionAssertFileNameWithMoreThanOneDot() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\file.ini.good.txt";
        String expected = "txt";

        //Act + Assert
        assertEquals(expected, PathValidator.getExtension(path));
    }

    @Test
    void getExtensionAssertFileNameWithoutSymbolsBeforeDot() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\.ini";
        String expected = "ini";

        //Act + Assert
        assertEquals(expected, PathValidator.getExtension(path));
    }

    @Test
    void isValidPathAssertRelativePathReturnsTrue() {
        //Arrange
        String path = "..\\..\\..\\Configuration\\resources\\file.ini.good.txt";

        //Act + Assert
        assertTrue(PathValidator.isValidPath(path));
    }

    @Test
    void isValidPathAssertFullPathReturnsTrue() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\file.ini.good.txt";

        //Act + Assert
        assertTrue(PathValidator.isValidPath(path));
    }

    @Test
    void isValidPathAssertFullPathWithNoFileName() {
        //Arrange
        String path = "C:\\Digital_Lights\\Ignite\\Configuration\\resources\\config";

        //Act + Assert
        assertTrue(PathValidator.isValidPath(path));
    }

    @Test
    void isValidPathAssertNotCorrectSymbolsInPath() {
        //Arrange
        String pathWithStar = "resources\\config*.txt";
        String pathWithQuestionMark = "resources\\config.txt?";
        String pathWithVerticalLine = "resources\\conf|ig.txt";

        //Act + Assert
        assertFalse(PathValidator.isValidPath(pathWithStar));
        assertFalse(PathValidator.isValidPath(pathWithQuestionMark));
        assertFalse(PathValidator.isValidPath(pathWithVerticalLine));
    }
}