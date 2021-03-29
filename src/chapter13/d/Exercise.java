package chapter13.d;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 7, 3, 1, 9, 0, 5, 6, 2 };
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] a) {
        int n = 0;

        // No change at first index so we'll skip it
        for (int x = 1; x < a.length; x++) {
            n = x;

            while (x > 0 && a[x - 1] > a[x]) {
                int temp = a[x - 1];
                a[x - 1] = a[x];
                a[x--] = temp;
            }

            x = n;
        }
    }
}
