package lights.digital.factory.input;

import lights.digital.figures.Figure;
import lights.digital.file.FileIO;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class FigureFactoryTest {
    final static String path = "./src/test/java/lights/digital/factory/input/files/";
    final static String fileName = "Figures.txt";

    @Test
    void createAssertCorrectReadingAndWritingFiguresFromFile() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //Arrange
        FileIO fileIO = new FileIO();
        FigureFactory figureFactory = new FigureFactory();

        Vector<String> expectedLines = fileIO.readAllFile(path + fileName);
        Vector<Figure> figures = new Vector<>();

        for (String line : expectedLines) {
            figures.add(FigureFactory.create(line));
        }

        //Act
        fileIO.saveToFile(path + "Test" + fileName, figures);

        //Assert
        assertLinesMatch(expectedLines, fileIO.readAllFile(path + "Test" + fileName));
    }

    @Test
    void createAssertsNotCorrectInputThrowsNullPointerException() throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        //Arrange
        String expectedMessage = "Null reference exception!";
        String line = null;

        FigureFactory figureFactory = new FigureFactory();

        //Act + Assert
        Exception exception = assertThrows(NullPointerException.class,
                () -> FigureFactory.create(line));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}