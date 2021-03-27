package chapter07.d;

public class Exercise {
    public static boolean[] eratosthenesAlternative(int limit) {
        boolean[] numbers = new boolean[limit + 1];
        numbers[0] = true;
        numbers[1] = true;

        for (int n = 2; n < (limit + 1); n++) {
            if (!numbers[n]) {
                for (int i = n * 2; i < (limit + 1); i += n) {
                    numbers[i] = true;
                }
            }
        }

        return numbers;
    }
}
