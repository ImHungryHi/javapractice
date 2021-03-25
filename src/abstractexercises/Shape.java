package abstractexercises;

/**
 * Data members: numSides
 * Constructor: initialize numSides
 * Concrete method: getter method for numSides
 * Abstract methods: getArea(), getPerimeter()
 */

public abstract class Shape {
    private int numSides;

    public Shape() {
        numSides = 4;
    }

    public Shape(int numSides) {
        this.numSides = numSides;
    }

    public int getNumSides() {
        return numSides;
    }

    public abstract double getArea();
    public abstract int getPerimeter();
}
