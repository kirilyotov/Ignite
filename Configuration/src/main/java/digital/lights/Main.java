package digital.lights;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String line = "jAva";
        line = line.substring(0,1).toUpperCase() + line.substring(1).toLowerCase();
        System.out.println(line);
    }
}