package abstractexercises;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {
        super(4);
    }

    public double getArea() {
        return ((double)width * height) / 2;
    }

    public int getPerimeter() {
        return (width + height) * 2;
    }
}
