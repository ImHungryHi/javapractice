package chapter07.g;

public class Exercise {
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
