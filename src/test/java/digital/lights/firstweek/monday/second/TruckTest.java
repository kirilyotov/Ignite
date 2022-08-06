package digital.lights.firstweek.monday.second;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest extends VehicleTest{
    @Override

    public Vehicle vehicle(String s){
        //Assert
        double minLoad = 7;
        double maxLoad = 20;

        //Act + Assert
        return new Truck(s, minLoad, maxLoad);
    }

    @ParameterizedTest
    //Assert
    @CsvSource ({"170, 190", "17, 200"})
    void assertFuelConsumption(double minLoad, double maxLoad){
        //Assert
        String regNumber = "CB 1814 PB";

        double expected = 10 + minLoad /100.0;
        double precision = 0.01;

        VehicleTest vehicleTest = new TruckTest();
        //Act + Assert
        vehicleTest.assertFuelConsumptionCalculatesCorrectFuelConsumption(new Truck(regNumber, minLoad, maxLoad), expected,precision);
    }

    @ParameterizedTest
    @CsvSource ({"-5, 11", "0, 0", "11, -5", "-1 , -1"})
    void assertFuelConsumptionCorrectlyTrowsIllegalArgumentExceptionWithNegativeNumbers
            ( double minLoad, double maxLoad){

        String regNumber = "CB 1814 PB";
        String expectedMessage = "Min and  max load of truck should be positive number!";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Truck(regNumber, minLoad, maxLoad));
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}