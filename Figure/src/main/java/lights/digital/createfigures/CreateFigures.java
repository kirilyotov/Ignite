package lights.digital.createfigures;

import lights.digital.factory.input.FigureFactory;
import lights.digital.factory.random.RandomFigureFactory;
import lights.digital.figures.Figure;
import lights.digital.file.FileIO;

import java.util.Scanner;
import java.util.Vector;

public final class CreateFigures implements Functions {

    private Vector<Figure> factoryFigures;

    public CreateFigures() {
        factoryFigures = new Vector<Figure>();
    }

    @Override
    public void generateRandomFigures() {
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
        for (int i = 0; i < data.size(); i++) {
            factoryFigures.add(figureFactory.getFigure(data.get(i)));
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

        factoryFigures.add(factoryFigures.get(index).clone());

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
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < factoryFigures.size(); i++) {
            stringBuffer.append("\n" + factoryFigures.get(i).toString());
        }
        System.out.println(stringBuffer.toString());
    }

    private int readNumber() {
        System.out.print("index = ");
        String line = readLine();
        int number = Integer.parseInt(line);
        return number;
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }

}