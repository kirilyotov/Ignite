package lights.digital.commandline;

import lights.digital.utils.Utils;

/**
 * Commands from which user chooses.
 */
public enum Commands implements CommandsInstance {
    /**
     * Generates random figures.
     */
    RANDOM {
        @Override
        public void getCommand() throws Exception {
            createFigures.generateRandomFigures();
        }
    },
    /**
     * Reading figures from cmd
     */
    STDIN {
        @Override
        public void getCommand() {
            createFigures.readFiguresFromSTDIN();
        }
    },
    /**
     * Reading data from file.
     */
    FILE {
        @Override
        public void getCommand() {
            createFigures.readFiguresFromFile();
        }
    },
    /**
     * Deleting element on index given by user.
     */
    DELETE {
        @Override
        public void getCommand() {
            createFigures.deleteElementOnPosition();
        }
    },
    /**
     * Duplicating figure on index given by user.
     */
    DUPLICATE {
        @Override
        public void getCommand() {
            createFigures.duplicateFigure();
        }
    },
    /**
     * Saving data on given file directory.
     */
    SAVE {
        @Override
        public void getCommand() {
            createFigures.saveToFile();
        }
    },
    /**
     * Prints in console all functions with instructions.
     */
    HELP {
        @Override
        public void getCommand() {
            Utils.help();
        }
    },
    /**
     * Exit from program.
     */
    EXIT {
        @Override
        public void getCommand() {
            CommandLine commandLine = CommandLine.getInstance();
            commandLine.setExitProgram(true);
        }
    }
}
