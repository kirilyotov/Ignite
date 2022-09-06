package lights.digital.file;

import lights.digital.figures.Figure;

import java.util.Vector;

public interface FileFactory {
    Vector<String> readAllFile(String path);

    void saveToFile(String path, Vector<Figure> figures);
}
