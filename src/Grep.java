import code.IO;
import java.util.ArrayList;
import static code.IO.grep;
import code.IO.GrepInfo.*;

public class Grep {
    public static void main(String[] args) {
        if (args.length > 1) {
            try {
                ArrayList<IO.GrepInfo> matches = grep(args[0], args[1]);
                int totalSize = matches.size(),
                    maxLines = 0,
                    maxCols = 0;

                if (totalSize > 0) {
                    for (IO.GrepInfo match : matches) {
                        if (match.colId > maxCols) {
                            maxCols = match.colId;
                        }
                        if (match.lineId > maxLines) {
                            maxLines = match.lineId;
                        }
                    }

                    System.out.println("Matches for \"" + args[1] + "\" in \"" + args[0] + "\"");
                    System.out.println("===============================================");

                    for (int x = 0; x < totalSize; x++) {
                        IO.GrepInfo match = matches.get(x);
                        System.out.println(zeroFillNumber(x + 1, totalSize) + " | [line " +
                                zeroFillNumber(match.lineId, maxLines) + " col " +
                                zeroFillNumber(match.colId, maxCols) + "] " + match.lineText);
                    }
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static String zeroFillNumber(int n, int total) {
        int diff = Integer.toString(total).length() - Integer.toString(n).length();
        StringBuilder fill = new StringBuilder();

        for (int x = 0; x < diff; x++) {
            fill.append('0');
        }

        fill.append(n);
        return fill.toString();
    }
}
