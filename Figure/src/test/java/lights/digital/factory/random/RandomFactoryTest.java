package lights.digital.factory.random;

import org.junit.jupiter.api.RepeatedTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public interface RandomFactoryTest {
    RandomFactory randomFactory();

    @RepeatedTest(20)
    default void creatingRandomFigureWithRandomParametersExpectedTwoDifferentObjectsFromSameType()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //Arrange
        Constructor<? extends RandomFactory> constructor = randomFactory().getClass().getConstructor();
        Object[] arguments = new Object[]{};

        RandomFactory newRandomFactory = constructor.newInstance(arguments);
        //Act + Assert
        assertNotEquals(newRandomFactory.create(), randomFactory().create());
    }
}