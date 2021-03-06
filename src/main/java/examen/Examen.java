package examen;

public class Examen {
    public static void main(String[] args) {/*
        System.out.println("makeHalf:");
        System.out.println("3: " + makeHalf(3));
        System.out.println("5: " + makeHalf(5));

        System.out.println("addEuro:");
        System.out.println("5, 7: " + addEuro(5, 7));
        System.out.println("100, 100: " + addEuro(100, 100));

        System.out.println("makeTags:");
        System.out.println("i, Yay: " + makeTags("i", "Yay"));
        System.out.println("i, Hello: " + makeTags("i", "Hello"));
        System.out.println("cite, Yay: " + makeTags("cite", "Yay"));

        System.out.println("correctTag:");
        System.out.println("i, <i>Yay: " + correctTag("i", "<i>Yay"));
        System.out.println("i, <i>Hello</i>: " + correctTag("i", "<i>Hello</i>"));
        System.out.println("cite, Yay: " + correctTag("cite", "Yay"));

        System.out.println("getInner:");
        System.out.println("i, <i>Yay: \"" + getInner("i", "<i>Yay") + "\"");
        System.out.println("i, <i>Hello</i>: \"" + getInner("i", "<i>Hello</i>") + "\"");
        System.out.println("cite, <cite>We say<i>Yay</i>!</cite>: \"" + getInner("cite", "<cite>We say<i>Yay</i>!</cite>") + "\"");

        System.out.println("countTags:");
        System.out.println("p, does a \"p\" tag exists in this text?: " + countTags("p", "does a \"p\" tag exists in this text?"));
        System.out.println("p, <p>does a \"p\" tag exists in this text?</p>: " + countTags("p", "<p>does a \"p\" tag exists in this text?</p>"));
        System.out.println("p: <p>does a \"p\" tag</p><p>exists in this text?</p>" + countTags("p", "<p>does a \"p\" tag</p><p>exists in this text?</p>"));*/

        System.out.println("isBalanced:");
        System.out.println("p, no problem here: " + isBalancedNesting("p","no problem here"));
        System.out.println("p, <p>oepsie: " + isBalancedNesting("p","<p>oepsie"));
        System.out.println("p, <p>ok,</p><p>all good</p>: " + isBalancedNesting("p","<p>ok,</p><p>all good</p>"));
        System.out.println("p, <p>so<p></p>bad</p>: " + isBalancedNesting("p","<p>so<p></p>bad</p>"));/*

        System.out.println("findLargest:");
        System.out.println("{1,1,1,1}: " + findLargest(new int[]{1,1,1,1}));
        System.out.println("{1,3,7,5}: " + findLargest(new int[]{1,3,7,5}));

        System.out.println("makeSum:");
        System.out.println("{1,1,1,1}: " + makeSum(new int[]{1,1,1,1}));
        System.out.println("{1,3,7,5}: " + makeSum(new int[]{1,3,7,5}));

        String[] input = {"zip","zap","zop","zep","zup","zep"};
        System.out.println("indexOf (\"zip\",\"zap\",\"zop\",\"zep\",\"zup\",\"zep\"):");
        System.out.println("zep: " + indexOf(input,"zep"));
        System.out.println("zzepp: " + indexOf(input,"zzepp"));*/
    }

    public static double makeHalf(int a) {
        /*
        This "makeHalf" method seems to have a problem!
        Please Fix It!

        expected:
        makeHalf(3) -> 1.5
        makeHalf(5) -> 2.5
         */

        return (double) a / 2;
    }

    public static String addEuro(int a,int b) {
        /*
        Please Fix this!

        expected:
        addEuro(5,7) - > ??? 12
        addEuro(100,100) - > ??? 200
        */
        return "??? " + (a + b);
    }

    public static String makeTags(String tag, String text) {
        /*
        The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
        the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings,
        create the HTML string with tags around the word, e.g. "<i>Yay</i>".

        makeTags("i", "Yay") ??? "<i>Yay</i>"
        makeTags("i", "Hello") ??? "<i>Hello</i>"
        makeTags("cite", "Yay") ??? "<cite>Yay</cite>"
         */
        return "<" + tag +">" + text + "</" + tag + ">";
    }

    public static String correctTag(String tag, String text) {
        /*
        if text start with a given tag, check if the "closing" tag exist at the end. If not, add it

        correctTags("i", "<i>Yay") ??? "<i>Yay</i>"
        correctTags("i", "<i>Hello</i>") ??? "<i>Hello</i>"
        correctTags("cite", "Yay") ??? "Yay"
         */

        int tagLength = tag.length();
        int textLength = text.length();
        String sStart = "", sEnd = "";

        if (textLength > (tagLength + 2)) {
            sStart = text.substring(0, tagLength + 2);
        }

        if (textLength > (2 * tagLength + 5)) {
            sEnd = text.substring(textLength - (tagLength + 3));
        }

        boolean startsWithTag = sStart.equals("<" + tag + ">");
        boolean endsWithTag = sEnd.equals("</" + tag + ">");

        if (startsWithTag && !endsWithTag) {
            return text + "</" + tag + ">";
        }

        return text;
    }

    public static String getInner(String tag, String text) {
        /*
        if text is encapsulated with the given tag, return the text with the tags removed. Else return an empty string

        getInner("i", "<i>Yay") ??? ""
        getInner("i", "<i>Hello</i>") ??? "Hello"
        getInner("cite", "<cite>We say<i>Yay</i>!</cite>") ??? "We say<i>Yay</i>!"
         */
        int iFirstTag = text.indexOf("<" + tag + ">");

        if (iFirstTag >= 0) {
            int iSecondTag = text.indexOf("</" + tag + ">", (iFirstTag + 1));

            if (iSecondTag > 0) {
                return text.substring(iFirstTag + (2 + tag.length()), iSecondTag);
            }
        }

        return "";
    }

