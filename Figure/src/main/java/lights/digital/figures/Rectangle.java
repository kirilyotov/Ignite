package lights.digital.figures;

import lombok.Getter;

import java.util.Locale;

public class Rectangle implements Figure {


    private final @Getter double a;
    private final @Getter double b;

    public Rectangle(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Rectangle sides should be positive number!");
        }
        this.a = a;
        this.b = b;
    }

    @Override
    public double perimeter() {
        return 2 * (a + b);
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public Figure clone() {
        return new Rectangle(a, b);
    }

    @Override
    public String toString() {
        return "rectangle " + String.format(Locale.ROOT, "%.2f", a) + " " +
                String.format(Locale.ROOT, "%.2f", b);
    }
}