package lights.digital.commandline;

import lights.digital.createfigures.CreateFigures;

public interface CommandsInstance {

    CreateFigures createFigures = new CreateFigures();

    void getCommand();

}