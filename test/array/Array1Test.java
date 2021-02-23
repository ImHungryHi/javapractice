package array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Array1Test {

    @Test
    void firstLast6() {
        assertTrue(Array1.firstLast6(new int[] {1,2,6}));
        assertTrue(Array1.firstLast6(new int[] {6, 1, 2, 3}));
        assertFalse(Array1.firstLast6(new int[] {13, 6, 1, 2, 3}));
    }

    @Test
    void sameFirstLast() {
        assertFalse(Array1.sameFirstLast(new int[] {1,2,3}));
        assertTrue(Array1.sameFirstLast(new int[] {1,2,3,1}));
        assertTrue(Array1.sameFirstLast(new int[] {1,2,1}));
    }

    @Test
    void makePi() {
        assertArrayEquals(new int[] {3,1,4},Array1.makePi());
    }

    @Test
    void commonEnd() {
        assertTrue(Array1.commonEnd(new int[] {1, 2, 3}, new int[] {1, 2, 3}));
        assertFalse(Array1.commonEnd(new int[] {1, 2, 3}, new int[] {7,3,2}));
        assertTrue(Array1.commonEnd(new int[] {1, 2, 3}, new int[] {1, 3}));
    }

    @Test
    void sum3() {
        assertEquals(6,Array1.sum3(new int[]{1, 2, 3}));
        assertEquals(18,Array1.sum3(new int[]{5, 11, 2}));
        assertEquals(7,Array1.sum3(new int[]{7, 0, 0}));
    }

    @Test
    void rotateLeft3() {
        assertArrayEquals(new int[]{2, 3, 1},Array1.rotateLeft3(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{11, 9, 5},Array1.rotateLeft3(new int[]{5, 11, 9}));
        assertArrayEquals(new int[]{0, 0, 7},Array1.rotateLeft3(new int[]{7, 0, 0}));
    }

    @Test
    void reverse3() {
        assertArrayEquals(new int[]{3, 2, 1},Array1.reverse3(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{9, 11, 5},Array1.reverse3(new int[]{5, 11, 9}));
        assertArrayEquals(new int[]{0, 0, 7},Array1.reverse3(new int[]{7, 0, 0}));
    }

    @Test
    void maxEnd3() {
        assertArrayEquals(new int[]{3, 3, 3},Array1.maxEnd3(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{11, 11, 11},Array1.maxEnd3(new int[]{11, 5, 9}));
        assertArrayEquals(new int[]{3, 3, 3},Array1.maxEnd3(new int[]{2, 11, 3}));
    }

    @Test
    void sum2() {
        assertEquals(3,Array1.sum2(new int[]{1, 2, 3}));
        assertEquals(2,Array1.sum2(new int[]{1, 1}));
        assertEquals(2,Array1.sum2(new int[]{1, 1, 1,1}));
    }

    @Test
    void middleWay() {
        assertArrayEquals(new int[]{2, 5},Array1.middleWay(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        assertArrayEquals(new int[]{7, 8},Array1.middleWay(new int[]{7, 7, 7}, new int[]{3, 8, 0}));
        assertArrayEquals(new int[]{2, 4},Array1.middleWay(new int[]{5, 2, 9}, new int[]{1, 4, 5}));
    }
}