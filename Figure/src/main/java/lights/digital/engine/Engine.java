package lights.digital.engine;

import lights.digital.factory.input.FigureFactory;
import lights.digital.factory.random.RandomFigureFactory;
import lights.digital.figures.Figure;
import lights.digital.file.FileIO;
import lombok.Getter;

import java.util.Scanner;
import java.util.Vector;

public class Engine implements EngineFunctions {

    private final @Getter Vector<Figure> figures;

    public Engine() {
        figures = new Vector<>();
    }

    @Override
    public void generateRandomFigures(Scanner scanner) throws Exception {
        System.out.print("How many figures to generate?\nn = ");
        int figuresToCreate = readNumber(scanner);

        RandomFigureFactory rff = new RandomFigureFactory();

        for (int i = 0; i < figuresToCreate; i++) {

            figures.add(rff.create());

        }
        print();
    }

    @Override
    public void readFiguresFromSTDIN(Scanner scanner) {
        System.out.print("How many figures to read from console?\nn = ");
        int n = readNumber(scanner);
        FigureFactory figureFactory = new FigureFactory();

        for (int i = 0; i < n; i++) {
            String line = readLine(scanner);
            try {
                figures.add(FigureFactory.create(line));
            } catch (Exception e) {
                --i;
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void readFiguresFromFile(Scanner scanner) {
        System.out.print("Enter file name: ");
        String file = readLine(scanner);

        FileIO fileIO = new FileIO();
        Vector<String> data = fileIO.readAllFile(file);

        FigureFactory figureFactory = new FigureFactory();

        for (String datum : data) {
            try {
                figures.add(FigureFactory.create(datum));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        print();
    }

    @Override
    public void deleteElementOnPosition(Scanner scanner) {
        System.out.print("index = ");
        int index = readNumber(scanner);

        try {
            figures.remove(index);
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException("Not correct index!");
        }
        System.out.println("Now elements are " + figures.size());
        print();

    }

    @Override
    public void duplicateFigure(Scanner scanner) {
        System.out.println("index: ");
        int index = readNumber(scanner);
        if (index >= figures.size() || index < 0)
            throw new IllegalArgumentException("Not correct index!");

        figures.add(figures.get(index).clone());

        System.out.println("Cloned element: ");
        Figure clonedFigure = figures.get(figures.size() - 1);
        System.out.println(clonedFigure.toString());
    }

    @Override
    public void saveToFile(Scanner scanner) {
        System.out.println("Enter file name: ");
        String file = readLine(scanner);
        FileIO fileIO = new FileIO();
        fileIO.saveToFile(file, figures);
    }

    @Override
    public void print() {
        StringBuilder stringBuffer = new StringBuilder();
        for (Figure factoryFigure : figures) {
            stringBuffer.append("\n").append(factoryFigure.toString());
        }
        System.out.println(stringBuffer);
    }

    private int readNumber(Scanner scanner) {
        String line = readLine(scanner);
        return Integer.parseInt(line);
    }

    private String readLine(Scanner scanner) {
        return scanner.nextLine();
    }

}