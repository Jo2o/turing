package leetcode;

import java.util.*;

public class RightArrayRotation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
//        int[] nums = {-1, -100, 3, 99};
//        rotate(nums, 2);

        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        k %= length;

        for (int i = length - 1; i >= 0 ; i--) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int temp = queue.poll();
            queue.add(temp);
        }
        for (int i = length - 1; i >= 0 ; i--) {
            nums[i] = queue.poll();
        }
    }

}
