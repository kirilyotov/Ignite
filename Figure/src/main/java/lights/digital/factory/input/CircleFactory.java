package lights.digital.factory.input;

import lights.digital.figures.Circle;
import lights.digital.figures.Figure;
import lights.digital.parser.Parser;


public class CircleFactory implements InputFactory {
    public Figure create(String[] data) {

        double[] dataParser;
        try {
            dataParser = Parser.parseArguments(Circle.class, data);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return new Circle(dataParser[0]);
    }

}
