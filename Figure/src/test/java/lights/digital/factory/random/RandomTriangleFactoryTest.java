package lights.digital.factory.random;

import static org.junit.jupiter.api.Assertions.*;

class RandomTriangleFactoryTest implements RandomFigureFactoryTest {
    @Override
    public RandomFactory randomFactory() {
        return new RandomTriangleFactory();
    }
}