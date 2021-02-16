package strings;

public class LeString3 {
    public static void main(String[] args) {
        System.out.println("mixString :\n");
        System.out.println("abc;xyz = " + mixString("abc", "xyz"));
        System.out.println("Hi;There = " + mixString("Hi", "There"));
        System.out.println("xxxx;There = " + mixString("xxxx", "There"));
        /*
        System.out.println(" :\n");
        System.out.println(" = " + ());
        System.out.println(" = " + ());
        System.out.println(" = " + ());
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
        return "";
    }


    /*
    repeatEnd

    Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
    You may assume that n is between 0 and the length of the string, inclusive.
    repeatEnd("Hello", 3) → "llollollo"
    repeatEnd("Hello", 2) → "lolo"
    repeatEnd("Hello", 1) → "o"
    */


    /*
    repeatFront

    Given a string and an int n, return a string made of the first n characters of the string, followed by the
    first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string,
    inclusive (i.e. n >= 0 and n <= str.length()).

    repeatFront("Chocolate", 4) → "ChocChoChC"
    repeatFront("Chocolate", 3) → "ChoChC"
    repeatFront("Ice Cream", 2) → "IcI"
    */


    /*
    repeatSeparator

    Given two strings, word and a separator sep,
    return a big string made of count occurrences of the word, separated by the separator string.

    repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    repeatSeparator("This", "And", 2) → "ThisAndThis"
    repeatSeparator("This", "And", 1) → "This"
    */


    /*
    xyzMiddle

    Given a string, does "xyz" appear in the middle of the string? To define middle,
    we'll say that the number of chars to the left and right of the "xyz" must differ by at most one.
    This problem is harder than it looks.

    xyzMiddle("AAxyzBB") → true
    xyzMiddle("AxyzBB") → true
    xyzMiddle("AxyzBBB") → false
    */

    /*
    getSandwich

    A sandwich is two pieces of bread with something in between.
    Return the string that is between the first and last appearance of "bread" in the given string,
    or return the empty string "" if there are not two pieces of bread.

    getSandwich("breadjambread") → "jam"
    getSandwich("xxbreadjambreadyy") → "jam"
    getSandwich("xxbreadyy") → ""
    */


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
