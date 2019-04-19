package Amazon.IntersectionOfTwoArrays;

import java.util.HashSet;

/**
 * Author: bijiaha0
 * Date: 2019-03-09
 * Time: 00:38
 * Email: clickgwas@gmail.com
 * https://www.lintcode.com/problem/intersection-of-two-arrays/solution
 * version 2: hash map
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hash.add(nums1[i]);
        }

        HashSet<Integer> resultHash = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hash.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
                resultHash.add(nums2[i]);
            }
        }

        int size = resultHash.size();
        int[] result = new int[size];
        int index = 0;
        for (Integer num : resultHash) {
            result[index++] = num;
        }

        return result;
    }
}
