package lights.digital.commandline;

import lights.digital.utils.Utils;

import java.util.Scanner;

/**
 * Commands from which user chooses.
 */
public enum Commands implements CommandsInstance {
    /**
     * Generates random figures.
     */
    RANDOM {
        @Override
        public void getCommand(Scanner scanner) throws Exception {
            createFigures.generateRandomFigures(scanner);
        }
    },
    /**
     * Reading figures from cmd
     */
    STDIN {
        @Override
        public void getCommand(Scanner scanner) {
            createFigures.readFiguresFromSTDIN(scanner);
        }
    },
    /**
     * Reading data from file.
     */
    FILE {
        @Override
        public void getCommand(Scanner scanner) {
            createFigures.readFiguresFromFile(scanner);
        }
    },
    /**
     * Deleting element on index given by user.
     */
    DELETE {
        @Override
        public void getCommand(Scanner scanner) {
            createFigures.deleteElementOnPosition(scanner);
        }
    },
    /**
     * Duplicating figure on index given by user.
     */
    DUPLICATE {
        @Override
        public void getCommand(Scanner scanner) {
            createFigures.duplicateFigure(scanner);
        }
    },
    /**
     * Saving data on given file directory.
     */
    SAVE {
        @Override
        public void getCommand(Scanner scanner) {
            createFigures.saveToFile(scanner);
        }
    },
    /**
     * Prints in console all functions with instructions.
     */
    HELP {
        @Override
        public void getCommand(Scanner scanner) {
            Utils.help();
        }
    },
    /**
     * Exit from program.
     */
    EXIT {
        @Override
        public void getCommand(Scanner scanner) {
            CommandLine commandLine = CommandLine.getInstance();
            commandLine.setExitProgram(true);
        }
    }
}
