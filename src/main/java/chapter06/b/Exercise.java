package chapter06.b;

public class Exercise {
    private static double leeway = 0.0001;

    public static void main(String[] args) {
        squareRoot(4);
        squareRoot(9);
        squareRoot(25);
        squareRoot(81);
        squareRoot(82);
    }

    public static void squareRoot(double a) {
        double x1 = a / 2;
        double x0 = 0;

        while (Math.abs(x1 - x0) > leeway) {
            x0 = x1;
            x1 = (x0 + a / x0) / 2;
        }

        System.out.println("Approximation of squareRoot(" + a + "): " + x1);
    }
}
