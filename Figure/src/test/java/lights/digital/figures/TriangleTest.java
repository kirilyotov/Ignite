package lights.digital.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest extends FigureTest {
    public Figure figure(double... params) {
        return new Triangle(params[0], params[1], params[2]);
    }

    @ParameterizedTest
    @CsvSource({"5.6, 5, 13", "10, 10, 10", "11, 5, 15", "3 , 4, 5"})
    void correctPerimeterOfFigureByGivenParametersTest(double a, double b, double c) {
        assertEquals(a + b + c, figure(a, b, c).perimeter());
    }

    @ParameterizedTest
    @CsvSource({"5.6, 5, 13", "10, 10, 10", "11, 5, 15", "3 , 4, 5"})
    void correctAreaOfFigureWithGivenPositiveParameters(double a, double b, double c) {
        double perimeter = (a+ b +c)/2;
        assertEquals(sqrt(perimeter* (perimeter - a) * (perimeter - b)*(perimeter - c)), figure(a, b, c).area());
    }

    @ParameterizedTest
    @CsvSource({"5.6, 5, 13", "10, 10, 10", "11, 5, 15", "3 , 4, 5"})
    void testToString(double a, double b, double c) {
        assertEquals("triangle " + a + " " + b + " " + b, figure(a, b, c).toString());
    }

    //Not throwing exception when we have  Double.MIN_VALUE as parameter
    @ParameterizedTest
    @CsvSource({"-3, -3, -5", "3, -1 , 4", "-3, 4, 5 ", "3, 4, -5", "0, 4,  5", "4, 0, 5", "4, 11, 0"})
    void notCorrectInputTestThrowsIllegalArgumentException(double a, double b, double c) {

        String expectedMessage = "Side of triangle should be positive number!";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Triangle(a, b, c));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
}
