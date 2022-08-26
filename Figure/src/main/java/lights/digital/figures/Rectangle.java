package lights.digital.figures;

import lombok.Getter;

public class Rectangle extends Figure {
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
    public Figure clone() {
        return new Rectangle(a, b);
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public String toString() {
        return "rectangle " + String.format("%.2f", a) + " " + String.format("%.2f", b);
    }
}