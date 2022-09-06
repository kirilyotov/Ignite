package lights.digital.engine;

import java.util.Scanner;

public interface EngineFunctions {

    void generateRandomFigures(Scanner scanner) throws Exception;

    void readFiguresFromSTDIN(Scanner scanner);

    void readFiguresFromFile(Scanner scanner);

    void deleteElementOnPosition(Scanner scanner);

    void duplicateFigure(Scanner scanner);

    void saveToFile(Scanner scanner);

    void print();
}
