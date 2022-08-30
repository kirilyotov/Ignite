package lights.digital.factory.input;

import lights.digital.figures.Circle;
import lights.digital.figures.Figure;


public class CircleFactory implements InputFactory {
    public Figure create(String[] data) {
        double r = Double.parseDouble(data[1]);
        return new Circle(r);
    }

}
