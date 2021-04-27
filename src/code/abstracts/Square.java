package code.abstracts;

public class Square extends Shape {
    private float length = 0;

    public Square(float length) {
        this.length = length;
    }

    public float calcSurface() {
        return 4 * length;
    }

    public float calcCircumference() {
        return length * length;
    }
}
