package string;

public class String1 {
    public static void main(String[] args) {
        System.out.println("helloName:");
        System.out.println("Charel = " + helloName("Charel"));
        System.out.println("makeAbba:");
        System.out.println("Yo;Sup = " + makeAbba("Yo","Sup"));
        System.out.println("makeTags:");
        System.out.println("b;Coming out the gate strong! = " + makeTags("b", "Coming out the gate strong!"));
        System.out.println("makeOutWord:");
        System.out.println("[[]];Jabberwock = " + makeOutWord("[[]]", "Jabberwock"));
        System.out.println("extraEnd:");
        System.out.println("JubJub = " + extraEnd("JubJub"));
        System.out.println("firstTwo:");
        System.out.println("Bandersnatch = " + firstTwo("Bandersnatch"));
        System.out.println("firstHalf:");
        System.out.println("Frabjous = " + firstHalf("Frabjous"));
        System.out.println("withoutEnd:");
        System.out.println("Calloo = " + withoutEnd("Calloo"));
        System.out.println("comboString:");
        System.out.println("Twas;Brillig = " + comboString("Twas", "Brillig"));
        System.out.println("nonStart:");
        System.out.println("Slithy;Toves = " + nonStart("Slithy", "Toves"));
        System.out.println("left2:");
        System.out.println("Gyre = " + left2("Gyre"));
        System.out.println("right2:");
        System.out.println("Gimble = " + right2("Gimble"));
        System.out.println("theEnd:");
        System.out.println("Wabe = " + theEnd("Wabe", true));
        System.out.println("withouEnd2:");
        System.out.println("Mimsy = " + withouEnd2("Mimsy"));
        System.out.println("middleTwo:");
        System.out.println("Outgrabe = " + middleTwo("Outgrabe"));
        System.out.println("endsLy:");
        System.out.println("Willy = " + endsLy("Willy"));
        System.out.println("nTwice:");
        System.out.println("Mome raths = " + nTwice("Mome raths", 3));
        System.out.println("twoChar:\njava;0 = " + twoChar("java", 0) + "\njava;2 = " + twoChar("java", 2) + "\njava;3 = " + twoChar("java", 3));
        System.out.println("Borogoves = " + twoChar("Borogoves", 3));
        System.out.println("middleThree:");
        System.out.println("Megaman = " + middleThree("Megaman"));
        System.out.println("hasBad:");
        System.out.println("Badlands = " + hasBad("Badlands"));
        System.out.println("atFirst:");
        System.out.println("Back in black = " + atFirst("Back in black"));
        System.out.println("lastChars:");
        System.out.println("Run to the hills;run for your life = " + lastChars("Run to the hills", "run for your life"));
        System.out.println("atFirst:");
        System.out.println("Hello = " + atFirst("Hello") + "\nHi = " + atFirst("Hi") + "\nh = " + atFirst("h"));
        System.out.println("lastChars:");
        System.out.println("Last;Chars = " + lastChars("Last", "Chars"));
        System.out.println("Java; = " + lastChars("Java", ""));
        System.out.println(";Eyy = " + lastChars("", "Eyy"));
        System.out.println("conCat:");
        System.out.println("My;Future = " + conCat("My", "Future"));
        System.out.println("trompet;toeter = " + conCat("trompet", "toeter"));
        System.out.println("lastTwo:");
        System.out.println("Billie Eilish = " + lastTwo("Billie Eilish"));
        System.out.println("seeColor:");
        System.out.println("Red Hot Chilli Peppers = " + seeColor("Red Hot Chilli Peppers"));
        System.out.println("Blue Oyster Cult = " + seeColor("Blue Oyster Cult"));
        System.out.println("Kansas = " + seeColor("Kansas"));
        System.out.println("frontAgain:");
        System.out.println("Toto = " + frontAgain("Toto"));
        System.out.println("minCat:");
        System.out.println("Frank;Sinatra = " + minCat("Frank", "Sinatra"));
        System.out.println("Diablo;Blvd = " + minCat("Diablo", "Blvd"));
        System.out.println("Joan;Jett = " + minCat("Joan", "Jett"));
        System.out.println("extraFront:");
        System.out.println("AC/DC = " + extraFront("AC/DC"));
        System.out.println("A = " + extraFront("A"));
        System.out.println("'' = " + extraFront(""));
        System.out.println("without2:");
        System.out.println("Royksopp = " + without2("Royksopp"));
        System.out.println("Stankiest = " + without2("Stankiest"));
        System.out.println("deFront:");
        System.out.println("Yo = " + deFront("Yo"));
        System.out.println("Ib = " + deFront("Ib"));
        System.out.println("Abba = " + deFront("Abba"));
        System.out.println("Arc en Ciel = " + deFront("Arc en Ciel"));
        System.out.println("Metallica = " + deFront("Metallica"));
        System.out.println("startWord:");
        System.out.println("hiphop;pih = " + startWord("hiphop", "pih"));
        System.out.println("hippo;hi = " + startWord("hippo", "hi"));
        System.out.println("hippo;xip = " + startWord("hippo", "xip"));
        System.out.println("hippo;i = " + startWord("hippo", "i"));
        System.out.println("withoutX:");
        System.out.println("xSession = " + withoutX("xSession"));
        System.out.println("Project x = " + withoutX("Project x"));
        System.out.println("Nexus = " + withoutX("Nexus"));
        System.out.println("withoutX2:");
        System.out.println("Oxford = " + withoutX2("Oxford"));
        System.out.println("Xenophobia = " + withoutX2("Xenophobia"));
        System.out.println("Hexagon = " + withoutX2("Hexagon"));
    }

