package chapter03.d;
import java.io.*;

public class Exercise {
    public static void main(String[] args) throws IOException {
        int num = (int)(Math.random() * 100) + 1;
        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.println("(including both). Can you guess what it is?");
        System.out.print("Type a number: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.printf("Your guess is: %d\n", input);
        System.out.printf("The number I was thinking of is: %d\n", num);
        System.out.printf("You were off by %d", Math.abs(num - input));
    }
}
