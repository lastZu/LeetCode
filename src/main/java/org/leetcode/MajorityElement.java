package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     1 <= n <= 5 * 10^4
 *     -10^9 <= nums[i] <= 10^9
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        int answer = nums[0];
        for (int i = 0; i < nums.length; i++) {
            Integer count = counter.getOrDefault(nums[i], 0);
            if (count >= nums.length / 2) {
                answer = nums[i];
                break;
            }
            counter.put(nums[i], count + 1);
        }
        return answer;
    }

    public int majorityElement2(int[] nums) {
        int answer = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) answer = nums[i];
            count += answer == nums[i] ? 1 : -1;
        }
        return answer;
    }
}
