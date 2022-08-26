package lights.digital.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest extends FigureTest {
    public Figure figure(double... params) {
        return new Rectangle(params[0], params[1]);
    }

    @ParameterizedTest
    @CsvSource({"5.6, 5", "10, 10", "11, 5", "390 , 170"})
    void correctPerimeterOfFigureByGivenParametersTest(double a, double b) {
        assertEquals(2 * (a + b), figure(a, b).perimeter());
    }

    @ParameterizedTest
    @CsvSource({"5.6, 5", "10, 10", "11, 5", "390 , 170"})
    void correctAreaOfFigureWithGivenPositiveParameters(double a, double b) {
        assertEquals(a * b, figure(a, b).area());
    }

    @ParameterizedTest
    @CsvSource({"5.6, 5", "10, 10", "11, 5", "390 , 170"})
    void testToString(double a, double b) {
        assertEquals("rectangle " + a + " " + b, figure(a, b).toString());
    }

    //Not throwing exception when we have  Double.MIN_VALUE as parameter
    @ParameterizedTest
    @CsvSource({"-5, -11", "0, 0", "11, 0", "0 , 11"})
    void notCorrectInputTestThrowsIllegalArgumentException(double a, double b) {

        String expectedMessage = "Rectangle sides should be positive number!";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(a, b));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
}