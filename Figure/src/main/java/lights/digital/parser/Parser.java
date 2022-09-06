package lights.digital.parser;

import lights.digital.figures.Figure;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Set;

public class Parser {

    private static boolean isCorrectClass(Class classData) {
        Reflections reflections = new Reflections("lights.digital.figures");
        Set<Class<? extends Figure>> subTypes =
                reflections.getSubTypesOf(Figure.class);
        for (var type : subTypes) {
            if (type.getName().equals(classData.getName())) {
                return true;
            }
        }
        return false;
    }

    public static double[] parseArguments(Class classData, String[] data) throws NoSuchMethodException,
            IllegalAccessException {
        if (data == null) {
            throw new NullPointerException("Null pointer given!");
        }
        if (!isCorrectClass(classData)) {
            throw new IllegalArgumentException("Not correct class given!");
        }

        Constructor[] cons = classData.getConstructors();
        if (cons.length != 1)
            throw new IllegalAccessException("Not correct implemented Class " + classData.getName());

        int parameters = cons[0].getParameterCount();

        if (data.length != parameters + 1) {
            throw new IllegalArgumentException("Not correct number of parameters!");
        }
        double[] arrayParameters = new double[parameters];

        for (int i = 0; i < arrayParameters.length; i++) {
            arrayParameters[i] = Double.parseDouble(data[i + 1]);
        }
        return arrayParameters;
    }
}
