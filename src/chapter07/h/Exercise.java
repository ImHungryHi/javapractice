package chapter07.h;

public class Exercise {
    public static boolean isAnagram(String a, String b) {
        int[] aCount = letterHist(a);
        int[] bCount = letterHist(b);

        for (int x = 0; x < 26; x++) {
            if (aCount[x] != bCount[x]) {
                return false;
            }
        }

        return true;
    }

    public static int[] letterHist(String s) {
        s = s.toLowerCase();
        int[] hist = new int[26];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                hist[c - 'a']++;
            }
        }

        return hist;
    }
}
