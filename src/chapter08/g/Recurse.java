package chapter08.g;

public class Recurse {
    public static void main(String[] args) {
        String s = "Jabberwocky";

        System.out.println("J = " + first(s));
        System.out.println("abberwocky = " + rest(s));
        System.out.println("abberwock = " + middle(s));
        System.out.println("11 = " + length(s));
        printString(s);
        printBackward(s);
        System.out.println("ykcowrebbaJ = " + reverseString(s));
        System.out.println("Soup is no palindrome: soup = " + isPalindrome("soup"));
        System.out.println("Sirup is no palindrome either: sirup = " + isPalindrome("sirup"));
        System.out.println("Otto is a palindrome: otto = " + isPalindrome("otto"));
        System.out.println("Palindromemordnilap is also a palindrome: palindromemordnilap = " + isPalindrome("palindromemordnilap"));
    }

    public static char first(String s) {
        return s.charAt(0);
    }

    public static char last(String s) {
        return s.charAt(length(s) - 1);
    }

    public static String rest(String s) {
        return s.substring(1);
    }

    public static String middle(String s) {
        return s.substring(1, s.length() - 1);
    }

    public static int length(String s) {
        return s.length();
    }

    public static void printString(String s) {
        if (length(s) > 0) {
            System.out.println(first(s));
            printString(rest(s));
        }
    }

    public static void printBackward(String s) {
        if (length(s) > 0) {
            printBackward(rest(s));
            System.out.println(first(s));
        }
    }

    public static String reverseString(String s) {
        if (length(s) > 0) {
            return reverseString(rest(s)) + first(s);
        }

        return "";
    }

    public static boolean isPalindrome(String s) {
        if (length(s) < 2) {
            return true;
        }
        else if (first(s) != last(s)) {
            return false;
        }
        else {
            return isPalindrome(middle(s));
        }
    }
}
