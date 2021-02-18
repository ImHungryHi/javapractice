package array;

public class Array2 {
    /*
    makeEnds

    Given an array of ints, return a new array length 2 containing the first and
    last elements from the original array. The original array will be length 1 or more.

    makeEnds([1, 2, 3]) → [1, 3]
    makeEnds([1, 2, 3, 4]) → [1, 4]
    makeEnds([7, 4, 6, 2]) → [7, 2]
    */


    /*
    has23

    Given an int array length 2, return true if it contains a 2 or a 3.

    has23([2, 5]) → true
    has23([4, 3]) → true
    has23([4, 5]) → false
    */


    /*
    no23

    Given an int array length 2, return true if it does not contain a 2 or 3.

    no23([4, 5]) → true
    no23([4, 2]) → false
    no23([3, 5]) → false
    */


    /*
    makeLast

    Given an int array, return a new array with double the length where its last element is the same as the
    original array, and all the other elements are 0. The original array will be length 1 or more.
    Note: by default, a new int array contains all 0's.

    makeLast([4, 5, 6]) → [0, 0, 0, 0, 0, 6]
    makeLast([1, 2]) → [0, 0, 0, 2]
    makeLast([3]) → [0, 3]
    */



    /*
    double23

    Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2.
    (hint, you can use Arrays.equals())

    double23([2, 2]) → true
    double23([3, 3]) → true
    double23([2, 3]) → false
    */


    /*
    fix23

    Given an int array length 3, if there is a 2 in the array immediately followed by a 3,
    set the 3 element to 0. Return the changed array.

    fix23([1, 2, 3]) → [1, 2, 0]
    fix23([2, 3, 5]) → [2, 0, 5]
    fix23([1, 2, 1]) → [1, 2, 1]
    */


    /*
    start1

    Start with 2 int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element.

    start1([1, 2, 3], [1, 3]) → 2
    start1([7, 2, 3], [1]) → 1
    start1([1, 2], []) → 1
    */


    /*
    biggerTwo

    Start with 2 int arrays, a and b, each length 2. Consider the sum of the values in each array.
    Return the array which has the largest sum. In event of a tie, return a.

    biggerTwo([1, 2], [3, 4]) → [3, 4]
    biggerTwo([3, 4], [1, 2]) → [3, 4]
    biggerTwo([1, 1], [1, 2]) → [1, 2]
    */


    /*
    makeMiddle

    Given an array of ints of even length, return a new array length 2 containing the middle two elements
    from the original array. The original array will be length 2 or more.

    makeMiddle([1, 2, 3, 4]) → [2, 3]
    makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
    makeMiddle([1, 2]) → [1, 2]
    */

    /*
    plusTwo

    Given 2 int arrays, each length 2, return a new array length 4 containing all their elements.

    plusTwo([1, 2], [3, 4]) → [1, 2, 3, 4]
    plusTwo([4, 4], [2, 2]) → [4, 4, 2, 2]
    plusTwo([9, 2], [3, 4]) → [9, 2, 3, 4]
    */
}
