package lights.digital.factory.random;

import lights.digital.figures.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RandomTriangleFactoryTest implements RandomFactoryTest {
    @Override
    public RandomFactory randomFactory() {
        return new RandomTriangleFactory();
    }

    @Test
    void assertCreateRandomCircleFactoryExpectedReturnedObjectToBeFomClassTriangle() {
        RandomTriangleFactory randomTriangleFactory = new RandomTriangleFactory();
        assertInstanceOf(Circle.class, randomTriangleFactory.create());
    }
}