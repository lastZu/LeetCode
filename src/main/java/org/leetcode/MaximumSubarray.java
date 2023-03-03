package org.leetcode;

/**
 * Given an integer array nums,
 * find the subarray which has the largest sum and return its sum.
 *
 * Example 1:
 *
 * Input: nums = [-2,-1,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 */

public class MaximumSubarray {
        public static int maxSubArray(int[] nums) {
            int sum = nums[0];
            int tempSum = sum;
            for (int i = 1; i < nums.length; i++) {
                if (tempSum < 0) {
                    tempSum = 0;
                }
                tempSum += nums[i];

                if (tempSum > sum) {
                    sum = tempSum;
                }
            }
            return sum;
        }
}
