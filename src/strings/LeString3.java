package strings;

public class LeString3 {
    public static void main(String[] args) {
        /*System.out.println("mixString :");
        System.out.println("abc;xyz = " + mixString("abc", "xyz"));
        System.out.println("Hi;There = " + mixString("Hi", "There"));
        System.out.println("xxxx;There = " + mixString("xxxx", "There"));

        System.out.println("\nrepeatEnd :");
        System.out.println("Hello;3 = " + repeatEnd("Hello", 3));
        System.out.println("Hello;2 = " + repeatEnd("Hello", 2));
        System.out.println("Hello;1 = " + repeatEnd("Hello", 1));

        System.out.println("\nrepeatFront :");
        System.out.println("Chocolate;4 = " + repeatFront("Chocolate", 4));
        System.out.println("Chocolate;3 = " + repeatFront("Chocolate", 3));
        System.out.println("Ice Cream;2 = " + repeatFront("Ice Cream", 2));

        System.out.println("\nrepeatSeparator :");
        System.out.println("Word;X;3 = " + repeatSeparator("Word", "X", 3));
        System.out.println("This;And;2 = " + repeatSeparator("This", "And", 2));
        System.out.println("This;And;1 = " + repeatSeparator("This", "And", 1));

        System.out.println("\nxyzMiddle :");
        System.out.println("AAxyzBB = " + xyzMiddle("AAxyzBB"));
        System.out.println("AxyzBB = " + xyzMiddle("AxyzBB"));
        System.out.println("AxyzBB = " + xyzMiddle("AxyzBBB"));*/

        System.out.println("\ngetSandwich :");
        System.out.println("breadjambread = " + getSandwich("breadjambread"));
        System.out.println("xxbreadjambreadyy = " + getSandwich("xxbreadjambreadyy"));
        System.out.println("xxbreadyy = " + getSandwich("xxbreadyy"));

        /*

        System.out.println("\n :");
        System.out.println(" = " + );
        System.out.println(" = " + );
        System.out.println(" = " + );
        */
    }

    /*
    mixString

    Given two strings, a and b, create a bigger string made of the first char of a,
    the first char of b, the second char of a, the second char of b, and so on.
    Any leftover chars go at the end of the result.

    mixString("abc", "xyz") → "axbycz"
    mixString("Hi", "There") → "HTihere"
    mixString("xxxx", "There") → "xTxhxexre"
    */
    public static String mixString(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int largestLength = a.length();

        if (b.length() > largestLength) {
            largestLength = b.length();
        }

        for (int i = 0; i < largestLength; i++) {
            if (i < a.length()) {
                builder.append(a.charAt(i));
            }

            if (i < b.length()) {
                builder.append(b.charAt(i));
            }
        }

        return builder.toString();
    }

    /*
    repeatEnd

    Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
    You may assume that n is between 0 and the length of the string, inclusive.
    repeatEnd("Hello", 3) → "llollollo"
    repeatEnd("Hello", 2) → "lolo"
    repeatEnd("Hello", 1) → "o"
    */
    public static String repeatEnd(String str, int n) {
        String subString = str.substring(str.length() - n);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append(subString);
        }

        return builder.toString();
    }

    /*
    repeatFront

    Given a string and an int n, return a string made of the first n characters of the string, followed by the
    first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string,
    inclusive (i.e. n >= 0 and n <= str.length()).

    repeatFront("Chocolate", 4) → "ChocChoChC"
    repeatFront("Chocolate", 3) → "ChoChC"
    repeatFront("Ice Cream", 2) → "IcI"
    */
    public static String repeatFront(String str, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String subString = str.substring(0, (n - i));
            builder.append(subString);
        }

        return builder.toString();
    }

    /*
    repeatSeparator

    Given two strings, word and a separator sep,
    return a big string made of count occurrences of the word, separated by the separator string.

    repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    repeatSeparator("This", "And", 2) → "ThisAndThis"
    repeatSeparator("This", "And", 1) → "This"
    */
    public static String repeatSeparator(String str, String delim, int n) {
        StringBuilder builder = new StringBuilder();

        if (n > 0) {
            builder.append(str);
        }

        for (int i = 1; i < n; i++) {
            builder.append(delim).append(str);
        }

        return builder.toString();
    }

    /*
    xyzMiddle

    Given a string, does "xyz" appear in the middle of the string? To define middle,
    we'll say that the number of chars to the left and right of the "xyz" must differ by at most one.
    This problem is harder than it looks.

    xyzMiddle("AAxyzBB") → true
    xyzMiddle("AxyzBB") → true
    xyzMiddle("AxyzBBB") → false
    */
    public static boolean xyzMiddle(String str) {
        int xyzIndex = str.indexOf("xyz");

        if (xyzIndex > 0) {
            String prefix = str.substring(0, xyzIndex);
            String suffix = str.substring(xyzIndex + 3);

            switch (prefix.length() - suffix.length()) {
                case 1:
                case 0:
                case -1:
                    return true;
            }
        }

        return false;
    }

    /*
    getSandwich

    A sandwich is two pieces of bread with something in between.
    Return the string that is between the first and last appearance of "bread" in the given string,
    or return the empty string "" if there are not two pieces of bread.

    getSandwich("breadjambread") → "jam"
    getSandwich("xxbreadjambreadyy") → "jam"
    getSandwich("xxbreadyy") → ""
    */
    public static String getSandwich(String str) {
        return "";
    }

    /*
    oneTwo

    Given a string, compute a new string by moving the first char to come after the next two chars,
    so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd".
    Ignore any group of fewer than 3 chars at the end.

    oneTwo("abc") → "bca"
    oneTwo("tca") → "cat"
    oneTwo("tcagdo") → "catdog"
    */

    /*
    zipZap

    Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'.
    Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
    zipZap("zipXzap") → "zpXzp"
    zipZap("zopzop") → "zpzp"
    zipZap("zzzopzop") → "zzzpzp"
    */


    /*
    starOut

    Return a version of the given string, where for every star (*) in the string the star and the chars immediately
    to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".

    starOut("ab*cd") → "ad"
    starOut("ab**cd") → "ad"
    starOut("sm*eilly") → "silly"
    */


    /*
    plusOut

    Given a string and a non-empty word string, return a version of the original String where all chars
    have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.

    plusOut("12xy34", "xy") → "++xy++"
    plusOut("12xy34", "1") → "1+++++"
    plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
    */
}
