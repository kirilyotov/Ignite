package lights.digital.factory.input;

import lights.digital.figures.Figure;

import java.lang.reflect.InvocationTargetException;

public class FigureFactory {


    public static Figure create(String data) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        if (data == null)
            throw new NullPointerException("Null reference exception!");

        String[] splitData = data.trim().split("\\s+");
        String className =
                "lights.digital.factory.input." + splitData[0].substring(0, 1).toUpperCase() +
                        splitData[0].substring(1).toLowerCase() + "Factory";
        InputFactory info;
        try {
            info = (InputFactory) Class.forName(className).getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Class " + className + " does not exist!");
        }

        return info.create(splitData);
    }
}
