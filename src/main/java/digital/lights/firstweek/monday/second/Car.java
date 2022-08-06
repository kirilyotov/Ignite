package digital.lights.firstweek.monday.second;

import java.util.Objects;

public class Car extends Vehicle {

    static final byte CONSUMPTION_CONST = 3;
    private final double engineVolume;

    public Car(String regNumber, double engineVolume) {
        super(regNumber);
        if (!isCorrectEngineVolume(engineVolume)) {
            throw new IllegalArgumentException("Not correct engine volume!");
        }
        this.engineVolume = engineVolume;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public double fuelConsumption() {
        return getEngineVolume() * CONSUMPTION_CONST;
    }

    @Override
    public String toString() {
        return "Car with registration number: " + getRegNumber() + " has got " + getEngineVolume() + " liters engine " +
                "volume and " + fuelConsumption() + "l/100 km consumption.";
    }


    private boolean isCorrectEngineVolume(double engineVolume) {
        return engineVolume > 0;
    }
}
