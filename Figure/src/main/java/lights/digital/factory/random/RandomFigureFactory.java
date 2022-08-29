package lights.digital.factory.random;


import lights.digital.figures.Figure;
import org.reflections.Reflections;


import java.util.Random;
import java.util.Set;

/**
 *
 */
public class RandomFigureFactory {


    Random random = new Random();

    /**
     * Using reflection to take all subclasses of RandomFactory
     */
    Reflections reflections = new Reflections("lights.digital.factory.random");
    Set<Class<? extends RandomFactory>> subTypes =
            reflections.getSubTypesOf(RandomFactory.class);

    /**
     * Creating random figure.
     * @return
     */
    public Figure create() throws  Exception {
        int ind = random.nextInt(subTypes.size());
        int position = 0;
        try {
            for (var type : subTypes) {
                if (position == ind)
                    return type.getConstructor().newInstance().create();
                position++;
            }
        }catch (Exception e){
            throw new Exception("Problem with creating random figure!");
        }
        return null;
    }


}