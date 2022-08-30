package lights.digital.engine;

public interface EngineFunctions {

    void generateRandomFigures() throws Exception;

    void readFiguresFromSTDIN();

    void readFiguresFromFile();

    void deleteElementOnPosition();

    void duplicateFigure();

    void saveToFile();

    void print();
}
