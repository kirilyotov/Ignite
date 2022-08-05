package digital.lights.firstweek.monday.second;

import java.util.regex.Pattern;

public abstract class Vehicle {
    private final String  regNumber;

    static final String REG_NUMBER_PATTERN = "^[A-Z]{2}\\d{4}[A-Z]{2}$";

    public Vehicle(String regNumber) {
        if (!isCorrectRegNumber(regNumber)) {
            throw new IllegalArgumentException("Not correct registration Number!");
        }
        this.regNumber = regNumber;
    }

    boolean isCorrectRegNumber(String regNumber) {

        return Pattern.matches(REG_NUMBER_PATTERN, regNumber);
    }

    public String getRegNumber() {
        return regNumber;
    }

    public abstract double fuelConsumption();


    @Override
    public int hashCode() {
        return this.regNumber.hashCode();
    }
}
