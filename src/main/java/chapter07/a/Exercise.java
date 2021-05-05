package chapter07.a;

public class Exercise {
    // Sort of factorial, only the numbers in a[] aren't sequential.
    // What I mean by this is that every number in the a[] array are multiplied with one another and returned.
    public static int banana(int[] a) {
        int kiwi = 1;   // Stores the eventual result of this function; ie the product of all a[] integers
        int i = 0;      // Loop counter to run from the first integer in a[] to the last
        while (i < a.length) {
            kiwi = kiwi * a[i];
            i++;
        }
        return kiwi;
    }

    // Search for a needle in a haystack (grape being the needle and a[] being the haystack)
    // Return the index of the grape number in the a[] array if found, -1 if not found.
    public static int grapefruit(int[] a, int grape) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == grape) {
                return i;
            }
        }
        return -1;
    }

    // Loop through an integer array and count all occurrances of an integer apple.
    // Increments the result variable pear by one for each occurrance of apple in a[] and returns the count.
    public static int pineapple(int[] a, int apple) {
        int pear = 0;
        for (int pine : a) {
            if (pine == apple) {
                pear++;
            }
        }
        return pear;
    }
}
