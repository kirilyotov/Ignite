package lights.digital.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest extends FigureTest {


    public Figure figure(double... radius) {
        return new Circle(radius[0]);
    }

    @ParameterizedTest
    @ValueSource(doubles = {3.0, 7.3, 15.0, 26.0, 17.0, 0.27})
    void correctPerimeterOfFigureByGivenParametersTest(double radius) {
        assertEquals(2.0 * radius * Math.PI, figure(radius).perimeter());
    }


    @ParameterizedTest
    @ValueSource(doubles = {3.0, 7.3, 15.0, 26.0, 17.0, 0.27})
    void area(double radius) {
        assertEquals(Math.PI * radius * radius, figure(radius).area());
    }

    @ParameterizedTest
    @ValueSource(doubles = {3.0, 7.3, 15.0, 26.0, 17.0, 0.27})
    void testToString(double radius) {
        assertEquals("circle " + radius, figure(radius).toString());
    }

    //Not throwing exception when we have  Double.MIN_VALUE as parameter
    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -122, -17, Double.MIN_VALUE})
    void notCorrectInputTestThrowsIllegalArgumentException(double radius) {

        String expectedMessage = "Circle radius should be positive number!";
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Circle(radius));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

}