    /*
    Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".

    helloName("Bob") → "Hello Bob!"
    helloName("Alice") → "Hello Alice!"
    helloName("X") → "Hello X!"
     */
    public static String helloName(String name) {
        return "Hello " + name + "!";
    }

    /*
    Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".

    makeAbba("Hi", "Bye") → "HiByeByeHi"
    makeAbba("Yo", "Alice") → "YoAliceAliceYo"
    makeAbba("What", "Up") → "WhatUpUpWhat"
    */
    public static String makeAbba(String a, String b) {
        return a + b + b + a;
    }

    /*
    The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example, the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the HTML string with tags around the word, e.g. "<i>Yay</i>".

    makeTags("i", "Yay") → "<i>Yay</i>"
    makeTags("i", "Hello") → "<i>Hello</i>"
    makeTags("cite", "Yay") → "<cite>Yay</cite>"
     */
    public static String makeTags(String tag, String word) {
        return "<" + tag + ">" + word + "</" + tag + ">";
    }

    /*
    Given an "out" string length 4, such as "<<>>", and a word,
    return a new string where the word is in the middle of the out string, e.g. "<<word>>".
    Note: use str.substring(i, j) to extract the String starting at index i and going up to but not including index j.

    makeOutWord("<<>>", "Yay") → "<<Yay>>"
    makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
    makeOutWord("[[]]", "word") → "[[word]]"
     */
    public static String makeOutWord(String out, String word) {
        String firstDelimiter = out.substring(0, (out.length() / 2));
        String lastDelimiter = out.substring(out.length() / 2);
        return firstDelimiter + word + lastDelimiter;
    }

    /*
    Given a string, return a new string made of 3 copies of the last 2 chars of the original string.
    The string length will be at least 2.

    extraEnd("Hello") → "lololo"
    extraEnd("ab") → "ababab"
    extraEnd("Hi") → "HiHiHi"
     */
    public static String extraEnd(String str) {
        String sub = str.substring(str.length() - 2), result = "";

        for (int x= 0; x++ < 3;) {
            result += sub;
        }

        return result;
    }

    /*
    Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string "" yields the empty string "". Note that str.length() returns the length of a string.

    firstTwo("Hello") → "He"
    firstTwo("abcdefg") → "ab"
    firstTwo("ab") → "ab"
     */
    public static String firstTwo(String str) {
        return str.substring(0, 2);
    }

    /*
    Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".

    firstHalf("WooHoo") → "Woo"
    firstHalf("HelloThere") → "Hello"
    firstHalf("abcdef") → "abc"
     */
    public static String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    /*
    Given a string, return a version without the first and last char, so "Hello" yields "ell".
    The string length will be at least 2.

    withoutEnd("Hello") → "ell"
    withoutEnd("java") → "av"
    withoutEnd("coding") → "odin"
     */
    public static String withoutEnd(String str) {
        if (str.length() <= 3) {
            return "Nope!";
        }

        return str.substring(1, str.length() - 1);
    }

    /*
    Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string on the outside and the longer string on the inside. The strings will not be the same length, but they may be empty (length 0).

    comboString("Hello", "hi") → "hiHellohi"
    comboString("hi", "Hello") → "hiHellohi"
    comboString("aaa", "b") → "baaab"
     */
    public static String comboString(String a, String b) {
        if (a.length() < b.length()) {
            return a + b + a;
        }

        return b + a + b;
    }

