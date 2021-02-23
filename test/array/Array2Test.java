package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Array2Test {

    @Test
    void makeEnds() {
        assertArrayEquals(new int[]{1,3},Array2.makeEnds(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1,4},Array2.makeEnds(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{7,2},Array2.makeEnds(new int[]{7,4,6,2}));
    }

    @Test
    void has23() {
        assertTrue(Array2.has23(new int[]{2,5}));
        assertTrue(Array2.has23(new int[]{4,3}));
        assertFalse(Array2.has23(new int[]{4,5}));
    }

    @Test
    void no23() {
        assertTrue(Array2.no23(new int[]{4,5}));
        assertFalse(Array2.no23(new int[]{4,2}));
        assertFalse(Array2.no23(new int[]{3,5}));
    }

    @Test
    void makeLast() {
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 6},Array2.makeLast(new int[]{4, 5, 6}));
        assertArrayEquals(new int[]{ 0, 0, 0, 2},Array2.makeLast(new int[]{1,2}));
        assertArrayEquals(new int[]{0, 3},Array2.makeLast(new int[]{3}));
    }

    @Test
    void double23() {
        assertTrue(Array2.double23(new int[]{2,2}));
        assertTrue(Array2.double23(new int[]{3,3}));
        assertFalse(Array2.double23(new int[]{2,3}));
    }

    @Test
    void fix23() {
        assertArrayEquals(new int[]{1,2,0},Array2.fix23(new int[]{1,2,3}));
        assertArrayEquals(new int[]{2,0,5},Array2.fix23(new int[]{2,3,5}));
        assertArrayEquals(new int[]{1,2,1},Array2.fix23(new int[]{1,2,1}));
    }

    @Test
    void start1() {
        assertEquals(2,Array2.start1(new int[]{1,2,3},new int[]{1,3}));
        assertEquals(1,Array2.start1(new int[]{7,2,3},new int[]{1}));
        assertEquals(1,Array2.start1(new int[]{1,2},new int[]{}));
    }

    @Test
    void biggerTwo() {
        assertArrayEquals(new int[]{3,4},Array2.biggerTwo(new int[]{1,2},new int[]{3,4}));
        assertArrayEquals(new int[]{3,4},Array2.biggerTwo(new int[]{3,4},new int[]{1,2}));
        assertArrayEquals(new int[]{1,2},Array2.biggerTwo(new int[]{1,1},new int[]{1,2}));
    }

    @Test
    void makeMiddle() {
        assertArrayEquals(new int[]{2,3},Array2.makeMiddle(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{2,3},Array2.makeMiddle(new int[]{7, 1, 2, 3, 4, 9}));
        assertArrayEquals(new int[]{1,2},Array2.makeMiddle(new int[]{1, 2}));

    }

    @Test
    void plusTwo() {
        assertArrayEquals(new int[]{1,2,3,4},Array2.plusTwo(new int[]{1,2},new int[]{3,4}));
        assertArrayEquals(new int[]{4,4,2,2},Array2.plusTwo(new int[]{4,4},new int[]{2,2}));
        assertArrayEquals(new int[]{9,2,3,4},Array2.plusTwo(new int[]{9,2},new int[]{3,4}));
    }
}