package digital.lights.firstweek.monday.second;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest extends VehicleTest{


    public Vehicle vehicle(String regNumber){
        //Assert
        double engineVolume = 1.6;
        //Act + Assert
        return new Car(regNumber, engineVolume);
    }

    @ParameterizedTest
    @ValueSource (doubles = {1.6, 1.8, 2.2, 0.98, 3.3}  )
     void assertFuelConsumption(double engineVolume){
        String regNumber = "CB 1814 PB";
        double expected = engineVolume * 3;
        double precision = 0.01;


        assertFuelConsumptionCalculatesCorrectFuelConsumption(new Car(regNumber, engineVolume), expected,precision);
    }
    @ParameterizedTest
    @ValueSource (doubles = {-1.6, -1.8, -2.2, -0.98, -3.3, 0}  )
   void assertFuelConsumptionCorrectlyTrowsIllegalArgumentExceptionWithNegativeNumbers( double engineVolume){

            String regNumber = "CB 1814 PB";
            String expectedMessage = "Not correct engine volume!";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Car(regNumber, engineVolume));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
   }
}