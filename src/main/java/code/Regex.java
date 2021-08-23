package code;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Order of studies from Codecademy's regex course
//  Rules of engagement for Codecademy's exercises is "match" must be green checked + "don't match" must be red
//   Also incrementally add the received strings onto the given url
//    (if "on" is at the end and "your" is received then "onyour" shoud be given)
//  ? -> 0 or 1 of the previous character must be found (0-1)
//  . -> any character can be in this place (1!)
//  * -> repeat previous character, any number of times (0-n)
//  + -> repeat previous character 1 or more times (1-n)
//  {n} -> match previous character exactly n times (n)
//  {x,} -> match previous character x or more times (x-m)
//  {x, y} -> match previous character between x and y times - both inclusive (x-y)
//  {,y} -> match previous character up to y times times (y)
//  ^ -> this hat at the beginning of a regex means the text that follows is the start of the string
//  $ -> this dollar sign at the end of a regex means the text that preceeded is the end of the string
public class Regex {
    public static enum ShortHand {
        WORD("\\w"),        // Word characters = [A-Za-z0-9_]
        NON_WORD("\\W"),    // Non-word characters = [^A-Za-z0-9_]
        DIGIT("\\d"),       // Digit characters = [0-9]
        NON_DIGIT("\\D"),   // Non-digit characters = [^0-9]
        WHITESPACE("\\s"),  // Whitespace characters = [ \t\r\n\f\v] (meaning space, tab, carriage return, line break, form feed or vertical tab
        NON_WHITESPACE("\\S");// Non-whitespace characters = [^ \t\r\n\f\v]

        String value;

        ShortHand(String value) {
            this.value = value;
        }

        String getValue() {
            return value;
        }
    }

    public static boolean matchLiteral(String needle, String haystack) {
        Pattern pattern = Pattern.compile(needle);      // Create a regex
        Matcher matcher = pattern.matcher(haystack);    // Create a matcher from a string
        return matcher.find();                          // "Find" the regex pattern within a string (matcher)
    }

    // Codecademy could improve since ".*" (match anything;any length) is also accepted instead of "cat|dog"
    public static boolean matchLiteralDuo(String needleOne, String needleTwo, String haystack) {
        Pattern pattern = Pattern.compile(needleOne + "|" + needleTwo); // Given
        Matcher matcher = pattern.matcher(haystack);                    // When
        return matcher.find();                                          // Then (Snap snap, grin grin, wink wink, nudge nudge, say no more? - Monty Python, if you catch my sneeze)
    }

    public static boolean matchLiteralWithCharacterPrefix(String needle, char[] allowed, char[] forbidden, String haystack) {
        /*StringBuilder sAllowed = new StringBuilder(allowed[0]),
                sForbidden = new StringBuilder(forbidden[0]);

        for (int x = 1; x < allowed.length; x++) {
            sAllowed.append(", " + allowed[x]);
        }

        for (int x = 1; x < forbidden.length; x++) {
            sForbidden.append(", " + forbidden[x]);
        }*/

        StringBuilder sAllowed = new StringBuilder(),
                sForbidden = new StringBuilder();

        for (char elAllowed : allowed) {
            sAllowed.append(elAllowed);
        }

        for (char elForbidden : forbidden) {
            sForbidden.append(elForbidden);
        }

        Pattern pattern = Pattern.compile("[" + sAllowed + "]");
        Matcher matcher = pattern.matcher(haystack);

        Pattern negativePattern = Pattern.compile("[^" + sForbidden + "]");
        Matcher negativeMatcher = negativePattern.matcher(haystack);

        // You COULD use either matcher and/or negativeMatcher, but using both would be pointless
        //  ie: using [chr]at will allow cat|hat|rat & forbid eat|mat|sat (or any other) automatically, just the same
        //      as using [^ems]at forbids eat|mat|sat and allows cat|hat|rat (or any other)
        return matcher.find();  // disables edge cases like bat|tat|fat|...
        //return negativeMatcher.find();    // enables edge cases like bat|tat|fat|... to match as a positive result
        //return matcher.find() && negativeMatcher.find();
    }

