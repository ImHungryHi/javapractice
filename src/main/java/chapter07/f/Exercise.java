package chapter07.f;

public class Exercise {
    public static boolean arePrimeFactors(int n, int[] arr) {
        boolean[] primes = eratosthenesAlternative(getMax(arr));

        for (int num : arr) {
            if (!primes[num] || n % num != 0) {
                return false;
            }
        }

        return true;
    }

    public static int getMax(int[] arr) {
        int m = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (m < arr[i]) {
                m = arr[i];
            }
        }

        return m;
    }

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
