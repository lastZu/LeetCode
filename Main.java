public class Main {
    public static void main(String[] args) {
        // Find First and Last Position of Element in Sorted Array
        int[] nums = new int[] {1, 3, 3, 4, 6, 9};
        int[] fl11 = FindFirstAndLastPositionOfElementInSortedArray.searchRange(new int[] {1}, 1);
        int[] fl3 = FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 3);
        int[] fl1 = FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 1);
        int[] fl5 = FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 5);
        int[] flVoid = FindFirstAndLastPositionOfElementInSortedArray.searchRange(new int[] {}, 3);
    }
}
