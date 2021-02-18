package array;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args) {
        /*System.out.println("makeEnds :");
        System.out.println("[1, 2, 3] = " + Arrays.toString(makeEnds(new int[]{1, 2, 3})));
        System.out.println("[1, 2, 3, 4] = " + Arrays.toString(makeEnds(new int[]{1, 2, 3, 4})));
        System.out.println("[7, 4, 6, 2] = " + Arrays.toString(makeEnds(new int[]{7, 4, 6, 2})));

        System.out.println("\nhas23 :");
        System.out.println("[2, 5] = " + has23(new int[] {2, 5}));
        System.out.println("[4, 3] = " + has23(new int[] {4, 3}));
        System.out.println("[4, 5] = " + has23(new int[] {4, 5}));

        System.out.println("\nno23 :");
        System.out.println("[4, 5] = " + no23(new int[] {4, 5}));
        System.out.println("[4, 2] = " + no23(new int[] {4, 2}));
        System.out.println("[3, 5] = " + no23(new int[] {3, 5}));

        System.out.println("\nmakeLast :");
        System.out.println("[4, 5, 6] = " + Arrays.toString(makeLast(new int[]{4, 5, 6})));
        System.out.println("[1, 2] = " + Arrays.toString(makeLast(new int[]{1, 2})));
        System.out.println("[3] = " + Arrays.toString(makeLast(new int[]{3})));

        System.out.println("\ndouble23 :");
        System.out.println("[2, 2] = " + double23(new int[] {2, 2}));
        System.out.println("[3, 3] = " + double23(new int[] {3, 3}));
        System.out.println("[2, 3] = " + double23(new int[] {2, 3}));

        System.out.println("\nfix23 :");
        System.out.println("[1, 2, 3] = " + Arrays.toString(fix23(new int[]{1, 2, 3})));
        System.out.println("[2, 3, 5] = " + Arrays.toString(fix23(new int[]{2, 3, 5})));
        System.out.println("[1, 2, 1] = " + Arrays.toString(fix23(new int[]{1, 2, 1})));

        */System.out.println("\nstart1 :");
        System.out.println("[1, 2, 3];[1, 3] = " + start1(new int[] {1, 2, 3}, new int[] {1, 3}));
        System.out.println("[7, 2, 3];[1] = " + start1(new int[] {7, 2, 3}, new int[] {1}));
        System.out.println("[1, 2];[] = " + start1(new int[] {1, 2}, new int[] {}));

        System.out.println("\nbiggerTwo :");
        System.out.println("[1, 2];[3, 4] = " + Arrays.toString(biggerTwo(new int[]{1, 2}, new int[]{3, 4})));
        System.out.println("[3, 4];[1, 2] = " + Arrays.toString(biggerTwo(new int[]{3, 4}, new int[]{1, 2})));
        System.out.println("[1, 1];[1, 2] = " + Arrays.toString(biggerTwo(new int[]{1, 1}, new int[]{1, 2})));

        System.out.println("\nmakeMiddle :");
        System.out.println("[1, 2, 3, 4] = " + Arrays.toString(makeMiddle(new int[]{1, 2, 3, 4})));
        System.out.println("[7, 1, 2, 3, 4, 9] = " + Arrays.toString(makeMiddle(new int[]{7, 1, 2, 3, 4, 9})));
        System.out.println("[1, 2] = " + Arrays.toString(makeMiddle(new int[]{1, 2})));

        System.out.println("\nplusTwo :");
        System.out.println("[1, 2];[3, 4] = " + Arrays.toString(plusTwo(new int[]{1, 2}, new int[]{3, 4})));
        System.out.println("[4, 4];[2, 2] = " + Arrays.toString(plusTwo(new int[]{4, 4}, new int[]{2, 2})));
        System.out.println("[9, 2];[3, 4] = " + Arrays.toString(plusTwo(new int[]{9, 2}, new int[]{3, 4})));
    }

    /*
    makeEnds

    Given an array of ints, return a new array length 2 containing the first and
    last elements from the original array. The original array will be length 1 or more.

    makeEnds([1, 2, 3]) → [1, 3]
    makeEnds([1, 2, 3, 4]) → [1, 4]
    makeEnds([7, 4, 6, 2]) → [7, 2]
    */
    public static int[] makeEnds(int[] arr) {
        return new int[] {arr[0], arr[arr.length - 1]};
    }

    /*
    has23

    Given an int array length 2, return true if it contains a 2 or a 3.

    has23([2, 5]) → true
    has23([4, 3]) → true
    has23([4, 5]) → false
    */
    public static boolean has23(int[] arr) {
        boolean has2 = arr[0] == 2 || arr[1] == 2;
        boolean has3 = arr[0] == 3 || arr[1] == 3;
        return has2 || has3;
    }

    /*
    no23

    Given an int array length 2, return true if it does not contain a 2 or 3.

    no23([4, 5]) → true
    no23([4, 2]) → false
    no23([3, 5]) → false
    */
    public static boolean no23(int[] arr) {
        boolean has2 = arr[0] == 2 || arr[1] == 2;
        boolean has3 = arr[0] == 3 || arr[1] == 3;
        return !has2 && !has3;
    }

    /*
    makeLast

    Given an int array, return a new array with double the length where its last element is the same as the
    original array, and all the other elements are 0. The original array will be length 1 or more.
    Note: by default, a new int array contains all 0's.

    makeLast([4, 5, 6]) → [0, 0, 0, 0, 0, 6]
    makeLast([1, 2]) → [0, 0, 0, 2]
    makeLast([3]) → [0, 3]
    */
    public static int[] makeLast(int[] arr) {
        int[] arrDoubled = new int[arr.length * 2];
        arrDoubled[arrDoubled.length - 1] = arr[arr.length - 1];
        return arrDoubled;
    }


    /*
    double23

    Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2.
    (hint, you can use Arrays.equals())

    double23([2, 2]) → true
    double23([3, 3]) → true
    double23([2, 3]) → false
    */
    public static boolean double23(int[] arr) {
        int count2 = 0, count3 = 0;

        for (int x : arr) {
            if (x == 2) {
                count2++;
            }
            else if (x == 3) {
                count3++;
            }
        }

        return count2 == 2 || count3 == 2;
    }

    /*
    fix23

    Given an int array length 3, if there is a 2 in the array immediately followed by a 3,
    set the 3 element to 0. Return the changed array.

    fix23([1, 2, 3]) → [1, 2, 0]
    fix23([2, 3, 5]) → [2, 0, 5]
    fix23([1, 2, 1]) → [1, 2, 1]
    */
    public static int[] fix23(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            if (arr[x] == 2 && arr[x + 1] == 3) {
                arr[x + 1] = 0;
            }
        }

        return arr;
    }

    /*
    start1

    Start with 2 int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element.

    start1([1, 2, 3], [1, 3]) → 2
    start1([7, 2, 3], [1]) → 1
    start1([1, 2], []) → 1
    */
    public static int start1(int[] first, int[] second) {
        int first1 = 0;
        int second1 = 0;

        if (first.length > 0 && first[0] == 1) {
            first1 = 1;
        }

        if (second.length > 0 && second[0] == 1) {
            second1 = 1;
        }

        return first1 + second1;
    }

    /*
    biggerTwo

    Start with 2 int arrays, a and b, each length 2. Consider the sum of the values in each array.
    Return the array which has the largest sum. In event of a tie, return a.

    biggerTwo([1, 2], [3, 4]) → [3, 4]
    biggerTwo([3, 4], [1, 2]) → [3, 4]
    biggerTwo([1, 1], [1, 2]) → [1, 2]
    */
    public static int[] biggerTwo(int[] first, int[] second) {
        int firstSum = first[0] + first[1];
        int secondSum = second[0] + second[1];

        return (firstSum >= secondSum ? first : second);
    }

    /*
    makeMiddle

    Given an array of ints of even length, return a new array length 2 containing the middle two elements
    from the original array. The original array will be length 2 or more.

    makeMiddle([1, 2, 3, 4]) → [2, 3]
    makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
    makeMiddle([1, 2]) → [1, 2]
    */
    public static int[] makeMiddle(int[] arr) {
        int arrMidLast = arr.length / 2;
        return new int[] {arr[arrMidLast - 1], arr[arrMidLast]};
    }

    /*
    plusTwo

    Given 2 int arrays, each length 2, return a new array length 4 containing all their elements.

    plusTwo([1, 2], [3, 4]) → [1, 2, 3, 4]
    plusTwo([4, 4], [2, 2]) → [4, 4, 2, 2]
    plusTwo([9, 2], [3, 4]) → [9, 2, 3, 4]
    */
    public static int[] plusTwo(int[] first, int[] second) {
        return new int[] {first[0], first[1], second[0], second[1]};
    }
}
