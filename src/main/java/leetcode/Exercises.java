package leetcode;

public class Exercises {
    /*
    ======================= END MEDIAN OF INT ARRAYS =======================
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
}
