package digital.lights.firstweek.monday.first;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @ParameterizedTest
    //Arrange
    @CsvSource({"0, 0", "1, 1", "1, 2", "1, -1", "-1, -2", "8, 6", "-8, -6"})
    @DisplayName("Asserting fibonacci with positive and negative numbers")
    public void testFibonacci(int expected, int n) {
        //Act + Assert
        assertEquals(expected, Math.fibonacci(n));
    }
    //Old test transformed to one Parameterized test
    /*@Test
    public void testFibonacciTwoAsParamOneExpected() {
        assertEquals(1, Math.fibonacci(2));
    }

    @Test
    public void testFibonacciSixAsParamEightExpected() {
        assertEquals(8, Math.fibonacci(6));
    }

    @Test
    public void testFibonacciMinusSixAsParamMinusEightExpected() {
        assertEquals(-8, Math.fibonacci(-6));
    }

    @Test
    public void testFactorialZeroAsParamOneExpected() {

        assertEquals(1, Math.factorial(0));
    }*/


    @ParameterizedTest
    //Arrange
    @CsvSource({"1,0", "1, 1", "-1, -1", "120, 5", "-120, -5", "3_628_800, 10", "-3_628_800, -10"})
    @DisplayName("Asserting factorial with positive and negative numbers")
    public void testFactorial(int expected, int n) {
        //Act + Assert
        assertEquals(expected, Math.factorial(n));
    }
    //Old test transformed to one Parameterized test
   /* @Test
    public void testFactorialFiveAsParamHundredAndTwentyExpected() {
        assertEquals(120, Math.factorial(5));
    }

    @Test
    void testFactorialFiveAsParamMinusOneHundredAndTwentyExpected() {

        assertEquals(-120, Math.factorial(-5));
    }*/
}