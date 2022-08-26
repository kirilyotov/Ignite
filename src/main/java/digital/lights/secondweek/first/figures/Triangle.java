package digital.lights.secondweek.first.figures;

import lombok.Getter;

import static java.lang.Math.sqrt;

public class Triangle extends Figure {
    private final @Getter double a;
    private final @Getter double b;
    private final @Getter double c;


    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Side of triangle should be positive number!");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        return sqrt(perimeter() / 2 * (perimeter() / 2 - a) * (perimeter() / 2 - b) * (perimeter() / 2 - c));
    }

    @Override
    public Figure clone() {
        return new Triangle(a, b, c);
    }

    @Override
    public String toString() {
        return "triangle " + String.format("%.2f", a) + " " + String.format("%.2f", b) + " " +
                String.format("%.2f", c);
    }


}
