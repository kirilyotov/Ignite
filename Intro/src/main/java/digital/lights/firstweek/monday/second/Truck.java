package digital.lights.firstweek.monday.second;

public class Truck extends Vehicle {

    static final byte FUEL_CONSUMPTION_CONST = 10;
    static final byte CURRENT_LOAD_DIVISOR = 100;

    private final double maxLoad;
    private final double minLoad;

    public Truck(String regNumber, double minLoad, double maxLoad) {
        super(regNumber);

        if (isNegative(maxLoad) || isNegative(minLoad)) {
            throw new IllegalArgumentException("Min and  max load of truck should be positive number!");
        }

        if (!isCorrectMinLoad(minLoad, maxLoad)) {
            throw new IllegalArgumentException("Min load should be less or equal to max load of truck!");
        }

        this.maxLoad = maxLoad;
        this.minLoad = minLoad;
    }

    private boolean isCorrectMinLoad(double minLoad, double maxLoad) {
        return minLoad <= maxLoad;
    }

    private boolean isNegative(double load) {
        return load <= 0;
    }


    @Override
    public double fuelConsumption() {
        return FUEL_CONSUMPTION_CONST + minLoad / CURRENT_LOAD_DIVISOR;
    }

    @Override
    public String toString() {
        return "Truck  with registration number " + getRegNumber() + " has got min load " + getMinLoad() + " and  max" +
                " " +
                "load" + getMaxLoad();
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public double getMinLoad() {
        return minLoad;
    }
}
