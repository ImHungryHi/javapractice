package code.abstracts;

public class Circle extends Shape {
    private float radius = 0;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float calcSurface() {
        return (float)Math.PI * radius * radius;
    }

    public float calcCircumference() {
        return (float)(Math.PI * radius) * 2;
    }

    public float getDiameter() {
        return 2 * radius;
    }
}
