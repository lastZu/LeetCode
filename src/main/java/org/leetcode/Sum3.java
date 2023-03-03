package org.leetcode;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 *     3 <= nums.length <= 3000
 *     -10^5 <= nums[i] <= 10^5
 */
public class Sum3 { // -4, -1, -1, 0, 1, 2
    public static List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> answer = new ArrayList<>();
       int temp = nums[0];
       for (int i = 0; i < nums.length - 1; i++) {
           if (i != 0 && temp == nums[i]) continue;
           temp = nums[i];
           var answerForTarget= twoSum(
                   Arrays.copyOfRange(nums, i + 1, nums.length),
                   -nums[i]);
           answer.addAll(answerForTarget);
       }
       return answer;
    }

    private static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> num3 = new ArrayList<>();
        int first = 0;
        int last = nums.length - 1;
        while (first < last) {
            if (nums[first] + nums[last] > target) {
                last--;
                continue;
            }
            if (nums[first] + nums[last] < target) {
                first++;
                continue;
            }
            num3.add(List.of(-target, nums[first], nums[last]));
            int temp = nums[first];
            while (first < last && temp == nums[first]) {
                first++;
            }
            temp = nums[last];
            while (first < last && temp == nums[last]) {
                last--;
            }
        }
        return num3;
    }
}
