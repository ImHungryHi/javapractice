package code;

import code.neurals.Matrix;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Map;

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
    void setValue() {
    }
}