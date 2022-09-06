package lights.digital.factory.input;

import lights.digital.figures.Figure;
import lights.digital.figures.Triangle;
import lights.digital.parser.Parser;

public class TriangleFactory implements InputFactory {
    public Figure create(String[] data) {
        double[] dataParser;
        try {
            dataParser = Parser.parseArguments(Triangle.class, data);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return new Triangle(dataParser[0], dataParser[1], dataParser[2]);
    }
}