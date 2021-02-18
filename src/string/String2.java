package string;

public class String2 {
    /*
    Implement all methods as public static
     */
    public static void main(String[] args) {
        System.out.println("double LaForge: " + doubleChar("LaForge"));
        System.out.println("Count the hi's:\nhihi = " + countHi("hihi") + "\nHi de hi de ho: " + countHi("Hi de hi de ho") + "\nTeehee, hihi hi: " + countHi("Teehee, hihi hi"));
        System.out.println("catdog = " + catDog("catdog") + "\ncatcat = " + catDog("catcat") + "\n1cat1cadodog = " + catDog("1cat1cadodog"));
        System.out.println("countCode:\naaacodebbb = " + countCode("aaacodebbb") + "\ncodexxcode" + countCode("codexxcode") + "\ncozexxcope" + countCode("cozexxcope"));
        System.out.println("endOther:\nHiabc;abc = " + endOther("Hiabc", "abc") + "\nAbC;HiaBc = " + endOther("AbC", "HiaBc") + "\nabc;abXabc = " + endOther("abc", "abXabc"));
        System.out.println("xyzThere:\nabcxyz = " + xyzThere("abcxyz") + "\nabc.xyz = " + xyzThere("abc.xyz") + "\nxyz.abc = " + xyzThere("xyz.abc"));
        System.out.println("bobThere:\nabcbob = " + bobThere("abcbob") + "\nb9b = " + bobThere("b9b") + "\nbac = " + bobThere("bac"));
        System.out.println("xyBalance:\naaxbby = " + xyBalance("aaxbby") + "\naaxbb = " + xyBalance("aaxbb") + "\nyaaxbb = " + xyBalance("yaaxbb"));
        System.out.println("prefixAgain:\nabXYabc, 1 = " + prefixAgain("abXYabc", 1) + "\nabXYabc, 2 = " + prefixAgain("abXYabc", 2) + "\nabXYabc, 3 = " + prefixAgain("abXYabc", 3));
        System.out.println("sameStarChar:\nxy*yzz = " + sameStarChar("xy*yzz") + "\nxy*zzz = " + sameStarChar("xy*zzz") + "\n*xa*az = " + sameStarChar("*xa*az"));
    }

    /*
    implement doubleChar
    Given a string, return a string where for every char in the original, there are two chars.

    doubleChar("The") → "TThhee"
    doubleChar("AAbb") → "AAAAbbbb"
    doubleChar("Hi-There") → "HHii--TThheerree"
     */
    public static String doubleChar(String str) {
        String result = "";

        for (char c : str.toCharArray())
            result = result + c + "" + c;

        return result;
    }

    /*
    implement countHi
    Return the number of times that the string "hi" appears anywhere in the given string.

    countHi("abc hi ho") → 1
    countHi("ABChi hi") → 2
    countHi("hihi") → 2
     */
    public static int countHi(String str) {
        int count = 0, start = 0;
        str = str.toLowerCase();

        while (start < (str.length() - 1)) {
            if (str.substring(start, start + 2).equals("hi")) {
                count++;
                start += 2;
            }
            else start++;
        }

        return count;
    }

    /*
    implement catDog
    Return true if the string "cat" and "dog" appear the same number of times in the given string.

    catDog("catdog") → true
    catDog("catcat") → false
    catDog("1cat1cadodog") → true
     */
    public static boolean catDog(String str) {
        int cats = 0, dogs = 0, start = 0;

        while (start < (str.length() - 1)) {
            String comp = str.substring(start, start + 3).toLowerCase();
            if (comp.equals("cat")) {
                cats++;
                start += 3;
            }
            else if (comp.equals("dog")) {
                dogs++;
                start += 3;
            }
            else start++;
        }

        return (cats == dogs);
    }

    /*
    implement countCode
    Return the number of times that the string "code" appears anywhere in the given string,
    except we'll accept any letter for the 'd', so "cope" and "cooe" count.

    countCode("aaacodebbb") → 1
    countCode("codexxcode") → 2
    countCode("cozexxcope") → 2
     */
    public static int countCode(String str) {
        int count = 0, start = 0;
        str = str.toLowerCase();

        while (str.toLowerCase().indexOf("co", start) >= 0) {
            if (str.charAt(start + 3) == 'e') count++;
            start += 3;
        }

        return count;
    }

    /*
    implement endOther
    Given two strings, return true if either of the strings appears at the very
    end of the other string, ignoring upper/lower case differences
    (in other words, the computation should not be "case sensitive").
     Note: str.toLowerCase() returns the lowercase version of a string.

    endOther("Hiabc", "abc") → true
    endOther("AbC", "HiaBc") → true
    endOther("abc", "abXabc") → true
     */
    public static boolean endOther(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.length() > s2.length()) {
            String lastInS1 = s1.substring(s1.length() - s2.length());
            return lastInS1.equals(s2);
        }
        else if (s2.length() > s1.length()) {
            String lastInS2 = s2.substring(s2.length() - s1.length());
            return lastInS2.equals(s1);
        }

        return (s1.equals(s2));
    }

    /*
    implement xyzThere
    Return true if the given string contains an appearance of "xyz" where the xyz is not directly
    preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

    xyzThere("abcxyz") → true
    xyzThere("abc.xyz") → false
    xyzThere("xyz.abc") → true
     */
    public static boolean xyzThere(String str) {
        int idx = str.indexOf("xyz");

        if (idx < 1) {
            return false;
        }


        return str.charAt(idx - 1) == '.';
    }

    /*
    implement bobThere
    Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.

    bobThere("abcbob") → true
    bobThere("b9b") → true
    bobThere("bac") → false
     */
    public static boolean bobThere(String str) {
        for (int x = 1; x < (str.length() - 1); x++) {
            if (str.charAt(x - 1) == 'b' && str.charAt(x + 1) == 'b') {
                return true;
            }
        }

        return false;
    }

    /*
    implement xyBalance
    We'll say that a String is xy-balanced if for all the 'x' chars in the string,
    there exists a 'y' char somewhere later in the string. So "xxy" is balanced,
    but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.

    xyBalance("aaxbby") → true
    xyBalance("aaxbb") → false
    xyBalance("yaaxbb") → false
     */
    public static boolean xyBalance(String str) {
        char[] chars = str.toCharArray();
        int countX = 0, countY = 0;

        for (char c : chars) {
            if (c == 'x') {
                countX++;
            }
            else if (c == 'y' && countX > countY) {
                countY++;
            }
        }

        return countX == countY && countX > 0;
    }

    /*
    implement prefixAgain
    Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().

    prefixAgain("abXYabc", 1) → true
    prefixAgain("abXYabc", 2) → true
    prefixAgain("abXYabc", 3) → false
     */
    public static boolean prefixAgain(String str, int n) {
        String start = str.substring(0, n);
        return (str.indexOf(start, n)) > 0;
    }

    /*
    implement sameStarChar
    Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.

    sameStarChar("xy*yzz") → true
    sameStarChar("xy*zzz") → false
    sameStarChar("*xa*az") → true
     */
    public static boolean sameStarChar(String str) {
        int idx = str.indexOf('*', 1), start = 1;

        while (idx >= 0 && start < (str.length() - 1)) {
            if (idx == 0) {
                start++;
            }
            else if (idx == (str.length() - 1)) {
                break;
            }
            else if (str.charAt(idx - 1) == str.charAt(idx + 1)) {
                return true;
            }

            start++;
        }

        return false;
    }
}
