package lights.digital.factory.input;

import lights.digital.figures.Figure;
import lights.digital.figures.Rectangle;
import lights.digital.parser.Parser;

public class RectangleFactory implements InputFactory {
    public Figure create(String[] data) {
        double[] dataParser;
        try {
            dataParser = Parser.parseArguments(Rectangle.class, data);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return new Rectangle(dataParser[0], dataParser[1]);
    }
}

