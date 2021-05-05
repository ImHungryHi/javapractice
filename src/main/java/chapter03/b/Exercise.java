package chapter03.b;
import java.io.*;

public class Exercise {
    public static void main(String[] args) throws IOException, Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a temperature in Celsius: ");
        double input = Double.parseDouble(reader.readLine());
        reader.close();
        double output = (input * ((double)9 / 5)) + 32;
        System.out.printf("%.1f = %.1f", input, output);
    }
}