    public static int countTags(String tag, String text) {
        /*
        Return how many times a given (opening) tag appears in text

        CountTag("p", "does a "p" tag exists in this text?") -> 0;
        CountTag("p", "<p>does a "p" tag exists in this text?</p>") -> 1;
        CountTag("p", "<p>does a "p" tag</p><p>exists in this text?</p>") -> 2;
         */

        int iTag = -2;
        int counter = 0;

        while (iTag != -1) {
            if (iTag == -2) {
                iTag = text.indexOf("<" + tag + ">");
            }
            else {
                iTag = text.indexOf("<" + tag + ">", (iTag + 1));
            }

            if (iTag >= 0) {
                counter++;
            }
        }

        return counter;
    }

    public static boolean isBalanced(String tag, String text) {
        /*
        this is a harder problem :) Maybe keep it to the end.
        When an opening tag occurs, it needs to be properly closed with a corresponding closing tag before a
        new opening tag may occur. Check if the given text follows this rule.

        isBalanced("p","no problem here") -> true;
        isBalanced("p","<p>oepsie") -> false;
        isBalanced("p","<p>ok,</p><p>all good</p>") -> true;
        isBalanced("p","<p>so<p></p>bad</p>") -> false;
         */
        int iOpenTag = -1;

        while (true) {
            iOpenTag = text.indexOf("<" + tag + ">", (iOpenTag + 1));

            if (iOpenTag < 0) {
                return true;
            }

            int iSecondOpenTag = text.indexOf("<" + tag + ">", iOpenTag + 1);
            int iCloseTag = text.indexOf("</" + tag + ">", (iOpenTag + 1));

            if (iCloseTag < 0 || (iSecondOpenTag < iCloseTag && iSecondOpenTag >= 0)) {
                return false;
            }

            iOpenTag = iCloseTag + 1;
        }
    }

    public static boolean isBalancedAlt(String tag, String text) {
        String open = "<" + tag + ">";
        String close = "</" + tag + ">";
        int lenOpen = open.length();
        int lenClose = close.length();
        int lenText = text.length();
        int counter = 0;
        int idxOpen = text.indexOf(open);
        int idxClose = text.indexOf(close);

        if (idxOpen > idxClose) {
            return false;
        }
        else if (idxOpen < 0 && idxClose < 0) {
            return true;
        }
        else if ((idxOpen < 0 | idxClose < 0) && (idxOpen != idxClose)) {
            return false;
        }

        for (int x = 0; x < lenText; x++) {
            idxOpen = text.indexOf(open, x);

            if (text.indexOf(open, x) >= 0) {
                if (++counter > 1) return false;
                x = lenOpen + idxOpen - 1;
            }

            idxClose = text.indexOf(close, x);

            if (text.indexOf(close, x) >= 0) {
                if (--counter < 0) return false;
                x = lenClose + idxClose - 1;
            }
        }

        return counter == 0;
    }

    public static boolean isBalancedNesting(String tag, String text) {
        String open = "<" + tag + ">";
        String close = "</" + tag + ">";
        int lenOpen = open.length();
        int lenClose = close.length();
        int lenText = text.length();
        int counter = 0;
        int idxOpen = text.indexOf(open);
        int idxClose = text.indexOf(close);

        if (idxOpen > idxClose) {
            return false;
        }
        else if (idxOpen < 0 && idxClose < 0) {
            return true;
        }
        else if ((idxOpen < 0 | idxClose < 0) && (idxOpen != idxClose)) {
            return false;
        }

        for (int x = 0; x < lenText; x++) {
            idxOpen = text.indexOf(open, x);
            idxClose = text.indexOf(close, x);

            if (idxOpen >= 0 && idxOpen < idxClose) {
                counter++;
                x = lenOpen + idxOpen - 1;
            }

            if (idxClose >= 0 && idxOpen > idxClose) {
                counter--;
                x = lenClose + idxClose - 1;
            }

            if (idxOpen < 0 && idxClose < 0) {
                break;
            }
        }

        return counter == 0;
    }

    public static int findLargest(int[] array) {
        /*
        given an array of integers, return the largest integer in the array
        findLargest(int[]{1,1,1,1}) -> 1
        findLargest(int[]{1,3,7,5}) -> 7
         */

        int largest = 0;

        if (array.length > 0) {
            largest = array[0];
        }

        for (int x = 1; x < array.length; x++) {
            if (array[x] > largest) {
                largest = array[x];
            }
        }

        return largest;
    }

    public static int makeSum(int[] array) {
        /*
        given an array of integers, return the sum of all integers
        makeSum(int[]{1,1,1,1}) -> 4
        makeSum(int[]{1,3,7,5}) -> 16
         */
        int sum = 0;

        for (int n : array) {
            sum += n;
        }

        return sum;
    }

    public static int indexOf(String[] array, String word) {
        /*
        Given an array of String, return the index of the first occurence of word in the array.
        If an occurence is not found, return -1
        The array will NOT contain null values

        String[] input = {"zip","zap","zop","zep","zup","zep"}
        indexOf(input,"zep") -> 3;
        indexOf(input,"zzepp") -> -1;
         */
        for (int x = 0; x < array.length; x++) {
            if (array[x] != null && array[x].equals(word)) {
                return x;
            }
        }

        return -1;
    }
}