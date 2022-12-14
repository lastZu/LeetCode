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
        int[] colorsCount = new int[3];

        for (int i = 0; i < nums.length; i++) {
            colorsCount[nums[i]]++;
        }
        int position = 0;
        for (int i = 0; i < colorsCount.length; i++) {
            setColor(nums, position, colorsCount[i], i);
            position += colorsCount[i];
        }
    }

    private static void setColor(int[] nums, int startPosition, int count, int color) {
        for (int i = 0; i < count; i++) {
            nums[startPosition + i] = color;
        }
    }
}
