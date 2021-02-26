package code;

public class Checks {
    public static boolean isNumeric(String s) {
        try {
            int num = Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }
}
