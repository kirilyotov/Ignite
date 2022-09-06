package lights.digital;


import lights.digital.commandline.CommandLine;


public class Main {
    public static void main(String[] args) {
        CommandLine commandLine = CommandLine.getInstance();
        commandLine.run();
    }
}
