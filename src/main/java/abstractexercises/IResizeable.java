package abstractexercises;

/**
 * ## 1. Write an interface Resizable
 * * Has a method resize(double x) that resizes a Shape’s dimensions by factor x
 * ## 2. Make Rectangle implement Resizable
 * ## 3. Write a main method to:
 * * Define a Rectangle (width = 2, height = 3)
 * * Print the Rectangle‟s area & perimeter
 * * Resize the Rectangle by factor of 2
 * * Re-print the Rectangle‟s area & perimeter
 */

public interface IResizeable {
    void resize(double x);
}