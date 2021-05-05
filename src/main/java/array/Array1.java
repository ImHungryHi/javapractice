package array;

import java.util.Arrays;

public class Array1 {
    public static void main(String[] args) {
        System.out.println("firstLast6 :");
        System.out.println("[1, 2, 6] = " + firstLast6(new int[]{1, 2, 6}));
        System.out.println("[6, 1, 2, 3] = " + firstLast6(new int[]{6, 1, 2, 3}));
        System.out.println("[13, 6, 1, 2, 3] = " + firstLast6(new int[]{13, 6, 1, 2, 3}));

        System.out.println("\nfirstLast6 :");
        System.out.println("[1, 2, 6] = " + firstLast6(new int[] {1, 2, 6}));
        System.out.println("[6, 1, 2, 3] = " + firstLast6(new int[] {6, 1, 2, 3}));
        System.out.println("[13, 6, 1, 2, 3] = " + firstLast6(new int[] {13, 6, 1, 2, 3}));

        System.out.println("\nsameFirstLast :");
        System.out.println("[1, 2, 3] = " + sameFirstLast(new int[] {1, 2, 3}));
        System.out.println("[1, 2, 3, 1] = " + sameFirstLast(new int[] {1, 2, 3, 1}));
        System.out.println("[1, 2, 1] = " + sameFirstLast(new int[] {1, 2, 1}));

        System.out.println("\nmakePi :");
        System.out.println(Arrays.toString(makePi()));

        System.out.println("\ncommonEnd :");
        System.out.println("[1, 2, 3];[7, 3] = " + commonEnd(new int[] {1, 2, 3}, new int[] {7, 3}));
        System.out.println("[1, 2, 3];[7, 3, 2] = " + commonEnd(new int[] {1, 2, 3}, new int[] {7, 3, 2}));
        System.out.println("[1, 2, 3];[1, 3] = " + commonEnd(new int[] {1, 2, 3}, new int[] {1, 3}));

        System.out.println("\nsum3 :");
        System.out.println("[1, 2, 3] = " + sum3(new int[] {1, 2, 3}));
        System.out.println("[5, 11, 2] = " + sum3(new int[] {5, 11, 2}));
        System.out.println("[7, 0, 0] = " + sum3(new int[] {7, 0, 0}));

        System.out.println("\nrotateLeft3 :");
        System.out.println("[1, 2, 3] = " + Arrays.toString(rotateLeft3(new int[]{1, 2, 3})));
        System.out.println("[5, 11, 9] = " + Arrays.toString(rotateLeft3(new int[] {5, 11, 9})));
        System.out.println("[7, 0, 0] = " + Arrays.toString(rotateLeft3(new int[] {7, 0, 0})));

        System.out.println("\nreverse3 :");
        System.out.println("[1, 2, 3] = " + Arrays.toString(reverse3(new int[] {1, 2, 3})));
        System.out.println("[5, 11, 9] = " + Arrays.toString(reverse3(new int[] {5, 11, 9})));
        System.out.println("[7, 0, 0] = " + Arrays.toString(reverse3(new int[] {7, 0, 0})));

        System.out.println("\nmaxEnd3 :");
        System.out.println("[1, 2, 3] = " + Arrays.toString(maxEnd3(new int[] {1, 2, 3})));
        System.out.println("[11, 5, 9] = " + Arrays.toString(maxEnd3(new int[] {11, 5, 9})));
        System.out.println("[2, 11, 3] = " + Arrays.toString(maxEnd3(new int[] {2, 11, 3})));

        System.out.println("\nsum2 :");
        System.out.println("[1, 2, 3] = " +  + sum2(new int[] {1, 2, 3}));
        System.out.println("[1, 1] = " +  + sum2(new int[] {1, 1}));
        System.out.println("[1, 1, 1, 1] = " + sum2(new int[] {1, 1, 1, 1}));


        System.out.println("\nmiddleWay :");
        System.out.println("[1, 2, 3];[4, 5, 6]) = " + Arrays.toString(middleWay(new int[] {1, 2, 3}, new int[] {4, 5, 6})));
        System.out.println("[7, 7, 7];[3, 8, 0] = " + Arrays.toString(middleWay(new int[] {7, 7, 7}, new int[] {3, 8, 0})));
        System.out.println("[5, 2, 9];[1, 4, 5] = " + Arrays.toString(middleWay(new int[] {5, 2, 9}, new int[] {1, 4, 5})));
    }

