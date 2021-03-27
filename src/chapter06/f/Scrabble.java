package chapter06.f;

import java.util.Locale;

public class Scrabble {
    public static void main(String[] args) {
        System.out.println(canSpell("cainabel", "able"));
        System.out.println(canSpell("muppet", "dunk"));
        System.out.println(canSpell("golden", "log"));
        System.out.println(canSpell("golden", "pew"));
        System.out.println(canSpell("goldenpoop", "pollen"));
    }

    public static boolean canSpell(String pile, String s) {
        int[] pileCounts = getCounts(pile);
        int[] sCounts = getCounts(s);

        for (int x = 0; x < 26; x++) {
            if (sCounts[x] > pileCounts[x]) {
                return false;
            }
        }

        return true;
    }

    public static int[] getCounts(String s) {
        int[] counts = new int[26];
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
            }
        }

        return counts;
    }
}
