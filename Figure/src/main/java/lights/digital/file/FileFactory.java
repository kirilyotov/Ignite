package lights.digital.file;

import lights.digital.figures.Figure;

import java.util.Vector;

public interface FileFactory {
    Vector<String > readAllFile();
    void saveToFile(Vector<Figure> figures);
}
