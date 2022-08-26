package lights.digital;

import lights.digital.commandline.CommandLine;

public class Main {
    public static void main(String[] args) {
        CommandLine commandLine = CommandLine.getInstance();
        commandLine.run();

       /* Class<? extends Figure>[] classes = new Class[]{
                RandomCircleFactory.class,
                RandomRectangleFactory.class,
                RandomTriangleFactory.class
        };

        Random r = new Random();
        int ind = r.nextInt(3);
        Constructor<? extends Figure> constructor = classes[ind].getConstructor();
        Object[] arguments = new Object[]{};
        Figure animal = (Figure) constructor.newInstance(arguments);
*/

        /*String figureType = "type";

        String className = "com.company.figures.Stdin" + figureType + "Factory";

        Class info = Class.forName(className);

        if( ! Figure.class.isAssignableFrom(info)) {
            throw new IllegalArgumentException("Class " + className + " exists but does not implement Figure");
        }

        info.getConstructor().newInstance().create();*/
    }
}
