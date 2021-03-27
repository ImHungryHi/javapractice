package chapter06.d;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(isAbecedarian("AbCdE"));
        System.out.println(isAbecedarian("Chris"));
        System.out.println(isAbecedarian("Chirs"));
        System.out.println(isAbecedarian("Chips"));
        System.out.println(isAbecedarian("Crisps"));
    }

    public static boolean isAbecedarian(String s) {
        s = s.toLowerCase();
        int i = 0;
        char lastChar = s.charAt(0);

        while (lastChar < 'a' || lastChar > 'z') {
            lastChar = s.charAt(++i);
        }

        for (int x = 1; x < s.length(); x++) {
            char c = s.charAt(x);
            if (c >= 'a' && c <= 'z') {
                if (c < lastChar) {
                    return false;
                }

                lastChar = c;
            }
        }

        return true;
    }
}
