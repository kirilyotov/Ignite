package lights.digital.commandline;

import lombok.Setter;

import java.util.Scanner;

public class CommandLine {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private @Setter boolean exitProgram = false;
    static CommandLine theInstance = null;


    static public CommandLine getInstance() {
        if (theInstance == null)
            theInstance = new CommandLine();
        return theInstance;
    }

    public void run() {
        do {
            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();

            try {
                getCommand(line);
            } catch (Exception e) {
                System.out.println(ANSI_RED + e.getMessage());
                System.out.println("\nType \'help\' to see list of commands. " + ANSI_RESET);
            }

        } while (!exitProgram);
    }

    private CommandLine() {
    }

    private void getCommand(String line) {
        Commands c = null;

        for (Commands commands : Commands.values()) {
            if (commands.name().equalsIgnoreCase(line.toUpperCase())) {
                c = commands;
                break;
            }
        }
        if (c == null)
            throw new IllegalArgumentException("Command not found!");

        c.getCommand();
    }

}