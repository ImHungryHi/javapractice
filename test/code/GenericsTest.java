package code;
import code.neurals.Matrix;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericsTest {
    @Test
    void getObjectFields() {
        System.out.println("Point class:\n==================================");

        for (Map.Entry<String, String> entry : Generics.getObjectFields(Point.class).entrySet()) {
            System.out.println(entry.getKey() + ";" + entry.getValue());
        }

        System.out.println("\nColor class:\n==================================");

        for (Map.Entry<String, String> entry : Generics.getObjectFields(Color.class).entrySet()) {
            System.out.println(entry.getKey() + ";" + entry.getValue());
        }
    }

    @Test
    void upperBoundedWildcardTotal() {
        // Given
        List<Long> list = new ArrayList<>();
        list.add(10l);
        list.add(20l);
        list.add(30l);
        List<Integer> otherList = new ArrayList<>();
        otherList.add(40);
        otherList.add(50);
        otherList.add(60);
        float expected1 = 60l;
        float expected2 = 150l;

        // When
        float actual1 = Generics.upperBoundedWildcardTotal(list);
        float actual2 = Generics.upperBoundedWildcardTotal(otherList);

        // Then
        assertAll(
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2)
        );
    }

    @Test
    void lowerBoundedWildcard() {
        // Given
        List<String> lst = new ArrayList<>();
        List<Object> lstObj = new ArrayList<>();
        List<Object> expected = new ArrayList<>() {{
            add("Yo");
        }};

        // When
        Generics.lowerBoundedWildcard(lst);
        Generics.lowerBoundedWildcard(lstObj);

        // Then
        assertAll(
                () -> assertEquals(expected, lst),
                () -> assertEquals(expected, lstObj)
        );
    }

    @Test
    void setValue() {
    }
}