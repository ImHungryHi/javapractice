package abstractexercises;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);  // Rectangle because Shape doesn't implement IResizable
        Shape triangle = new RtTriangle();

        // Print sides per object
        System.out.println("Rectangle sides = " + rectangle.getNumSides());
        System.out.println("RtTriangle sides = " + triangle.getNumSides());

        // Print shapes' surfaces
        System.out.println("Rectangle surface = " + rectangle.getArea());
        System.out.println("Triangle surface = " + triangle.getArea());

        // Print shapes' perimeters
        System.out.println("Rectangle perimeter = " + rectangle.getPerimeter());
        System.out.println("Triangle perimeter = " + triangle.getPerimeter());

        // Resize rectangle and print
        rectangle.resize(2);
        System.out.println("Rectangle resized surface = " + rectangle.getArea());
        System.out.println("Rectangle resized perimeter = " + rectangle.getPerimeter());
    }
}