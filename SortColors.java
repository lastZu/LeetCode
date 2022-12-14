/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     1 <= n <= 300
 *     nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors { // 1 0 2 2 0 1
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;

        int left = 0;
        int right = left + 1;
        while (right < nums.length) {
            if (nums[left] > nums[right]) {
                changePlace(nums, left, right);
                left++;
                right = left;
            }
            right++;
        }
    }

    private static void changePlace(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
