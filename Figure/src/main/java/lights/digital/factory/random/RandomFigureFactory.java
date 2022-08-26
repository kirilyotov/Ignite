package lights.digital.factory.random;

import lights.digital.figures.Figure;

import java.util.Random;

public class RandomFigureFactory implements RandomFactory{

    RandomFactory factory;
    Random random = new Random();
    RandomFactory[] factories = new RandomFactory[]{
            new RandomCircleFactory(),
            new RandomRectangleFactory(),
            new RandomTriangleFactory()
    };



    @Override
    public Figure create(){

        for (Class<?> aClass : factory.getClass().getClasses()) {

        }

        int ind = random.nextInt(factories.length);
        return factories[ind].create();
    }


}