package code.tdd;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static code.tdd.Maths.*;

class MathsTest {
    // Start off somewhere silly - like doing nothing
    @Test
    void doNothing() {
        // Given

        // When

        // Then
    }

    // In reality, we would get rid of the doNothing function immediately after running and test all assertions in
    //  this function
    @Test
    void shouldReturn_PrimeFactorList_V1() {
        assertEquals(PrimeFactorsOf_V1(1), new ArrayList<>());
    }

    @Test
    void shouldReturn_PrimeFactorList_V2() {
        assertEquals(PrimeFactorsOf_V2(1), new ArrayList<>());
        assertEquals(PrimeFactorsOf_V2(2), Arrays.asList(2));   // This would fail without changing the Maths class
    }

    @Test
    void shouldReturn_PrimeFactorList_V3() {
        assertEquals(PrimeFactorsOf_V3(1), new ArrayList<>());
        assertEquals(PrimeFactorsOf_V3(2), Arrays.asList(2));
        assertEquals(PrimeFactorsOf_V3(3), Arrays.asList(3));
    }

    @Test
    void shouldReturn_PrimeFactorList_V4() {
        assertEquals(PrimeFactorsOf_V4(1), new ArrayList<>());
        assertEquals(PrimeFactorsOf_V4(2), Arrays.asList(2));
        assertEquals(PrimeFactorsOf_V4(3), Arrays.asList(3));
        assertEquals(PrimeFactorsOf_V4(4), Arrays.asList(2, 2));
    }

    @Test
    void shouldReturn_PrimeFactorList_V5() {
        assertEquals(PrimeFactorsOf_V5(1), new ArrayList<>());
        assertEquals(PrimeFactorsOf_V5(2), Arrays.asList(2));
        assertEquals(PrimeFactorsOf_V5(3), Arrays.asList(3));
        assertEquals(PrimeFactorsOf_V5(4), Arrays.asList(2, 2));
        assertEquals(PrimeFactorsOf_V5(5), Arrays.asList(5));       // 5 doesn't change much to our test at this point, move onto 6
        assertEquals(PrimeFactorsOf_V5(6), Arrays.asList(2, 3));    // 6 coincidentally doesn't fail as we add 2, divide by 2 and are left with 3
        assertEquals(PrimeFactorsOf_V5(7), Arrays.asList(7));       // 7 doesn't change anything either
        assertEquals(PrimeFactorsOf_V5(8), Arrays.asList(2, 2, 2)); // This is where it gets interesting - we need an extra step now
    }

    @Test
    void shouldReturn_PrimeFactorList_V6() {
        assertEquals(PrimeFactorsOf_V6(1), new ArrayList<>());
        assertEquals(PrimeFactorsOf_V6(2), Arrays.asList(2));
        assertEquals(PrimeFactorsOf_V6(3), Arrays.asList(3));
        assertEquals(PrimeFactorsOf_V6(4), Arrays.asList(2, 2));
        assertEquals(PrimeFactorsOf_V6(5), Arrays.asList(5));
        assertEquals(PrimeFactorsOf_V6(6), Arrays.asList(2, 3));
        assertEquals(PrimeFactorsOf_V6(7), Arrays.asList(7));
        assertEquals(PrimeFactorsOf_V6(8), Arrays.asList(2, 2, 2));
        assertEquals(PrimeFactorsOf_V6(9), Arrays.asList(3, 3));    // We don't have anything to divide by 3 yet - oops

        // Since the function is finished at this point, put it through its paces one last time
        assertEquals(
                PrimeFactorsOf_V6(2 * 2 * 3 * 3 * 5 * 7 * 11 * 11 * 13),
                Arrays.asList(2, 2, 3, 3, 5, 7, 11, 11, 13));
    }
}