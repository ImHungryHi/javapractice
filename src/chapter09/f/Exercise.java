package chapter09.f;

public class Exercise {
    public static void main(String[] args) {
        String s = "((3 + 7) * 2)";
        System.out.println(countParen(s));
        s = "(Yep";
        System.out.println(countParen(s));
        s = "200 * (1 + (1 / 32))";
        System.out.println(countParen(s));
        s = "Just some random stuff";
        System.out.println(countParen(s));
    }

    public static int countParen(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                count--;
            }
        }

        return count;
    }
}




