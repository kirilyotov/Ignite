package lights.digital.factory.random;

import lights.digital.figures.Figure;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomFigureFactoryTest {
    Reflections reflections = new Reflections("lights.digital.figure");
    Set<Class<? extends Figure>> subTypes =
            reflections.getSubTypesOf(Figure.class);

    boolean booleanArrayIsTrue(boolean[] arr) {
        for (var bool : arr) {
            if (!bool)
                return false;
        }
        return true;
    }

    boolean areDifferentTypes(Figure[] figures) {

        Object[] objectSubTypes = subTypes.toArray();

        boolean[] createdSubType = new boolean[objectSubTypes.length];

        for (int i = 0; i < figures.length; i++) {
            int j = 0;
            for (var s : subTypes) {
                if (figures[i].equals(s.getName())) {
                    createdSubType[j] = true;
                }
                j++;
            }

        }
        return booleanArrayIsTrue(createdSubType);
    }

    @Test
    void createRandomFiguresFromAllFigureSubTypes() throws Exception {
        //Arrange
        RandomFigureFactory randomFactory = new RandomFigureFactory();

        Figure[] figures = new Figure[subTypes.size() * 3];

        //Act
        for (int i = 0; i < figures.length; i++) {
            figures[i] = randomFactory.create();
        }

        //Assert
        assertTrue(areDifferentTypes(figures));
    }
}