package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {
    @Test
    void findMedianSortedArrays() {
        int[] a1 = {4, 3, 6, 9, 10},
                a2 = {1, 2, 3, 4, 5},
                b1 = {3, 5, 7, 1},
                b2 = {2, 4, 8, 6},
                c1 = {8, 5, 3, 1, 2},
                c2 = {9, 2, 4, 5},
                d1 = {2, 3, 6, 7},
                d2 = {1, 5, 33, 6, 7};

        assertEquals(4d ,Exercises.findMedianSortedArrays(a1, a2));
        assertEquals(4d,Exercises.findMedianSortedArrays(b1, b2));
        assertEquals(4d, Exercises.findMedianSortedArrays(c1, c2));
        assertEquals(6d, Exercises.findMedianSortedArrays(d1, d2));
    }

    @Test
    void sortMerge() {
        int[] a1 = {4, 3, 6, 9, 10},
                a2 = {1, 2, 3, 4, 5},
                b1 = {3, 5, 7, 1},
                b2 = {2, 4, 8, 6},
                c1 = {8, 5, 3, 1, 2},
                c2 = {9, 2, 4, 5},
                d1 = {2, 3, 6, 7},
                d2 = {1, 5, 33, 6, 7},
                a = {1, 2, 3, 3, 4, 4, 5, 6, 9, 10},
                b = {1, 2, 3, 4, 5, 6, 7, 8},
                c = {1, 2, 2, 3, 4, 5, 5, 8, 9},
                d = {1, 2, 3, 5, 6, 6, 7, 7, 33},
                e = Exercises.sortMerge(a1, a2),
                f = Exercises.sortMerge(b1, b2),
                g = Exercises.sortMerge(c1, c2),
                h = Exercises.sortMerge(d1, d2);

        assertEquals(Arrays.toString(a), Arrays.toString(e));
        assertEquals(Arrays.toString(b), Arrays.toString(f));
        assertEquals(Arrays.toString(c), Arrays.toString(g));
        assertEquals(Arrays.toString(d), Arrays.toString(h));
    }
}