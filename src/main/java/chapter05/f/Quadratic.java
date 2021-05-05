package chapter05.f;
import java.io.*;

public class Quadratic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Read a: ");
        int a = Integer.parseInt(reader.readLine());
        System.out.print("Read b: ");
        int b = Integer.parseInt(reader.readLine());
        System.out.print("Read c: ");
        int c = Integer.parseInt(reader.readLine());

        Quadratic q = new Quadratic();
        q.calculate(a, b, c);
    }

    public void calculate(int a, int b, int c) {
        double alpha = (b * b) - (4 * a * c);

        if (alpha > 0 && a > 0) {
            double delta = (Math.sqrt(alpha)) / (2 * a);
            double x1 = -b + delta;
            double x2 = -b - delta;

            System.out.println("Plus: " + x1);
            System.out.println("Minus: " + x2);
        }
        else {
            System.out.println("Invalid input: " + (alpha <= 0 ? "Can't take a square root of a negative number" :
                    "Can't divide by zero"));
        }
    }
}
