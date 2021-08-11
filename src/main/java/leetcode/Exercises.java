package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Exercises {
    public int[] twoSumV1(int[] nums, int target) {
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                if ((nums[x] + nums[y]) == target) {
                    return new int[] {x, y};
                }
            }
        }

        return new int[0];
    }

    public int[] twoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x = 0; x < nums.length; x++) {
            int targetClause = target - x;

            if (map.containsKey(targetClause)) {
                return new int[] { map.get(targetClause), x};
            }

            if (!map.containsKey(nums[x])) {
                map.put(nums[x], x);
            }
        }

        return new int[0];
    }

    public int[] twoSumV3(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int x = 0; x < nums.length; x++) {
            int targetClause = target - x;

            if (map.containsKey(targetClause)) {
                return new int[] { map.get(targetClause).get(0), x};
            }

            if (map.containsKey(nums[x])) {
                map.get(nums[x]).add(x);
            }
            else {
                map.put(nums[x], Arrays.asList(x));
            }
        }

        return new int[0];
    }

    /*
    ======================= START MEDIAN OF INT ARRAYS =======================
        -> median of odd elements = middle element after sort
        -> median of even elements = mean of 2 middle elements after sort
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = sortMerge(nums1, nums2);
        int halfway = merged.length / 2;

        if (merged.length % 2 == 0) {
            return (double)(merged[halfway] + merged[--halfway]) / 2;
        }

        return merged[halfway];
    }

    public static int[] sortMerge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int idx = 0;
        int minOfArrs;

        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length || (j < nums2.length && nums1[i] > nums2[j])) {
                minOfArrs = nums2[j++];
            }
            else {
                minOfArrs = nums1[i++];
            }

            if (idx > 0 && merged[idx - 1] > minOfArrs) {
                int tempIdx = idx++;

                while (tempIdx > 0 && merged[tempIdx - 1] > minOfArrs) {
                    merged[tempIdx] = merged[--tempIdx];
                }

                merged[tempIdx] = minOfArrs;
            }
            else {
                merged[idx++] = minOfArrs;
            }
        }

        return merged;
    }
    /* ======================= END MEDIAN OF INT ARRAYS ======================= */

    /*
    ======================= START REGEX =======================
        -> '.' regexes to any character in the matching position of a string
        -> '*' regexes to 0 or more of the previous character at the matching position in a string
        -> '.*' regexes to 0 or more of any character at the matching position in a string
     */

    /*
    a.*a    a.*     .*a
    a*a     a*      *a
    a.a     a.      .a
    a*.a    a*.     *.a
    aa      a
     */
    public static boolean workingMethod(String s, String p) {
        if (p.length() == 0 || s.length() == 0) {
            return false;
        }
        else if (!p.contains("*") && !p.contains(".")) {
            return s.equals(p);
        }

        int nextSpecial = 0;
        StringBuilder builder = new StringBuilder();

        while(true) {
            int idxStar = p.indexOf("*");
            int idxPoint = p.indexOf(".");

            if (idxStar > idxPoint && idxPoint >= 0) {
                nextSpecial = idxPoint;

                if (idxPoint == (idxStar - 1)) {
                    //
                }
            }
            else if (idxStar >= 0) {
                nextSpecial = idxStar;

                if (idxStar == (idxPoint - 1)) {
                    //
                }
            }
            else {
                builder.append(p.substring(nextSpecial));
                break;
            }
        }

        return true;
    }
    /*public static boolean isMatch(String s, String p) {
        if (s.length() > 20 || p.length() > 30) {
            return false;
        }

        if (!p.contains("*") && !p.contains(".")) {
            return s.equals(p);
        }

        char[] pArr = p.toCharArray();
        char carryOver = '*';   // Default is one of the characters we won't be seeing in the result
        StringBuilder builder = new StringBuilder();

        for (int x = 0; x < pArr.length; x++) {
            if (pArr[x] == '.') {
                if (builder.length() > 0) {
                    carryOver = s.charAt(builder.length());   // length = next letter
                }
                else {
                    carryOver = s.charAt(x);
                }

                if ((x + 1) >= pArr.length || pArr[x + 1] != '*') {
                    builder.append(carryOver);
                    carryOver = '*';

                    if (!s.substring(0, builder.length()).equals(builder.toString())) {
                        return false;
                    }
                } // Else: not mandatory to add in case of * - because "0 or more"
            }
            else if (pArr[x] == '*') {
                int start = builder.length();

                if (pArr[x - 1] != '.') {
                    carryOver = pArr[x - 1];
                } // Else: carryOver already filled in
                else if (pArr[x - 1] == '.' && pArr.length == (x + 1)) {
                    // If we encounter a ".*" combination at the end of a regex, we've don't need to check anything beyond this.
                    return s.indexOf(builder.toString()) == 0;
                }

                while (start < s.length() && s.charAt(start++) == carryOver) {
                    builder.append(carryOver);
                }

                carryOver = '*';

                if (!s.substring(0, builder.length()).equals(builder.toString())) {
                    return false;
                }
            }
            else if (((x + 1) < pArr.length && pArr[x + 1] != '*') || ((x + 1) >= pArr.length && pArr[x] != '*')) {
                builder.append(pArr[x]);
            }
        }

        // there's a length difference for repeating characters eg aaa [a*a] > aaaa

        return s.equals(builder.toString());
    }*/
    public static boolean isMatch(String s, String p) {
        StringBuilder builder = new StringBuilder();
        String[] pAsteriskDelimited = p.split("\\*");
        String[] pPointDelimited = pAsteriskDelimited[0].split("\\.");
        String pointReformed = reformPointReplacement(pPointDelimited, s, 0);

        if ((pAsteriskDelimited[0].charAt(pAsteriskDelimited[0].length() - 1) != '.') && (pointReformed.length() > 1)) {
            String lesserReformed = pointReformed.substring(0, pointReformed.length() - 1);

            if (!s.startsWith(lesserReformed)) {
                return false;
            }

            builder.append(pointReformed);
        }

        for (int x = 1; x < pAsteriskDelimited.length; x++) {
            pPointDelimited = pAsteriskDelimited[x].split("\\.");
            pointReformed = reformPointReplacement(pPointDelimited, s, builder.length());
            int idxPointReformed = s.indexOf(pointReformed, Math.max(0, builder.length()));

            if (s.startsWith(builder.toString()) && idxPointReformed >= builder.length()) {
                String subCheck = s.substring(builder.length(), idxPointReformed);
                char previousChar = pAsteriskDelimited[x - 1].charAt(pAsteriskDelimited[x - 1].length() - 1);

                if (previousChar != '.') {
                    if (subCheck.length() > 0) {
                        for (char c : subCheck.toCharArray()) {
                            if (c != previousChar) {
                                return false;
                            } else {
                                builder.append(previousChar);
                            }
                        }
                    }
                    else {
                        for (int y = idxPointReformed; s.charAt(y) == previousChar && ++y < s.length() && s.charAt(y) == previousChar;) {
                            builder.append(previousChar);
                        }
                    }
                }

                builder.append(pointReformed);
            }
            else if (pointReformed.equals(builder.toString())) {
                char previousChar = pointReformed.charAt(pointReformed.length() - 1);

                for (int y = idxPointReformed; s.charAt(y) == previousChar && ++y < s.length() && s.charAt(y) == previousChar;) {
                    builder.append(previousChar);
                }
            }
            else {
                return false;
            }
        }

        if (p.endsWith(".*")) {
            return s.indexOf(builder.toString()) == 0;
        }
        else if (p.endsWith("*")) {
            char lastChar = pointReformed.charAt(pointReformed.length() - 1);
            String subCheck = s.substring(builder.length());

            for (char c : subCheck.toCharArray()) {
                if (c != lastChar) {
                    return false;
                }
                else {
                    builder.append(lastChar);
                }
            }
        }
        else if (p.endsWith("*.")) {
            char lastChar = builder.charAt(builder.length() - 1);

            for (int y = builder.length() - 1; s.charAt(y) == lastChar && ++y < s.length() && s.charAt(y) == lastChar;) {
                builder.append(lastChar);
            }

            return s.substring(0, s.length() - 1).equals(builder.toString());
        }

        return s.equals(builder.toString());
    }

    private static String reformPointReplacement(String[] pPointDelimited, String s, int idxFrom) {
        StringBuilder builder = new StringBuilder();

        if (pPointDelimited.length == 1) {
            builder.append(pPointDelimited[0]);
        }
        else {
            for (int x = 0; x < pPointDelimited.length; x++) {
                if (x > 0 && !pPointDelimited[x].equals("") && !pPointDelimited[x - 1].equals("")) {
                    int idxSecond = s.indexOf(pPointDelimited[x], idxFrom);
                    char previousCharacter = s.charAt(idxSecond - 1);
                    String composition = builder.toString() + previousCharacter + pPointDelimited[x];

                    if (s.indexOf(composition) != 0) {
                        // Return empty string in protest
                        return "";
                    }
                    else {
                        builder.append(previousCharacter);
                    }
                }

                builder.append(pPointDelimited[x]);
            }
        }

        return builder.toString();
    }
    /* ======================= END REGEX ======================= */
}
