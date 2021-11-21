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
}