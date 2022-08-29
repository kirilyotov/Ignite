package lights.digital.createfigures;

import lights.digital.factory.input.FigureFactory;
import lights.digital.factory.random.RandomFigureFactory;
import lights.digital.figures.Figure;
import lights.digital.file.FileIO;


import java.util.Scanner;
import java.util.Vector;

public class CreateFigures implements Functions {

    private Vector<Figure> factoryFigures;

    public CreateFigures() {
        factoryFigures = new Vector<>();
    }

    @Override
    public void generateRandomFigures() throws Exception {
        System.out.print("How many figures to generate?\nn = ");
        int figuresToCreate = readNumber();

        RandomFigureFactory rff = new RandomFigureFactory();

        for (int i = 0; i < figuresToCreate; i++) {

            factoryFigures.add(rff.create());

        }
        print();
    }

    @Override
    public void readFiguresFromSTDIN() {
        System.out.println("How many figures to read from console?\nn = ");
        int n = readNumber();
        FigureFactory figureFactory = new FigureFactory();

        for (int i = 0; i < n; i++) {
            String line = readLine();
            factoryFigures.add(figureFactory.getFigure(line));
        }
    }

    @Override
    public void readFiguresFromFile() {
        System.out.println("Enter file name: ");
        String file = readLine();

        FileIO fileIO = new FileIO(file);
        Vector<String> data = fileIO.readAllFile();

        FigureFactory figureFactory = new FigureFactory();
        for (String datum : data) {
            factoryFigures.add(figureFactory.getFigure(datum));
        }
    }

    @Override
    public void deleteElementOnPosition() {
        System.out.print("index = ");
        int index = readNumber();

        try {
            factoryFigures.remove(index);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new ArrayIndexOutOfBoundsException("Not correct index!");
        }
        System.out.println("Now elements are " + factoryFigures.size());
        print();

    }

    @Override
    public void duplicateFigure() {
        System.out.println("index: ");
        int index = readNumber();

        factoryFigures.add(factoryFigures.get(index-1).clone());

        System.out.println("Cloned element: ");
        factoryFigures.get(factoryFigures.size());
    }

    @Override
    public void saveToFile() {
        System.out.println("Enter file name: ");
        String file = readLine();
        FileIO fileIO = new FileIO(file);
        fileIO.saveToFile(factoryFigures);
    }

    @Override
    public void print() {
        StringBuilder stringBuffer = new StringBuilder();
        for (Figure factoryFigure : factoryFigures) {
            stringBuffer.append("\n").append(factoryFigure.toString());
        }
        System.out.println(stringBuffer);
    }

    private int readNumber() {
        String line = readLine();
        return Integer.parseInt(line);
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}