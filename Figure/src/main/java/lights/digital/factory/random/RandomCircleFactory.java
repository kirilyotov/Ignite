package lights.digital.factory.random;

import lights.digital.figures.Circle;
import lights.digital.figures.Figure;

import java.util.Random;

public final class RandomCircleFactory implements RandomFactory {

    Random random = new Random();

    /**
     * Creates random circle with random data
     *
     * @return reference to random created circle.
     */
    @Override
    public Figure create() {
        double r = random.nextDouble(0.1, 100.0);
        return new Circle(r);
    }
}
