package lights.digital.commandline;

import lights.digital.utils.Utils;

public enum Commands implements CommandsInstance {

    RANDOM {
        @Override
        public void getCommand() {
            createFigures.generateRandomFigures();
        }
    },

    STDIN {
        @Override
        public void getCommand() {
            createFigures.readFiguresFromSTDIN();
        }
    },

    FILE {
        @Override
        public void getCommand() {
            createFigures.readFiguresFromFile();
        }
    },

    DELETE {
        @Override
        public void getCommand() {
            createFigures.deleteElementOnPosition();
        }
    },

    DUPLICATE {
        @Override
        public void getCommand() {
            createFigures.duplicateFigure();
        }
    },

    SAVE {
        @Override
        public void getCommand() {
            createFigures.saveToFile();
        }
    },

    HELP {
        @Override
        public void getCommand() {
            Utils.help();
        }
    },

    EXIT {
        @Override
        public void getCommand() {
            CommandLine commandLine = CommandLine.getInstance();
            commandLine.setExitProgram(true);
        }
    }
}
