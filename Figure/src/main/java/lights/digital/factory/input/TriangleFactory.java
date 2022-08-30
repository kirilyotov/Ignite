package lights.digital.factory.input;

import lights.digital.figures.Figure;
import lights.digital.figures.Triangle;

public class TriangleFactory implements InputFactory {
    public Figure create(String[] data) {
        double a = Double.parseDouble(data[1]);
        double b = Double.parseDouble(data[2]);
        double c = Double.parseDouble(data[3]);
        return new Triangle(a, b, c);
    }
}