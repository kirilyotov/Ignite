package lights.digital.commandline;

import lights.digital.createfigures.CreateFigures;

/**
 * Interface class with function to be implemented in enum class.
 */
public interface CommandsInstance {

    CreateFigures createFigures = new CreateFigures();

    void getCommand() throws Exception;

}