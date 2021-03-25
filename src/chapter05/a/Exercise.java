package chapter05.a;

public class Exercise {
    public static void main(String[] args) {
        int x = 5;

        if (x > 0) {
            if (x < 10) {
                System.out.println("positive single digit number.");
            }
        }

        // Becomes
        if (x > 0 && x < 10) {
            System.out.println("positive single digit number.");
        }
    }
}
