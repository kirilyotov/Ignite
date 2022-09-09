package digital.lights;


import digital.lights.parser.CmdParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

public class Main {

    public static void main(String[] args) {
        try {
            CommandLine cmd = CmdParser.parse(args);
            CmdParser.getInstance(cmd);
        } catch (ParseException e) {
            System.out.println("Problem with parsing!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}