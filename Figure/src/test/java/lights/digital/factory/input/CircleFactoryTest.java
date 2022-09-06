package lights.digital.factory.input;

class CircleFactoryTest implements InputFactoryTest {
    public InputFactory inputFactory() {
        return new CircleFactory();
    }

    public String name() {
        return "Circles.txt";
    }

}