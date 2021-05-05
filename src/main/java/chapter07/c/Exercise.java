package chapter07.c;

public class Exercise {
    public static int indexOfMax(int[] arr) {
        int max = arr[0];
        int pos = 0;

        for (int x = 1; x < arr.length; x++) {
            if (max < arr[x]) {
                max = arr[x];
                pos = 1;
            }
        }

        return pos;
    }

    // It IS possible to make an enhanced version of this with an intermediary counter.
    // Because a primitive (or String) array can only be indexed sequentially, starting at 0
    // This makes for sloppy coding in my opinion. Just use a standard for loop if you want to work with indexes
    public static int indexOfMaxEnhanced(int[] arr) {
        int max = arr[0];
        int pos = 0;
        int idx = 0;

        // starts at 0 so redundant check on first value
        for (int i : arr) {
            if (max < i) {
                max = i;
                pos = idx;
            }

            idx++;
        }

        return pos;
    }
}
