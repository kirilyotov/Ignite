package digital.lights.firstweek.monday.third;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnuthMorrisPrattSearchTest implements StringSearchTest {


    @Override
    public StringSearch s() {
        return new KnuthMorrisPrattSearch();
    }


}