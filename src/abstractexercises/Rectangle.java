package abstractexercises;

public class Rectangle extends Shape implements IResizeable {
    private int width;
    private int height;

    public Rectangle() {
        super(4);
    }

    public Rectangle(int width, int height) {
        super(4);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return ((double)width * height) / 2;
    }

    public int getPerimeter() {
        return (width + height) * 2;
    }

    public void resize(double x) {
        width *= x;
        height *= x;
    }
}
