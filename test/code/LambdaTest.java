package code;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class LambdaTest {
    private static String[] arrNames;
    private static List<String> lstNames;

    @BeforeAll
    static void setup() {
        arrNames = new String[] { "Bob", "ALICE", "CHRIS", "Johnny" };
        lstNames = Arrays.asList(arrNames);
    }

    @Test
    void getUpperCase() {
        // Given
        List<String> expected = Arrays.asList("ALICE", "CHRIS");

        // When
        List<String> upperCase = Lambda.getUpperCase(lstNames);

        // Then
        assertEquals(expected, upperCase);
    }

    @Test
    void getLowerCase() {
        // Given
        List<String> expected = Arrays.asList("Bob", "Johnny");

        // When
        List<String> upperCase = Lambda.getLowerCase(lstNames);

        // Then
        assertEquals(expected, upperCase);
    }

    @Test
    void hasUpperCase() {
        // When
        boolean hasUpperCase = Lambda.hasUpperCase(lstNames);

        // Then
        assertTrue(hasUpperCase);
    }
}