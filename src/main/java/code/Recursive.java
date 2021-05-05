package code;

import java.util.*;

public class Recursive {
    public static void samIAm(String[] arrInput, String prefix) {
        if (arrInput.length == 1)
            System.out.println(prefix + arrInput[0]);

        for (int x = 0; x < arrInput.length; x++) {
            String[] passThrough = new String[arrInput.length - 1];
            int i = 0;

            for (int y = 0; y < arrInput.length; y++) {
                if (!arrInput[y].equals(arrInput[x])) {
                    passThrough[i] = arrInput[y];
                    i++;
                }
            }

            samIAm(passThrough, prefix + arrInput[x]);
        }
    }

    public static long getFactorial(long n) {
        if (n == 2) return n;
        return n * getFactorial(n - 1);
    }

    public static long getFactorialTail(long n, long a) {
        if (n == 0) return a;
        return getFactorialTail(n - 1, a * n);
    }

    // This method takes longer, don't use
    public static long getFactorialShort(long n) {
        return (n == 2) ? n : n * getFactorialShort(n - 1);
    }

    public static int getFibonacci(int n, int m, int limit) {
        System.out.print(n + ";");

        if (m <= limit) {
            return getFibonacci(m, (n + m), limit);
        }
        else {
            System.out.print(m + ";");
            return n;
        }
    }

    public static int fibonacciEven(int n, ArrayList<Integer> list) {
        if (n < 1) return n + n + 1;
        int result = fibonacciEven(n - 1, list) + fibonacciEven(n - 2, list);
        if (result % 2 == 0 && !list.contains(result)) list.add(result);
        return result;
    }

    // Actually shorter runtime than the above
    public static int getFibonacciShort(int n, int m, int limit) {
        return (m <= limit) ? getFibonacci(m, (n + m), limit) : n;
    }

    // N number of sequences
    public static int getNFibonacci(int n) {
        if (n < 1) return n + n + 1;
        return getNFibonacci(n - 1) + getNFibonacci(n - 2);
    }

    public static void bubbleSort(int[] arr, int n) {
        for (int j = 0; j <= n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));

        if (n == 2) return;
        bubbleSort(arr, n - 1);
    }

    // Returns the greatest common divisor by Euclids algorithm
    public static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
