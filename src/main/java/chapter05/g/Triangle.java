package chapter05.g;
import java.io.*;

public class Triangle {
    public static void main(String[] args) throws IOException {
        int[] sides = new int[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Side 1 = ");
        sides[0] = Integer.parseInt(reader.readLine());
        System.out.print("Side 2 = ");
        sides[1] = Integer.parseInt(reader.readLine());
        System.out.print("Side 3 = ");
        sides[2] = Integer.parseInt(reader.readLine());

        if (sides[0] > (sides[1] + sides[2])) {
            System.out.println("Side 1 (" + sides[0] + ") is bigger than " + sides[1] + " and " + sides[2]);
        }
        else if (sides[1] > (sides[0] + sides[2])) {
            System.out.println("Side 2 (" + sides[1] + ") is bigger than " + sides[0] + " and " + sides[2]);
        }
        else if (sides[2] > (sides[0] + sides[1])) {
            System.out.println("Side 3 (" + sides[2] + ") is bigger than " + sides[0] + " and " + sides[1]);
        }
    }
}
