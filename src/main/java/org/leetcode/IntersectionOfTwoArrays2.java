package org.leetcode;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums1.length, nums2.length <= 1000
 *     0 <= nums1[i], nums2[i] <= 1000
 *
 *
 *
 * Follow up:
 *
 *     What if the given array is already sorted? How would you optimize your algorithm?
 *     What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *     What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

public class IntersectionOfTwoArrays2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> from1 = new HashMap<>();
        for (Integer num : nums1) {
            Integer count = from1.get(num);
            if (count == null) {
                count = 0;
            }
            from1.put(num, count + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer num : nums2) {
            Integer count = from1.get(num);
            if (count != null && count > 0) {
                result.add(num);
                from1.put(num, count - 1);
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }
}
