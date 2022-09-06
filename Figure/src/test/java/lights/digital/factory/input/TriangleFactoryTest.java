package lights.digital.factory.input;

class TriangleFactoryTest implements InputFactoryTest {
    public InputFactory inputFactory() {
        return new TriangleFactory();
    }

    public String name() {
        return "Triangles.txt";
    }
}