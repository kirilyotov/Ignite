package lights.digital.factory.random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public interface RandomFigureFactoryTest {
    RandomFactory randomFactory();

    @RepeatedTest(20)
    default void creatingRandomFigureWithRandomParametersExpectedTwoDifferentObjectsFromSameType()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        Constructor<? extends RandomFactory> constructor = randomFactory().getClass().getConstructor();
        Object[] arguments = new Object[]{};

        RandomFactory newRandomFactory = (RandomFactory) constructor.newInstance(arguments);

        assertNotEquals(newRandomFactory.create(), randomFactory().create());
    }

    @Test
    default void createRandomFigureWithCorrectParameters() {

    }
}