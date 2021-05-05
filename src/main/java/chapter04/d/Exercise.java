package chapter04.d;

public class Exercise {
    private static String foo = "";

    public static void main(String[] args) {
        // Just calls the method and adds bar to the foo variable. The return result is dropped into a black hole;
        getInteger();
        // Error (not a statement)
        //System.out.println("boo!") + 7;
    }

    public static int getInteger() {
        foo += "bar";
        return 5;
    }
}
