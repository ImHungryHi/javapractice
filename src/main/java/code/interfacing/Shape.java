package code.interfacing;

public interface Shape {
    float calcSurface();
    default float calcCircumference() {
        throw new UnsupportedOperationException("Method not implemented in this shape.");
    }

    static void print() {
        System.out.println("Cannot override static methods.");
    }
}
