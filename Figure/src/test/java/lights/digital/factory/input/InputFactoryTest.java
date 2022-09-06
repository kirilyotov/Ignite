package lights.digital.factory.input;

import lights.digital.figures.Figure;
import lights.digital.file.FileIO;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

interface InputFactoryTest {
    @Before
    InputFactory inputFactory();

    String name();

    String path = "./src/test/java/lights/digital/factory/input/files/";

    @Test
    default void createAssertCorrectReadingAndWritingFigureFromFile() {
        //Arrange
        FileIO fileIO = new FileIO();

        Vector<String> expectedLines = fileIO.readAllFile(path + name());
        Vector<Figure> figures = new Vector<>();

        for (String line : expectedLines) {
            figures.add(inputFactory().create(line.split("\\s+")));
        }

        //Act
        fileIO.saveToFile(path + "Test" + name(), figures);

        //Assert
        assertLinesMatch(expectedLines, fileIO.readAllFile(path + "Test" + name()));
    }
}