package code;

import java.text.SimpleDateFormat;
import java.util.*;

public class Dates {
    // Days passed since start of year is odd?
    public static boolean isDateOdd(String date) {
        long diff = 0;

        try {
            SimpleDateFormat df = new SimpleDateFormat("MMMM d yyyy");
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
            Date dDate = df.parse(date);
            diff = dDate.getTime() - df.parse("JAN 1 " + yearFormat.format(dDate)).getTime();
            diff /= (1000*60*60*24);
            diff--;

            if (diff % 2 != 0)
                return true;
        }
        catch (Exception ex) {
            // Nope, Chuck Testa
        }

        return false;
    }

    public static String toMetricString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd  mm yyyy");
        return df.format(date);
    }

    public static Date toDate(String s) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd  mm yyyy");
            return df.parse(s);
        }
        catch (Exception ex) {
            // Nope
        }

        return null;
    }
}
