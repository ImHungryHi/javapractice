package abstractexercises;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
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
    }
}
