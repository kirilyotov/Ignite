package lights.digital.factory.input;

class RectangleFactoryTest implements InputFactoryTest {
    public InputFactory inputFactory() {
        return new RectangleFactory();
    }

    public String name() {
        return "Rectangles.txt";
    }
}