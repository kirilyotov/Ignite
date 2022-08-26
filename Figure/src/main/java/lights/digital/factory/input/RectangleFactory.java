package lights.digital.factory.input;

import lights.digital.figures.Figure;
import lights.digital.figures.Rectangle;

public class RectangleFactory implements InputFactory {
    public Figure create(String[] data){
        double a = Double.parseDouble(data[1]);
        double b = Double.parseDouble(data[2]);
        return new Rectangle(a,b);
    }
}

