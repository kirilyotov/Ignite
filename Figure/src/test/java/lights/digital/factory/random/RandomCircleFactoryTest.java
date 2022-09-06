package lights.digital.factory.random;

import lights.digital.figures.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RandomCircleFactoryTest implements RandomFactoryTest {
    @Override
    public RandomFactory randomFactory() {
        return new RandomCircleFactory();
    }

    @Test
    void assertCreateRandomCircleFactoryExpectedReturnedObjectToBeFomClassCircle() {
        //Arrange
        RandomCircleFactory randomCircleFactory = new RandomCircleFactory();

        //Act + Assert
        assertInstanceOf(Circle.class, randomCircleFactory.create());
    }

}