    /*
    firstLast6

    Given an array of ints, return true if 6
    appears as either the first or last element in the array. The array will be length 1 or more.

    firstLast6([1, 2, 6]) → true
    firstLast6([6, 1, 2, 3]) → true
    firstLast6([13, 6, 1, 2, 3]) → false
    */
    public static boolean firstLast6(int[] arr) {
        return (arr[0] == 6 || arr[arr.length - 1] == 6);
    }

    /*
    SameFirstLast

    Given an array of ints, return true if the array is length 1 or more,
    and the first element and the last element are equal.

    sameFirstLast([1, 2, 3]) → false
    sameFirstLast([1, 2, 3, 1]) → true
    sameFirstLast([1, 2, 1]) → true
    */
    public static boolean sameFirstLast(int[] arr) {
        return arr[0] == arr[arr.length - 1];
    }

    /*
    makePi

    Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.

    makePi() → [3, 1, 4]
     */
    public static int[] makePi() {
        return new int[] {3, 1, 4};
    }

    /*
    commonEnd
    Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element.
    Both arrays will be length 1 or more.

    commonEnd([1, 2, 3], [7, 3]) → true
    commonEnd([1, 2, 3], [7, 3, 2]) → false
    commonEnd([1, 2, 3], [1, 3]) → true
     */
    public static boolean commonEnd(int[] a, int[] b) {
        return (a[0] == b[0] || a[a.length - 1] == b[b.length - 1]);
    }

    /*
    sum3

    Given an array of ints length 3, return the sum of all the elements.

    sum3([1, 2, 3]) → 6
    sum3([5, 11, 2]) → 18
    sum3([7, 0, 0]) → 7
     */
    public static int sum3(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    /*
    rotateLeft3

    Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.

    rotateLeft3([1, 2, 3]) → [2, 3, 1]
    rotateLeft3([5, 11, 9]) → [11, 9, 5]
    rotateLeft3([7, 0, 0]) → [0, 0, 7]
     */
    public static int[] rotateLeft3(int[] arr) {
        return new int[] { arr[1], arr[2], arr[0] };
    }

    /*
    reverse3

    Given an array of ints length 3, return a new array with the elements in reverse order,
     so {1, 2, 3} becomes {3, 2, 1}.

    reverse3([1, 2, 3]) → [3, 2, 1]
    reverse3([5, 11, 9]) → [9, 11, 5]
    reverse3([7, 0, 0]) → [0, 0, 7]
     */
    public static int[] reverse3(int[] arr) {
        int[] reverse = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int j = arr.length - (1 + i);
            reverse[j] = arr[i];
        }

        return reverse;
    }

    /*
    maxEnd3

    Given an array of ints length 3, figure out which is larger, the first or last element in the array,
    and set all the other elements to be that value. Return the changed array.

    maxEnd3([1, 2, 3]) → [3, 3, 3]
    maxEnd3([11, 5, 9]) → [11, 11, 11]
    maxEnd3([2, 11, 3]) → [3, 3, 3]
     */
    public static int[] maxEnd3(int[] arr) {
        int max = arr[0];
        int end = arr[arr.length - 1];

        if (max < end) {
            max = end;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = max;
        }

        return arr;
    }

    /*
    Sum2

    Given an array of ints, return the sum of the first 2 elements in the array.
    If the array length is less than 2, just sum up the elements that exist, returning 0 if the array is length 0.

    sum2([1, 2, 3]) → 3
    sum2([1, 1]) → 2
    sum2([1, 1, 1, 1]) → 2
     */
    public static int sum2(int[] arr) {
        switch (arr.length) {
            case 0:
                return 0;
            case 1:
                return arr[0];
        }

        return arr[0] + arr[1];
    }

    /*
    middleWay

    Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle elements.

    middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
    middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
    middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
     */
    public static int[] middleWay(int[] arrFirst, int[] arrSecond) {
        int[] arrResult = new int[2];

        arrResult[0] = arrFirst[1];
        arrResult[1] = arrSecond[1];

        return arrResult;
    }
}
