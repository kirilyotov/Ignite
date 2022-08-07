package digital.lights.firstweek.monday.second;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Vehicle {
    private final String  regNumber;

    static final String REG_NUMBER_PATTERN = "^[A-Z]{2}\s?\\d{4}\s?[A-Z]{2}$";

    public Vehicle(String regNumber) {
        if(regNumber == null)
            throw new NullPointerException();
        if (!isCorrectRegNumber(regNumber)) {
            throw new IllegalArgumentException("Not correct registration Number!");
        }
        this.regNumber = regNumber;
    }

    private boolean isCorrectRegNumber(String regNumber) {

        return Pattern.matches(REG_NUMBER_PATTERN, regNumber);
    }

    public String getRegNumber() {
        return regNumber;
    }

    public abstract double fuelConsumption();

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null)
            return false;
        if(!(o instanceof Vehicle v))
            return false;

        return this.getRegNumber().equals(v.getRegNumber());

    }
    @Override
    public int hashCode() {
        return this.regNumber.hashCode();
    }
}
