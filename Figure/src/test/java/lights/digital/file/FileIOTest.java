package lights.digital.file;

import lights.digital.factory.input.FigureFactory;
import lights.digital.figures.Figure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

    final static String path = "./src/test/java/lights/digital/file/files/";
    final static String fileName = "Figures.txt";

    FileIO fileIO;

    @BeforeEach
    void setUp() {
        fileIO = new FileIO();
    }

    StringBuffer saveToBuffer(Vector<String> lines) {
        StringBuffer sb = new StringBuffer();

        for (var figure : lines) {
            sb.append(figure + "\n");
        }
        return sb;
    }

    Vector<Figure> fillVector() throws InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException {
        Vector<Figure> figures = new Vector<>();
        FigureFactory figureFactory = new FigureFactory();
        var a = fileIO.readAllFile(path + fileName);
        for (var line : a) {
            figures.add(FigureFactory.create(line));
        }
        return figures;
    }

    @Test
    void readAllFile_AssertNullParameterThrowsNullPointerException() {
        //Arrange
        String expectedMessage = "Not correct path!";

        //Act
        Exception exception = assertThrows(NullPointerException.class,
                () -> fileIO.readAllFile(null));
        String actualMessage = exception.getMessage();

        //Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void readAllFile_AssertNotCorrectParameterThrowsRuntimeException() {
        //Arrange
        String expectedMessage = "Not correct path!";

        //Act
        Exception exception = assertThrows(RuntimeException.class,
                () -> fileIO.readAllFile("notCorrectPath"));
        String actualMessage = exception.getMessage();

        //Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void readAllFile_AssertCreatesCorrectFile() {
        //Arrange
        Vector<String> formFile = fileIO.readAllFile(path + fileName);

        StringBuffer actual = saveToBuffer(formFile);

        //Act
        Vector<String> data = new Vector<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + fileName))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuffer expected = saveToBuffer(data);

        //Assert
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void saveToFile_AssertNullParameterThrowsNullPointerException() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //Arrange
        String expectedMessage = "Null pointer given!";
        Vector<Figure> figures = fillVector();

        //Act
        Exception exception = assertThrows(NullPointerException.class,
                () ->
                {
                    fileIO.saveToFile(null, null);
                    fileIO.saveToFile(path + "Test" + fileName, null);
                    fileIO.saveToFile(null, figures);
                });

        String actualMessage = exception.getMessage();

        //Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void saveToFile_AssertEmptyVectorAsParameterThrowsIllegalArgumentException() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //Arrange
        String expectedMessage = "Vector is empty!";
        Vector<Figure> figures = new Vector<>();

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class,
                () ->
                {
                    fileIO.saveToFile(path + "Test" + fileName, figures);
                });

        String actualMessage = exception.getMessage();

        //Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void saveToFile_AssertCreatesCorrectFile() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        //Arrange
        Vector<Figure> figures = fillVector();
        fileIO.saveToFile(path + "Test" + fileName, figures);
        var expected = fileIO.readAllFile(path + fileName);
        var actual = fileIO.readAllFile(path + "Test" + fileName);
        assertEquals(expected, actual);

    }

}