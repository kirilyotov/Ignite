package lights.digital.factory.random;

import lights.digital.figures.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RandomRectangleFactoryTest implements RandomFactoryTest {

    @Override
    public RandomFactory randomFactory() {
        return new RandomRectangleFactory();
    }

    @Test
    void assertCreateRandomCircleFactoryExpectedReturnedObjectToBeFomClassRectangle() {
        RandomRectangleFactory randomRectangleFactory = new RandomRectangleFactory();
        assertInstanceOf(Circle.class, randomRectangleFactory.create());
    }
}