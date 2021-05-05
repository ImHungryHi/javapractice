package chapter05.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise {
    public static void main(String[] args) throws IOException {
        int num = (int)(Math.random() * 100) + 1;
        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.println("(including both). Can you guess what it is?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = -1;
        int incorrectGuesses = 0;

        while (input != num) {
            System.out.print("Type a number: ");
            input = Integer.parseInt(reader.readLine());
            System.out.printf("Your guess is: %d\n", input);

            if (input == num) {
                break;
            }
            else {
                incorrectGuesses++;

                if (incorrectGuesses >= 3 && input > num) {
                    System.out.println("Too high, no more guesses left.");
                    break;
                }
                else if (incorrectGuesses >= 3 && input< num) {
                    System.out.println("Too low, no more guesses left.");
                    break;
                }
                else if (input > num) {
                    System.out.println("Too high, try again (" + (3 - incorrectGuesses) + " left).");
                }
                else {
                    System.out.println("Too low, aim higher (" + (3 - incorrectGuesses) + " left).");
                }
            }
        }

        reader.close();
        System.out.printf("The number I was thinking of is: %d\n", num);
        System.out.printf("You were off by %d", Math.abs(num - input));
    }
}
