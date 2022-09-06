package lights.digital.commandline;

import lights.digital.engine.Engine;

import java.util.Scanner;

/**
 * Interface class with function to be implemented in enum class.
 */
public interface CommandsInstance {

    Engine createFigures = new Engine();

    void getCommand(Scanner scanner) throws Exception;

}