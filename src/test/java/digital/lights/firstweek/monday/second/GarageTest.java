package digital.lights.firstweek.monday.second;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    @Test
    //Handled error in equals function in Vehicle
    void assertAddVehicleFunctionsCorrectlyAddsDifferentElementsFromTypeVehicle() {
        //Arrange
        Garage garage = new Garage();
        double engineVolume = 11;
        double minLoad = 10;
        double maxLoad = 11;

        //Act + Assert
        assertTrue(garage.addVehicle(new Car("BG 0000 PJ", engineVolume)));
        assertTrue(garage.addVehicle(new Truck("KH1788CB", minLoad, maxLoad)));


        assertTrue(garage.addVehicle((new Car("AA1234BB", engineVolume))));
        //NOT CORRECT REGISTRATION NUMBERS ARE SAME
        assertTrue(garage.addVehicle(new Truck("AA1234BB", minLoad, maxLoad)));

    }
    @Test
    void assertAddVehicleFunctionsCorrectlyDeclinesEqualVehicleFormSameType() {
        //Arrange
        Garage garage = new Garage();
        double engineVolume = 11;
        double minLoad = 10;
        double maxLoad = 11;

        //Act + Assert
        assertTrue(garage.addVehicle(new Car("BG 0000 PJ", engineVolume)));
        assertFalse(garage.addVehicle(new Car("BG 0000 PJ", engineVolume)));
        assertFalse(garage.addVehicle(new Car("BG 0000 PJ", engineVolume)));
        assertFalse(garage.addVehicle(new Car("BG 0000 PJ", engineVolume)));

        //assertFalse(garage.addVehicle(new Truck("BG 0000 PJ", minLoad, maxLoad)));

        assertTrue(garage.addVehicle(new Truck("AA1234BB", minLoad, maxLoad)));
        assertFalse(garage.addVehicle(new Truck("AA1234BB", minLoad, maxLoad)));
        assertFalse(garage.addVehicle(new Truck("AA1234BB", minLoad, maxLoad)));
    }


    @ParameterizedTest
    @CsvSource ({"1.6,77, 190", "11, 15, 100", "130, 33.3, 77" })
    void getAverageFuelConsumption(double engineVolume, double minLoad, double maxLoad) {
        //Arrange
        String carNum = "AB1234AB";
        String trucNum = "BB1234ZZ";
        double expected = ((engineVolume * 3) + (10 + minLoad / 100.0)) / 2.0;
        double delta = 0.01;

        //Act
        Garage garage = new Garage();
        garage.addVehicle(new Car(carNum, engineVolume));
        garage.addVehicle(new Truck(trucNum, minLoad, maxLoad));

        //Assert
        assertEquals(expected, garage.getAverageFuelConsumption(), delta);
    }
}