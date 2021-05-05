package chapter06.e;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(isDoubloon("Abba"));
        System.out.println(isDoubloon("Anna"));
        System.out.println(isDoubloon("deed"));
        System.out.println(isDoubloon("horse-shoer"));
        System.out.println(isDoubloon("Intestines"));
        System.out.println(isDoubloon("murmur"));
        System.out.println(isDoubloon("Nope"));
        System.out.println(isDoubloon("Not a doubloon"));
        System.out.println(isDoubloon("noon"));
        System.out.println(isDoubloon("Poop"));
        System.out.println(isDoubloon("Soup"));
    }

    public static boolean isDoubloon(String s) {
        int[] counts = new int[26];
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;

                if (counts[c - 'a'] > 2) {
                    return false;
                }
            }
        }

        for (int count : counts) {
            if (count == 1) {
                return false;
            }
        }

        return true;
    }
}