    /*
    Given 2 strings, return their concatenation, except omit the first char of each. The strings will be at least length 1.

    nonStart("Hello", "There") → "ellohere"
    nonStart("java", "code") → "avaode"
    nonStart("shotl", "java") → "hotlava"
     */
    public static String nonStart(String a, String b) {
        if (a.length() < 3 || b.length() < 3) {
            return "Nope!";
        }

        String aNonStart = a.substring(1, a.length() - 1);
        String bNonStart = b.substring(1, b.length() - 1);

        return aNonStart + bNonStart;
    }

    /*
    Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end. The string length will be at least 2.

    left2("Hello") → "lloHe"
    left2("java") → "vaja"
    left2("Hi") → "Hi"
     */
    public static String left2(String str) {
        if (str.length() < 2) {
            return "Nope!";
        }

        return str.substring(2) + str.substring(0, 2);
    }

    /*
    Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start. The string length will be at least 2.

    right2("Hello") → "loHel"
    right2("java") → "vaja"
    right2("Hi") → "Hi"
     */
    public static String right2(String str) {
        if (str.length() < 3) {
            return "Nope!";
        }

        return str.substring(str.length() - 2) + str.substring(0, str.length() - 2);
    }

    /*
    Given a string, return a string length 1 from its front, unless front is false, in which case return a string length 1 from its back. The string will be non-empty.

    theEnd("Hello", true) → "H"
    theEnd("Hello", false) → "o"
    theEnd("oh", true) → "o"
     */
    public static String theEnd(String str, boolean front) {
        return (front ? str.substring(0, 1) : str.substring((str.length() - 1)));
    }

    /*
    Given a string, return a version without both the first and last char of the string. The string may be any length, including 0.

    withouEnd2("Hello") → "ell"
    withouEnd2("abc") → "b"
    withouEnd2("ab") → ""
     */
    public static String withouEnd2(String str) {
        return (str.length() < 2 ? "" : str.substring(1, str.length() - 1));
    }

    /*
    Given a string of even length, return a string made of the middle two chars, so the string "string" yields "ri". The string length will be at least 2.

    middleTwo("string") → "ri"
    middleTwo("code") → "od"
    middleTwo("Practice") → "ct"
     */
    public static String middleTwo(String str) {
        if (str.length() % 2 != 0) {
            return "Nope!";
        }

        int startHalfway = (str.length() / 2) - 1;
        int endHalfway = (str.length() / 2) + 1;

        return str.substring(startHalfway, endHalfway);
    }

    /*
    Given a string, return true if it ends in "ly".

    endsLy("oddly") → true
    endsLy("y") → false
    endsLy("oddy") → false
     */
    public static boolean endsLy(String str) {
        if (str.length() < 2) {
            return false;
        }

        String last = str.toLowerCase().substring(str.length() - 2);
        return last.equals("ly");
    }

    /*
    Given a string and an int n, return a string made of the first and last n chars from the string.
    The string length will be at least n.

    nTwice("Hello", 2) → "Helo"
    nTwice("Chocolate", 3) → "Choate"
    nTwice("Chocolate", 1) → "Ce"
     */
    public static String nTwice(String str, int n) {
        if (str.length() < (n * 2)) {
            return "Nope!";
        }

        String firstN = str.substring(0, n);
        String lastN = str.substring(str.length() - n);

        return firstN + lastN;
    }

    /*
    Given a string and an index, return a string length 2 starting at the given index. If the index is too big or too small to define a string length 2, use the first 2 chars. The string length will be at least 2.

    twoChar("java", 0) → "ja"
    twoChar("java", 2) → "va"
    twoChar("java", 3) → "ja"
     */
    public static String twoChar(String str, int index) {
        if (str.length() < 2) {
            return "Nope!";
        }

        // Check - is the index at a point where 2 letters can be read? If not, return the first 2
        if (index > str.length() - 2 || index < 0) {
            return str.substring(0, 2);
        }

        return str.substring(index, index + 2);
    }

    /*
    Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and". The string length will be at least 3.

    middleThree("Candy") → "and"
    middleThree("and") → "and"
    middleThree("solving") → "lvi"
     */
    public static String middleThree(String str) {
        // Is a string an odd number of letters and a minimum of 3 long? If not, it's FUBAR
        if (str.length() % 2 == 0 || str.length() < 3) {
            return "Nope!";
        }

        int firstIndex = (str.length() / 2) - 1;
        int secondIndex = (str.length() / 2) + 2;

        return str.substring(firstIndex, secondIndex);
    }

