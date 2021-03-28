package chapter09.a;

public class Test {
    public static void main(String[] args) {
        System.out.println("Adding a string and " + 'a' + " char just makes a string");
        /**
         * Part deux:
         *          |   boolean |   char    |   int     |   double  |   String
         * boolean  |   illegal |   illegal |   illegal |   illegal |   String
         *          |           |           |           |           |   concat
         * char     |   illegal |   String  |   int     |   double  |   String
         *          |           |   concat  |   add     |   add     |   concat
         * int      |   illegal |   int     |   int     |   double  |   String
         *          |           |   add     |   add     |   add     |   concat
         * double   |   illegal |   double  |   double  |   double  |   String
         *          |           |   add     |   add     |   add     |   concat
         * String   |   String  |   String  |   String  |   String  |   String
         *          |   concat  |   concat  |   concat  |   concat  |   concat
         */

        // Seems logical to me, although booleans could technically be summed together as though they are
        //  an OR statement and adding to a number would be easy when adding a 1 or 0 instead of true/false.
        int a = 1;
        System.out.println(a);
        a++;
        System.out.println(a);
        a += 2;
        System.out.println(a);
        char c = 'b';
        System.out.println(c);
        c++;
        System.out.println(c);
        c += 2;
        System.out.println(c);
        //c = c + 2;
        // incompatible types, possible lossy conversion from int to char

        // Part 5: adding an empty string "" to anything will concatenate both objects into a String
    }
}
