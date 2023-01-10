/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 *     0 <= nums.length <= 10^5
 *     -10^9 <= nums[i] <= 10^9
 *     nums is a non-decreasing array.
 *     -10^9 <= target <= 10^9
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int min = findTarget(nums, target, "min");
        if (min == -1) {
            return new int[] {-1, -1};
        }
        int max = findTarget(nums, target, "max");
        return new int[] {min, max};
    }

    private static int findTarget(int[] nums, int target, String position) {
        int left = 0;
        int right = nums.length - 1;
        int temp = -1;
        while (left <= right) {
            int i = (left + right) / 2;
            if (nums[i] == target) {
                temp = i;
                if (position == "min") {
                    right = i - 1;
                } else {
                    left = i + 1;
                }
                continue;
            }
            if (nums[i] > target) {
                right = i - 1;
                continue;
            }
            left = i + 1;
        }
        return temp;
    }
}
