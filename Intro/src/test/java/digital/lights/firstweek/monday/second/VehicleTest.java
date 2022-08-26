package digital.lights.firstweek.monday.second;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public abstract class VehicleTest {
    abstract Vehicle vehicle(String s);
    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"AB0000AB", "ZZ9999ZZ", "AA0099ZZ", "AA 9999 ZZ", "AB0000 AZ",
            "ZZ 0000 ZZ", "AB 0000AZ"})
    public void assertVehicleCorrectlyRecognizesRegistrationNumber(String regNum) {
        //Act + Assert
        assertEquals(regNum, vehicle(regNum).getRegNumber());
    }

    @Test
    void assertVehicleCorrectlyTrowsNullReferenceException() {
        //Arrange
        String regNumber = null;

        //Assert
        Exception exception = assertThrows(NullPointerException.class,
                () -> {
                    //Act
                    vehicle(regNumber);
                });

    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "ab0000ZZ", "ab 000000 ab", "ABZ0000ABS", "AB12345ZZ"})
    void assertVehicleCorrectlyRecognizeIncorrectStringAndTrowsIllegalArgumentException(String regNumber) {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> vehicle(regNumber));

    }

    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"AB0000AB", "ZZ9999ZZ", "AA0099ZZ", "AA 9999 ZZ", "AB0000 AZ",
            "ZZ 0000 ZZ", "AB 0000AZ"})
    void assertHashCodeCorrectlyCalculates(String regNumber) {
        //Act + Assert
        assertEquals(regNumber.hashCode(), vehicle(regNumber).hashCode());

    }
    @Test
    void assertEqualsFunctionCorrectlyEqualsVehicleElements(){
        Car car = new Car("CB1234PB", 1.6);

        Truck truck = new Truck("CB1234PB", 19 , 77);

        assertEquals(car, car);
        assertEquals(truck, truck);
    }

   @Test
     void assertEqualsFunctionCorrectlyRecognizesDifferentVehicleElements(){
        Car car = new Car("CB1234PB", 1.6);
        Car car2 = new Car("CB1213PB", 1.8);

        Truck truck = new Truck("CB1234PB", 19 , 77);
        Truck truck2 = new Truck("CB1230KP", 19 , 77);

        assertFalse(car.equals(car2));
        assertFalse(car.equals(truck));
        assertFalse(truck.equals(truck2));
        assertFalse(truck.equals(new String()));
    }

    static void assertFuelConsumptionCalculatesCorrectFuelConsumption
            (Vehicle v, double expected, double precision) {
        assertEquals(expected, v.fuelConsumption(), precision);

    };
}