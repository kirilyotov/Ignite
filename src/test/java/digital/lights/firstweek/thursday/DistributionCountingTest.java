package digital.lights.firstweek.thursday;


class DistributionCountingTest implements SortAlgorithmTest {
    @Override
    public SortAlgorithm sortAlgorithm() {
        return new DistributionCounting();
    }
}