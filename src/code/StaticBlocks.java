package code;

import java.io.*;
import java.util.*;

public class StaticBlocks {
    // Inline declaration of a Map/HashMap object
    public static Map<Double, String> labels = new HashMap<Double, String>() {
        {
            put(1d, "First");
            put(2d, "Second");
            put(3d, "Third");
            put(4d, "Fourth");
            put(5d, "Fifth");
        }
    };

    // Another one of these to get into it
    public class Solution {
        int intVar;
        double doubleVar;
        Double DoubleVar;
        boolean booleanVar;
        Object ObjectVar;
        Exception ExceptionVar;
        String StringVar;

        public void printInline() {
            Solution sol = new Solution() {
                {
                    System.out.println(intVar);
                    System.out.println(doubleVar);
                    System.out.println(DoubleVar);
                    System.out.println(booleanVar);
                    System.out.println(ObjectVar);
                    System.out.println(ExceptionVar);
                    System.out.println(StringVar);
                }
            };
        }
    }

    // This CANNOT be done in a constructor or function, only as a pseudo-attribute
    //  here we read the values for A and B from keyboard the moment the object is made
    public static int A;
    public static int B;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        try {
            A = Integer.parseInt(reader.readLine());
            B = Integer.parseInt(reader.readLine());
        }
        catch (IOException ex) {
            //
        }
    }

    public static final int MIN = min(A, B);
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
