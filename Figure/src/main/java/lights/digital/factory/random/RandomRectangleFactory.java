package lights.digital.factory.random;

import lights.digital.figures.Figure;
import lights.digital.figures.Rectangle;

import java.util.Random;

public final class RandomRectangleFactory implements RandomFactory {

    Random random = new Random();

    /**
     *  Creates random rectangle with random data
     * @return reference to random created rectangle.
     */
    public Figure create(){
        double a = random.nextDouble(0.1,100.0);
        double b = random.nextDouble(0.1,100.0);
        return new Rectangle(a,b);
    }

}