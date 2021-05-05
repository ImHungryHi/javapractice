package chapter05.d;

public class Exercise {
    static boolean yes = true;
    static boolean no = false;
    static int loVal = -999;
    static int hiVal = 999;
    static double grade = 87.5;
    static double amount = 50.0;
    static String hello = "world";

    public static void main(String[] args) {
        System.out.println(yes == no || grade > amount);    // false or true = true
        //System.out.println(amount == 40.0 || 50.0);       // Error - 50.0 is double, not boolean
        System.out.println(hiVal != loVal || loVal < 0);    // true or true = true, second boolean unnecessary
        //System.out.println(True || hello.length() > 0);   // Error - True doesn't exist, true does
        System.out.println(hello.isEmpty() && yes);         // false and true = false
        System.out.println(grade <= 100 && !false);         // true and true = true
        System.out.println(!yes || no);                     // false or false = false;
        //System.out.println(grade > 75 > amount);          // Error - can't compare boolean (grade > 75) to double
        System.out.println(amount <= hiVal && amount >= loVal); // true and true = true
        System.out.println(no && !no || yes && !yes);       // (false && true) or (true && false) = false
        // all booleans, except !no, will be checked
    }
}
