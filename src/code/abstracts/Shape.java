package code.abstracts;

public abstract class Shape {
    abstract float calcSurface();
    float calcCircumference() {
        throw new UnsupportedOperationException("Method not implemented in this shape.");
    }

    static void print() {
        System.out.println("Cannot override static methods.");
    }
}
