package code.interfacing;

public class Triangle implements Shape {
    private float height = 0;
    private float base = 0;

    public Triangle(float height, float base) {
        this.height = height;
        this.base = base;
    }

    public float calcSurface() {
        return (base * height) / 2;
    }

    public float calcCircumference() {
        // what is a base and height in triangle if not a set of 2 pythagorean triangles?
        // eg: b = 6 & h = 4: 2 triangles of a = 3 & b = 4 making c = 5
        float a = base / 2;                                // 2 equal 'a' sides
        float b = height;                                  // 1 shared 'b' side
        float c = (float)Math.sqrt((a * a) + (b * b));     // 2 equal 'c' sides
        return a + a + b + c + c;

        // 5 = base; 10.307764 = a & c
        //
    }

    public static float calcHeronArea(float a, float b, float c) {
        // Find semiperimeter (half of the perimeter)
        float semiperimeter = (a + b + c) / 2;
        float heronsForm = (float)Math.sqrt(semiperimeter * (semiperimeter - a) *
                (semiperimeter - b) * (semiperimeter - c));
        return heronsForm;
    }

    public static float calcHeightFromArea(float area, float base) {
        return (2 * area) / base;
    }
}
