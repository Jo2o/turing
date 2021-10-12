package leetcode;

public class SearchInsertPosition {
    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You must write an algorithm with <b>O(log n)</b> runtime complexity.
     * <br/>
     * Example 1:
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * <br/>
     * Example 2:
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * <br/>
     * Example 3:
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     * <br/>
     * Example 4:
     * Input: nums = [1,3,5,6], target = 0
     * Output: 0
     * <br/>
     * Example 5:
     * Input: nums = [1], target = 0
     * Output: 0
     */
    public static void main(String[] args) {
        //            0  1  2  3  4  6
        int[] nums = {1, 2,  4, 5, 6};
        System.out.println(searchInsert(nums, 0));
    }

    private static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int middle = end/2;

        if (nums[start] > target) {
            return 0;
        }

        while (start < end) {
            if (nums[middle] == target) {
                return middle;
            } else if (start == middle) {
                return middle + 1;
            } else if (nums[middle] < target) {
                start = middle;
                middle = middle + (end - middle)/2;
            } else {
                end = middle;
                middle = middle/2;
            }
        }

        return 0;
    }

}
