package lights.digital.figures;

import lombok.Getter;

public class Circle extends Figure {

    private final @Getter double  radius;


    public Circle(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Circle radius should be positive number!");
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() { return  Math.PI * radius * radius;}

    @Override
    public Figure clone(){return  new Circle(radius);}

    @Override
    public String toString() {
        return String.format("circle %.2f", radius);
    }
}
