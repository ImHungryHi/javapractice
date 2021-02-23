package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Array3Test {

    @Test
    void fizzArray() {
        assertArrayEquals(new int[]{5, 6, 7, 8, 9}, Array3.fizzArray3(5,10));
        assertArrayEquals(new int[]{11, 12, 13, 14, 15, 16, 17}, Array3.fizzArray3(11,18));
        assertArrayEquals(new int[]{1,2}, Array3.fizzArray3(1,3));
    }

    @Test
    void shiftLeft() {
        assertArrayEquals(new int[]{2, 5, 3, 6}, Array3.shiftLeft(new int[]{6, 2, 5, 3}));
        assertArrayEquals(new int[]{2,1}, Array3.shiftLeft(new int[]{1,2}));
        assertArrayEquals(new int[]{1}, Array3.shiftLeft(new int[]{1}));
    }

    @Test
    void tenRun() {
        assertArrayEquals(new int[]{2, 10, 10, 10, 20, 20}, Array3.tenRun(new int[]{2, 10, 3, 4, 20, 5}));
        assertArrayEquals(new int[]{10, 10, 20, 20}, Array3.tenRun(new int[]{10, 1, 20, 2}));
        assertArrayEquals(new int[]{10, 10, 10, 20}, Array3.tenRun(new int[]{10, 1, 9, 20}));
    }

    @Test
    void pre4() {
        assertArrayEquals(new int[]{1,2}, Array3.pre4(new int[]{1, 2, 4, 1}));
        assertArrayEquals(new int[]{3,1}, Array3.pre4(new int[]{3, 1, 4}));
        assertArrayEquals(new int[]{1}, Array3.pre4(new int[]{1,4,4}));
    }

    @Test
    void notAlone() {
        assertArrayEquals(new int[]{1,3,3}, Array3.notAlone(new int[]{1, 2, 3},2));
        assertArrayEquals(new int[]{1, 3, 3, 5, 5, 2}, Array3.notAlone(new int[]{1, 2, 3, 2, 5, 2},2));
        assertArrayEquals(new int[]{3,4}, Array3.notAlone(new int[]{3,4},3));

    }

    @Test
    void zeroFront() {
        assertArrayEquals(new int[]{0,0,1,1}, Array3.zeroFront(new int[]{1, 0, 0, 1}));
        assertArrayEquals(new int[]{0,0,1,1,1}, Array3.zeroFront(new int[]{0, 1, 1, 0, 1}));
        assertArrayEquals(new int[]{0,1}, Array3.zeroFront(new int[]{1, 0}));
    }

    @Test
    void withoutTen() {
        assertArrayEquals(new int[]{1,2,0,0}, Array3.withoutTen(new int[]{1, 10, 10, 2}));
        assertArrayEquals(new int[]{2,0,0}, Array3.withoutTen(new int[]{10, 2, 10}));
        assertArrayEquals(new int[]{1,99,0}, Array3.withoutTen(new int[]{1,99,10}));
    }

    @Test
    void zeroMax() {
        assertArrayEquals(new int[]{5, 5, 3, 3}, Array3.zeroMax(new int[]{0, 5, 0, 3}));
        assertArrayEquals(new int[]{3, 4, 3, 3}, Array3.zeroMax(new int[]{0, 4, 0, 3}));
        assertArrayEquals(new int[]{1, 1, 0}, Array3.zeroMax(new int[]{0, 1, 0}));
    }

    @Test
    void evenOdd() {
        assertArrayEquals(new int[]{0, 0, 0, 1, 1, 1, 1}, Array3.evenOdd(new int[]{1, 0, 1, 0, 0, 1, 1}));
        assertArrayEquals(new int[]{2,3,3}, Array3.evenOdd(new int[]{3, 3, 2}));
        assertArrayEquals(new int[]{2,2,2}, Array3.evenOdd(new int[]{2,2,2}));
    }

    @Test
    void fizzBuzz() {
        assertArrayEquals(new String[]{"1", "2", "Fizz", "4", "Buzz"}, Array3.fizzBuzz(1,6));
        assertArrayEquals(new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7"}, Array3.fizzBuzz(1,8));
        assertArrayEquals(new String[]{"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"}, Array3.fizzBuzz(1,11));

    }
}