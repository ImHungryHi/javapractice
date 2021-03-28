package chapter09.e;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(powArray(new double[] {1.0, 2.0, 4.0, 5.0}, 5)));
    }

    public static double[] powArray(double[] a, int n) {
        double[] aPow = new double[a.length];

        for (int x = 0; x < a.length; x++) {
            aPow[x] = pow(a[x], n);
        }

        return aPow;
    }

    private static double pow(double x, int n) {
        if (n % 2 == 0 && n > 0) {
            double halfExp = pow(x, n / 2);
            return halfExp * halfExp;
        }
        else if (n % 2 == 0 && n < 0) {
            double halfExp = pow(x, -n / 2);
            return 1 / (halfExp * halfExp);
        }
        else if (n < 0) {
            return 1 / (x * pow(x, -n - 1));
        }
        else if (n == 0) {
            return 1;
        }
        else {
            return x * pow(x, n - 1);
        }
    }

    public static int[] histogram(int[] scores, int counters) {
        int[] hist = new int[counters];

        for (int score : scores) {
            if (score >= 0 && score < counters) {
                hist[score]++;
            }
        }

        return hist;
    }

    private static boolean areFactor(int n, int[] arr) {
        for (int i : arr) {
            if (n % i != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAnagram(String a, String b) {
        int[] aCount = letterHist(a);
        int[] bCount = letterHist(b);

        for (int x = 0; x < 26; x++) {
            if (aCount[x] != bCount[x]) {
                return false;
            }
        }

        return true;
    }

    private static int[] letterHist(String s) {
        s = s.toLowerCase();
        int[] hist = new int[26];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                hist[c - 'a']++;
            }
        }

        return hist;
    }
}
