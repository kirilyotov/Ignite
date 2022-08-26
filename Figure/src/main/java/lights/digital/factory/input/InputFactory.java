package lights.digital.factory.input;

import lights.digital.figures.Figure;

public interface InputFactory {

    Figure create(String[] data);
}
