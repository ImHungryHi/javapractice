package chapter07.b;

/**
 * Program output:
 * 30
 * ___________________
 * Mus description:
 * mus takes a zoo array of integers, loops through all of the zoo's values and sums them up in a fus integer to return
 * -------------------
 * Stack trace up to mus return:
 * bob = { 1, 2, 3, 4, 5 } // made by make(5)
 * bob = { 2, 4, 6, 8, 10 } // multiplied in dub(bob)
 * fus = 30 // sum of bob made in mus
 */

public class Exercise {
    public static int[] make(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        return a;
    }

    public static void dub(int[] jub) {
        for (int i = 0; i < jub.length; i++) {
            jub[i] *= 2;
        }
    }

    public static int mus(int[] zoo) {
        int fus = 0;
        for (int i = 0; i < zoo.length; i++) {
            fus += zoo[i];
        }
        return fus;
    }

    public static void main(String[] args) {
        int[] bob = make(5);
        dub(bob);
        System.out.println(mus(bob));;
    }
}
