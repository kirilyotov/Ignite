package lights.digital.file;

import lights.digital.figures.Figure;

import java.io.*;
import java.util.Vector;

public class FileIO implements FileFactory {

    private String path;

    public FileIO(String path) {
        this.path = path;
    }

    public Vector<String > readAllFile() {

        Vector<String> data = new Vector<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public void saveToFile(Vector<Figure> figures) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < figures.size(); i++) {
                if (i > 0)
                    bw.write("\n");
                bw.write(figures.get(i).toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}