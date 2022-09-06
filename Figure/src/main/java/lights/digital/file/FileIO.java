package lights.digital.file;

import lights.digital.figures.Figure;

import java.io.*;
import java.util.Vector;

public class FileIO implements FileFactory {


    /**
     * Reads all data of file and saving it to vector.
     *
     * @return vector with figures.
     */
    public Vector<String> readAllFile(String path) {
        if (path == null)
            throw new NullPointerException("Not correct path!");
        Vector<String> data = new Vector<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                data.add(line);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Not correct path!");
        } catch (IOException e) {
            throw new RuntimeException("Problem with reading file");
        }

        return data;
    }

    /**
     * Saving all data to file.
     *
     * @param figures vector with figures..
     */
    public void saveToFile(String path, Vector<Figure> figures) {
        if (path == null || figures == null) {
            throw new NullPointerException("Null pointer given!");
        }
        if (figures.isEmpty())
            throw new IllegalArgumentException("Vector is empty!");

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