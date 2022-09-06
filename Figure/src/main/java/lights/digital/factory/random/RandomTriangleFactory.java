package lights.digital.factory.random;

import lights.digital.figures.Figure;
import lights.digital.figures.Triangle;

import java.util.Random;

public final class RandomTriangleFactory implements RandomFactory {

    Random random = new Random();

    /**
     * Creates random triangle with random data.
     *
     * @return reference to random created triangle.
     */
    public Figure create() {
        double a, b, c;
        a = random.nextDouble(0.1, 100.0);
        b = random.nextDouble(0.1, 100.0);
        c = random.nextDouble(0.1, 100.0);
        return new Triangle(a, b, c);
    }

}
