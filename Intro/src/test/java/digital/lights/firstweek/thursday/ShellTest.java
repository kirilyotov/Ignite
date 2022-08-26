package digital.lights.firstweek.thursday;

import static org.junit.jupiter.api.Assertions.*;

class ShellTest implements SortAlgorithmTest {

    @Override
    public SortAlgorithm sortAlgorithm() {
        return new Shell();
    }

}