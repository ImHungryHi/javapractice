package abstractexercises;

public class RtTriangle extends Shape {
    private int width;
    private int height;

    public RtTriangle() {
        super(3);
    }

    public double getArea() {
        return ((double)width * height) / 2;
    }

    public int getPerimeter() {
        return width + height + ((width * width) + (height * height));
    }
}