    public static boolean matchLengthedWildcard(int prefixLength, String needle, String haystack) {
        // Ways to wildcard:
        //  Fixed length -> ....\. (4 characters followed by decimal point eg "lion.")
        //  Another fixed length -> .{6}\. (6 characters followed by decimal point)
        //  Dynamic length -> .*\. (n characters followed by decimal point)

        StringBuilder sPrefix = new StringBuilder();

        for (int x = 0; x < prefixLength; x++) {
            sPrefix.append(".");
        }

        // Needle can contain quantifiers and or wildcards that need escaping
        needle = needle
                .replace(".", "\\.")
                .replace("*", "\\*")
                .replace("?", "\\?")
                .replace("+", "\\+");

        Pattern pattern = Pattern.compile(sPrefix.toString() + needle);
        Matcher matcher = pattern.matcher(haystack);
        return matcher.find();
    }

    public static boolean matchRange(String haystack) {
        String firstLetter = "[c-e]";       // First letter can be c, d and e
        String secondLetter = "[l|o|u]";    // Second letter can be l, o and u
        String thirdLetter = "[b|g|k]";     // Third letter can be b, g and k
        // Giving us that we can match "clb", "clg", "clk", "cob", "cog", "cok", "cub", "cug", "cuk",
        //  "dlb", "dlg", "dlk", "dob", "dog", "dok", "dub", "dug", "duk",
        //  "elb", "elg", "elk", "eob","eog", "eok", "eub", "eug" and "euk"

        Pattern pattern = Pattern.compile(firstLetter + secondLetter + thirdLetter);
        Matcher matcher = pattern.matcher(haystack);
        return matcher.find();
    }

    public static boolean isDigitFollowedBySpaceAndSixWordCharacters(String haystack) {
        Pattern pattern = Pattern.compile("\\d\\s\\w{6}");
        Matcher matcher = pattern.matcher(haystack);
        return matcher.find();
    }

    public static boolean matchShorthand(String shorthandPattern, String haystack) {
        // Escape-ception, for a regex to accept a backslash, it needs a backslash. To provide a backslash character,
        //  it also requires a backslash as an escape, which gives us a necessary 4 backslashes to split a backslash.
        //  Sigh...
        String[] arrShorthand = shorthandPattern.split("\\\\");
        StringBuilder patternBuilder = new StringBuilder();

        for (String elShorthand : arrShorthand) {
            for (ShortHand el : ShortHand.values()) {
                if (el.getValue().contains(elShorthand)) {
                    patternBuilder.append(el);
                }
            }
        }

        Pattern pattern = Pattern.compile(patternBuilder.toString());
        Matcher matcher = pattern.matcher(haystack);
        return matcher.find();
    }

    // Full word (grouping) matching needs rounded parentheses () instead of square brackets [] (which are needed by single characters)
    public static boolean matchGrouping(String[] needles, String haystack) {
        if (needles.length < 1) {
            return false;
        }

        StringBuilder sNeedles = new StringBuilder(needles[0]);

        for (int x = 1; x < needles.length; x++) {
            sNeedles.append("|" + needles[x]);
        }

        // If needles = { "baboons", "gorillas" }, then pattern will be "(baboons|gorillas) are my favourite!"

        Pattern pattern = Pattern.compile(sNeedles.toString() + " are my favourite!");
        Matcher matcher = pattern.matcher(haystack);
        return matcher.find();
    }

    public static boolean review(String haystack) {
        // Matches an optional single digit, followed by a space or opening parenthesis,
        //  then followed by 3 digits and optionally either a closing parenthesis or space or decimal or dash,
        //  followed by 3 fives, an optional dash or space or decimal and finally a set of 4 digits.
        //  No heading or trailing characters of any kind - this is supposed to be the entire string.
        Pattern pattern = Pattern.compile("^\\d?[\\(| ]?\\d{3}[\\)| |.|-]?5{3}[-| |.]?\\d{4}$");

        // Matching example formats are:
        //  718-555-3810
        //  9175552849
        //  1 212 555 3821
        //  (917)5551298
        //  212.555.8731
        Matcher matcher = pattern.matcher(haystack);
        return matcher.find();
    }
}
