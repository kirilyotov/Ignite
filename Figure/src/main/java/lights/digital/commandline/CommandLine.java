package lights.digital.commandline;

import lombok.Setter;

import java.util.Scanner;

/**
 * Singleton class for reading user commands.
 */
public class CommandLine {

    // Default color of symbols in console.
    private static final String ANSI_RESET = "\u001B[0m";


    // Red color of symbols in console.
    private static final String ANSI_RED = "\u001B[31m";

    private @Setter boolean exitProgram = false;


    //Instance of class
    static CommandLine theInstance = null;
    static Scanner scanner;

    /**
     * Creates instance of current class.
     *
     * @return reference to current class.
     */
    static public CommandLine getInstance() {
        if (theInstance == null)
            theInstance = new CommandLine();
        return theInstance;
    }

    /**
     * Run program.
     * Reading user commands, until exit is written in console.
     */
    public void run() {
        scanner = new Scanner(System.in);

        do {
            System.out.print("> ");
            String line = scanner.nextLine();

            try {
                getCommand(line);
            } catch (Exception e) {
                System.out.println(ANSI_RED + e.getMessage());
                System.out.println("\nType 'help' to see list of commands. " + ANSI_RESET);
            }

        } while (!exitProgram);
    }

    /**
     * Private constructor for singleton.
     */
    private CommandLine() {
    }

    /**
     * Reading line and checking it commands for compliance.
     *
     * @param line String to check.
     */
    private void getCommand(String line) throws Exception {
        Commands c = null;


        for (Commands commands : Commands.values()) {
            if (commands.name().equalsIgnoreCase(line.toUpperCase())) {

                c = commands;
                break;
            }
        }
        if (c == null)
            throw new IllegalArgumentException("Command not found!");
        c.getCommand(scanner);
    }

}