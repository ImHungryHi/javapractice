package code.abstracts;

public class Rectangle extends Shape {
    private float height = 0;
    private float width = 0;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public float calcSurface() {
        return width * height;
    }

    public float calcCircumference() {
        return (width + height) * 2;
    }
}