    /*
    Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals() to compare 2 strings.

    hasBad("badxx") → true
    hasBad("xbadxx") → true
    hasBad("xxbadxx") → false
     */
    public static boolean hasBad(String str) {
        boolean result = false;

        if (str.length() > 3) {
            boolean index0IsBad = str.substring(0, 3).equalsIgnoreCase("bad");
            result = index0IsBad;
        }
        else if (str.length() > 4) {
            boolean index1IsBad = str.substring(1, 4).equalsIgnoreCase("bad");
            result = index1IsBad;
        }

        return result;
    }

    /*
    Given a string, return a string length 2 made of its first 2 chars. If the string length is less than 2, use '@' for the missing chars.

    atFirst("hello") → "he"
    atFirst("hi") → "hi"
    atFirst("h") → "h@"
     */
    public static String atFirst(String str) {
        if (str.length() == 0) {
            return "@@";
        }
        else if (str.length() == 1) {
            return str.charAt(0) + "@";
        }

        // imaginary else
        return str.substring(0, 2);

        //return (str.length() == 0 ? "@@" : (str.length() == 1 ? str.charAt(0) + "@" : str.substring(0, 2)));
    }

    /*
    Given 2 strings, a and b, return a new string made of the first char of a and the last char of b, so "yo" and "java" yields "ya". If either string is length 0, use '@' for its missing char.

    lastChars("last", "chars") → "ls"
    lastChars("yo", "java") → "ya"
    lastChars("hi", "") → "h@"
     */
    public static String lastChars(String a, String b) {
        String aRet = (a.length() == 0 ? "@" : Character.toString(a.charAt(0)));
        String bRet = (b.length() == 0 ? "@" : Character.toString(b.charAt(b.length() - 1)));
        return aRet + bRet;
    }

    /*
    Given two strings, append them together (known as "concatenation") and return the result. However,
    if the concatenation creates a double-char, then omit one of the chars, so "abc" and "cat" yields "abcat".

    conCat("abc", "cat") → "abcat"
    conCat("dog", "cat") → "dogcat"
    conCat("abc", "") → "abc"
     */
    public static String conCat(String a, String b) {
        boolean stringsOverlapByOne = a.charAt(a.length() - 1) == b.charAt(0);

        if (stringsOverlapByOne) {
            return a + b.substring(1);
        }

        return a + b;
    }

    /*
    Given a string of any length, return a new string where the last 2 chars, if present, are swapped, so "coding" yields "codign".


    lastTwo("coding") → "codign"
    lastTwo("cat") → "cta"
    lastTwo("ab") → "ba"
     */
    public static String lastTwo(String str) {
        if (str.length() < 2) {
            return "Nope!";
        }

        String strStart = str.substring(0, str.length() - 2);
        String lastLetter = Character.toString(str.charAt(str.length() - 1));
        String penultimateLetter = Character.toString(str.charAt(str.length() - 2));

        return strStart + lastLetter + penultimateLetter;
    }

    /*
    Given a string, if the string begins with "red" or "blue" return that color string,
    otherwise return the empty string.

    seeColor("redxx") → "red"
    seeColor("xxred") → ""
    seeColor("blueTimes") → "blue"
     */
    public static String seeColor(String str) {
        String lower = str.toLowerCase();

        if (lower.startsWith("red")) {
            return "red";
        }
        else if (lower.startsWith("blue")) {
            return "blue";
        }

        return "";
    }

    /*
    Given a string, return true if the first 2 chars in the string also appear at the end of the string, such as with "edited".

    frontAgain("edited") → true
    frontAgain("edit") → false
    frontAgain("ed") → true
     */
    public static boolean frontAgain(String str) {
        String strFrontTwo = str.toLowerCase().substring(0, 2);
        String strLastTwo = str.substring(str.length() - 2);
        return strFrontTwo.equals(strLastTwo);
    }

    /*
    Given two strings, append them together (known as "concatenation") and return the result. However, if the strings are different lengths, omit chars from the longer string so it is the same length as the shorter string. So "Hello" and "Hi" yield "loHi". The strings may be any length.

    minCat("Hello", "Hi") → "loHi"
    minCat("Hello", "java") → "ellojava"
    minCat("java", "Hello") → "javaello"
     */
    public static String minCat(String a, String b) {
        if (a.length() == b.length()) {
            return a + b;
        }
        else if (a.length() > b.length()) {
            String shortenedA = a.substring(a.length() - b.length());
            return shortenedA + b;
        }

        String shortenedB = b.substring(b.length() - a.length());
        return a + shortenedB;
    }

