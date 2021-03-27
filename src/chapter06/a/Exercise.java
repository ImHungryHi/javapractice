package chapter06.a;

public class Exercise {
    public static void main(String[] args) {
        loop(10);
        /**
         * 10 (even - n / 2)
         * 5 (odd - n + 1)
         * 6 (even - n / 2);
         * 3 (odd - n + 1)
         * 4 (even - n / 2);
         * 2 (even - n / 2);
         * 1 (<= 1 - stop loop)
         */
        // This loop will always stop since it keeps halving or making n even until we get to 1
        // The last numbers in the sequence will also always be 4 - 2 - 1 (either from 3 by +1 or from 8 by /2)
        // Even if we were to take a negative number, the loop would still stop instantly because n <= 1
    }

    public static void loop(int n) {
        int i = n;

        while (i > 1) {
            System.out.println(i);
            if (i % 2 == 0) {
                i = i / 2;
            } else {
                i = i + 1;
            }
        }

        System.out.println(i);
    }
}