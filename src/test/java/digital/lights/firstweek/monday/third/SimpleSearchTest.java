package digital.lights.firstweek.monday.third;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSearchTest implements StringSearchTest {

    @Override
    public StringSearch s() {
        return new SimpleSearch();
    }
}