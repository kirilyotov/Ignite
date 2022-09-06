package lights.digital.engine;

import lights.digital.figures.Figure;
import lights.digital.file.FileIO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;


class EngineTest {


    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Engine engine;
    Scanner scanner;
    final String path = "./src/test/java/lights/digital/engine/files/";
    final String fileName = "Figures.txt";

    void setInput(String line) {

        System.setIn(new ByteArrayInputStream((line + "\n").getBytes()));
        scanner = new Scanner(System.in);
    }

    @BeforeEach
    void setEngine() {
        engine = new Engine();
    }

    void readFiguresFromFile(Engine engine, Scanner scanner) {
        engine.readFiguresFromFile(scanner);
    }


    @Test
    void generateRandomFigures_CreatingCorrectRandomFiguresWithGivenNumberOfFigures() throws Exception {
        //Arrange
        System.setOut(new PrintStream(outputStreamCaptor));
        setInput("10");
        engine.generateRandomFigures(scanner);

        //Act
        StringBuffer sb = new StringBuffer();
        sb.append("How many figures to generate?\nn = ");
        for (var figure : engine.getFigures())
            sb.append("\n" + figure.toString());

        //Assert
        Assert.assertEquals(sb.toString(), outputStreamCaptor.toString().trim());
    }

    @Test
    void readFiguresFromSTDIN_ReadsCorrectFiguresFromConsoleWithGivenNumberOfFigures() {
        //Arrange
        String figuresFromLines = "circle 3.00\nrectangle 7.77 0.33\ntriangle 100.03 100.03 100.03\ncircle 9999.99";
        setInput("4\n" + figuresFromLines);
        engine.readFiguresFromSTDIN(scanner);

        //Act
        StringBuffer sb = new StringBuffer();

        Vector<Figure> figures = engine.getFigures();
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            sb.append(figure.toString());
            if (i != figures.size() - 1) {
                sb.append("\n");
            }
        }
        //Assert
        assertEquals(figuresFromLines, sb.toString());
    }

    @Test
    void readFiguresFromFile_ReadsCorrectFiguresFromFileWithGivenFileName() {
        //Arrange

        setInput(path + fileName);

        scanner = new Scanner(System.in);
        engine.readFiguresFromFile(scanner);
        //Act
        FileIO fileIO = new FileIO();

        Vector<String> expected = fileIO.readAllFile(path + fileName);
        Vector<String> actual = new Vector<>();

        Vector<Figure> actualFigures = engine.getFigures();
        for (var figure : actualFigures) {
            actual.add(figure.toString());
        }
        //Assert
        assertEquals(expected, actual);
    }


    @Test
    void deleteElementOnPosition_NotCorrectIndexGivenThrowsIllegalArgumentException() {

        setInput(path + fileName);
        readFiguresFromFile(engine, scanner);

        String numbers = "-1\n" + Integer.MIN_VALUE + "\n" + engine.getFigures().size();
        setInput(numbers);


        //Assert
        String expectedMessage = "Not correct index!";
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> engine.deleteElementOnPosition(scanner));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void deleteElementOnPosition_DeletesElementOnCorrectPositions() {
        //Arrange
        setInput(path + fileName);
        scanner = new Scanner(System.in);
        readFiguresFromFile(engine, scanner);

        int numberOfFigures = engine.getFigures().size();

        System.setOut(new PrintStream(outputStreamCaptor));

        //Act
        setInput("0");
        engine.deleteElementOnPosition(scanner);


        StringBuilder expected = new StringBuilder();
        expected.append("index = Now elements are " + (numberOfFigures - 1) + "\n\n");
        for (Figure factoryFigure : engine.getFigures()) {
            expected.append(factoryFigure.toString() + "\n");
        }
        //Assert
        assertEquals(expected.toString(), outputStreamCaptor.toString().replaceAll("\r", ""));
    }

    @Test
    void duplicateFigure_CorrectCloningFigureOnGivenPositionAndAddingItInVectorOfFigures() {
        //Arrange
        setInput(path + fileName);
        readFiguresFromFile(engine, scanner);

        String[] numbers = {"0", String.valueOf(engine.getFigures().size() - 2),
                String.valueOf(engine.getFigures().size() - 1)};
        //Act
        for (var num : numbers) {
            int currentFiguresSize = engine.getFigures().size();
            setInput(num);
            engine.duplicateFigure(scanner);
            boolean isClonedElement =
                    engine.getFigures().get(Integer.parseInt(num)) != engine.getFigures().get(currentFiguresSize) &&
                            engine.getFigures().get(Integer.parseInt(num)).toString().
                                    equals(engine.getFigures().get(currentFiguresSize).toString());
            //Assert
            assertTrue(currentFiguresSize + 1 == engine.getFigures().size() && isClonedElement);
        }
    }

    @Test
    void duplicateFigure_AssertNotCorrectIndexThrowsIllegalArgumentException() {
        setInput(path + fileName);
        readFiguresFromFile(engine, scanner);

        String numbers = "-1\n" + Integer.MIN_VALUE + "\n" + engine.getFigures().size();
        setInput(numbers);


        //Assert
        String expectedMessage = "Not correct index!";
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> engine.duplicateFigure(scanner));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void saveToFile_AssertSavingVectorOfFiguresToFile() {
        //Arrange
        setInput(path + fileName);
        readFiguresFromFile(engine, scanner);
        //Act
        setInput(path + "Test" + fileName);
        engine.saveToFile(scanner);
        FileIO fileIO = new FileIO();

        //Assert
        assertEquals(fileIO.readAllFile(path + fileName), fileIO.readAllFile(path + "Test" + fileName));
    }

    @Test
    void print_AssertCorrectPrintingInConsoleVectorOfFigures() {
        //Arrange
        setInput(path + fileName);
        readFiguresFromFile(engine, scanner);

        System.setOut(new PrintStream(outputStreamCaptor));
        engine.print();
        //Act
        StringBuilder expected = new StringBuilder();
        for (Figure factoryFigure : engine.getFigures()) {
            expected.append("\n").append(factoryFigure.toString());
        }
        expected.append("\n");
        //Assert
        assertEquals(expected.toString(), outputStreamCaptor.toString().replaceAll("\r", ""));
    }

}