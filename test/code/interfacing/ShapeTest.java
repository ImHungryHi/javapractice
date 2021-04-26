package code.interfacing;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {
    @Test
    public void testShapes() {
        Shape circle = new Circle(2.5f);
        Shape square = new Square(7.3f);
        Shape rect = new Rectangle(10f, 5f);
        Shape triangle = new Triangle(10f, 5f);

        System.out.println("Circle circumference and surface area:");
        System.out.println(circle.calcCircumference());
        System.out.println(circle.calcSurface());

        System.out.println("Square circumference and surface area:");
        System.out.println(square.calcCircumference());
        System.out.println(square.calcSurface());

        System.out.println("Rectangle circumference and surface area:");
        System.out.println(rect.calcCircumference());
        System.out.println(rect.calcSurface());

        System.out.println("Triangle circumference and surface area:");
        System.out.println(triangle.calcCircumference());
        System.out.println(triangle.calcSurface());

        float herons = Triangle.calcHeronArea(10f, 5f, 10.307764f);
        System.out.println("Heron's area: " + herons);
        System.out.println("Height from area: " + Triangle.calcHeightFromArea(herons, 5f));
    }
}