    /*
    Given a string, return a new string made of 3 copies of the first 2 chars of the original string. The string may be any length. If there are fewer than 2 chars, use whatever is there.

    extraFront("Hello") → "HeHeHe"
    extraFront("ab") → "ababab"
    extraFront("H") → "HHH"
     */
    public static String extraFront(String str) {
        String front = "";

        if (str.length() == 1) {
            front = str.substring(0, 1);
        }
        else if (str.length() > 1) {
            front = str.substring(0, 2);
        }

        return front + front + front;
    }

    /*
    Given a string, if a length 2 substring appears at both its beginning and end, return a string without the substring at the beginning, so "HelloHe" yields "lloHe". The substring may overlap with itself, so "Hi" yields "". Otherwise, return the original string unchanged.

    without2("HelloHe") → "lloHe"
    without2("HelloHi") → "HelloHi"
    without2("Hi") → ""
     */
    public static String without2(String str) {
        if (str.length() < 2) {
            return str;
        }

        String strFirstTwo = str.toLowerCase().substring(0,2);
        String strLastTwo = str.toLowerCase().substring(str.length() - 2, str.length());

        if (strFirstTwo.equals(strLastTwo)) {
            return str.substring(2);
        }

        return str;
    }

    /*
    Given a string, return a version without the first 2 chars. Except keep the first char if it is 'a' and keep the second char if it is 'b'. The string may be any length. Harder than it looks.

    deFront("Hello") → "llo"
    deFront("java") → "va"
    deFront("away") → "aay"
     */
    public static String deFront(String str) {
        String result = "";

        if (str.length() < 2) {
            return str;
        }

        if (str.toLowerCase().charAt(0) == 'a') {
            result += Character.toString(str.charAt(0));
        }

        if (str.toLowerCase().charAt(1) == 'b') {
            result += Character.toString(str.charAt(1));
        }

        return result + str.substring(2);
    }

    /*
    Given a string and a second "word" string, we'll say that the word matches
        the string if it appears at the front of the string, except its first char does not need
        to match exactly. On a match, return the front of the string, or otherwise return the
        empty string. So, so with the string "hippo" the word "hi" returns "hi" and "xip" returns
        "hip". The word will be at least length 1.

    startWord("hippo", "hi") → "hi"
    startWord("hippo", "xip") → "hip"
    startWord("hippo", "i") → "h"
     */
    public static String startWord(String str, String word) {
        if ((word.length() < 2 && str.length() < 2) || word.length() > str.length()) {
            return "";
        }

        String wordFromStringAt1 = str.toLowerCase().substring(1, word.length() + 1);

        if (wordFromStringAt1.equals(word.toLowerCase())) {
            // return first after looking at "word" in "str" at position 1
            return Character.toString(str.charAt(0));
        }

        String firstN = str.toLowerCase().substring(0, word.length());
        String lowerWord = word.toLowerCase();
        int mismatches = 0;

        for (int x = 0; x < firstN.length(); x++) {
            if (firstN.charAt(x) != lowerWord.charAt(x)) {
                mismatches++;
            }
        }

        if (mismatches < 2) {
            return str.substring(0, word.length());
        }

        return "";
    }

    /*
    Given a string, if the first or last chars are 'x', return the string without those 'x' chars,
    and otherwise return the string unchanged.

    withoutX("xHix") → "Hi"
    withoutX("xHi") → "Hi"
    withoutX("Hxix") → "Hxi"
     */
    public static String withoutX(String str) {
        int len = str.length() - 1;
        boolean checkFirst = str.toLowerCase().charAt(0) == 'x';
        boolean checkSecond = str.toLowerCase().charAt(len) == 'x';

        if (checkFirst && checkSecond) {
            return str.substring(1);
        }
        else if (checkFirst) {
            return str.substring(1);
        }
        else if (checkSecond) {
            return str.substring(0, len);
        }

        return str;
    }

    /*
    Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x'
    chars, and otherwise return the string unchanged. This is a little harder than it looks.

    withoutX2("xHi") → "Hi"
    withoutX2("Hxi") → "Hi"
    withoutX2("Hi") → "Hi"
     */
    public static String withoutX2(String str) {
        String builder = "";

        if (str.toLowerCase().charAt(0) != 'x') {
            builder += Character.toString(str.charAt(0));
        }

        if (str.toLowerCase().charAt(1) != 'x') {
            builder += Character.toString(str.charAt(1));
        }

        return builder + str.substring(2);
    }
}
