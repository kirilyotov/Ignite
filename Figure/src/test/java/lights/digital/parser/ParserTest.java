package lights.digital.parser;


import lights.digital.commandline.CommandLine;
import lights.digital.engine.Engine;
import lights.digital.figures.Circle;
import lights.digital.figures.Figure;
import lights.digital.figures.Rectangle;
import lights.digital.figures.Triangle;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class ParserTest {


    static Reflections reflections = new Reflections("lights.digital.figures");
    static Set<Class<? extends Figure>> subTypes =
            reflections.getSubTypesOf(Figure.class);

    @Test
    void parseArguments_NullPointerGivenAsParameterThrowsIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Null pointer given!";
        //Act + Assert
        for (var type : subTypes) {
            Exception exception = assertThrows(NullPointerException.class,
                    () -> {
                        Parser.parseArguments(type, null);
                    });
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }

    }

    @Test
    void parseArguments_NotCorrectClassGivenAsParameterThrowsIllegalArgumentException() {
        //Arrange
        String expectedMessage = "Not correct class given!";
        String[] line = {""};
        //Act + Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    Parser.parseArguments(Engine.class, line);
                    Parser.parseArguments(CommandLine.class, line);
                });
        String actualMessage = exception.getMessage();
    }

    @Test
    void parseArguments_NotCorrectStringArrayLengthGivenAsParameterThrowsIllegalArgumentException() {
        //arrange
        String expectedMessage = "Not correct number of parameters!";
        String[] circle1 = {"circle", "333", "10"};
        String[] circle2 = {"circle"};
        String[] rectangle1 = {"rectangle", "15", "10", "7"};
        String[] rectangle2 = {"rectangle", "15"};
        String[] triangle = {"triangle", "3", "9", "19", "0"};

        //Act + Assert
        for (var type : subTypes) {
            Exception exception = assertThrows(IllegalArgumentException.class,
                    () -> {
                        Parser.parseArguments(type, circle1);
                        Parser.parseArguments(type, circle2);
                        Parser.parseArguments(type, rectangle1);
                        Parser.parseArguments(type, rectangle2);
                        Parser.parseArguments(type, triangle);
                    });
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }

    }

    @Test
    void parseArguments_AssertCorrectDataParse() throws NoSuchMethodException, IllegalAccessException {
        //Arrange
        String[] circle = {"circle", "333.3"};
        String[] rectangle = {"rectangle", "15.7", "10"};
        String[] triangle = {"triangle", "3", "9.5", "19.77"};

        double[] expectedCircleData = {333.0};
        double[] expectedRectangleData = {15.7, 10.0};
        double[] expectedTriangleData = {3.0, 9.5, 19.77};

        //Act
        double[] actualCircleData = Parser.parseArguments(Circle.class, circle);
        double[] actualRectangleData = Parser.parseArguments(Rectangle.class, rectangle);
        double[] actualTriangleData = Parser.parseArguments(Triangle.class, triangle);

        //Assert
        assertArrayEquals(expectedCircleData, actualCircleData);
        assertArrayEquals(expectedRectangleData, actualRectangleData);
        assertArrayEquals(expectedTriangleData, actualTriangleData);
    }
}