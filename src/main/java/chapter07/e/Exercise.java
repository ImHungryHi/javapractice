package chapter07.e;

public class Exercise {
    public static boolean areFactor(int n, int[] arr) {
        for (int i : arr) {
            if (n % i != 0) {
                return false;
            }
        }

        return true;
    }
}
