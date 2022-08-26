package digital.lights.firstweek.thursday;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest implements SortAlgorithmTest{
    @Override
    public SortAlgorithm sortAlgorithm(){
        return new Merge();
    }
}