package leetcode;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 25};
        System.out.println(Arrays.toString(twoSum(nums, 5)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numberIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            if(numberIndex.get(target - current) != null) {
                int[] result = new int[2];
                result[0] = numberIndex.get(target - current) + 1;
                result[1] = i + 1;
                return result;
            }
            if (!numberIndex.containsKey(current)) {
                numberIndex.put(current, i);
            }
        }
        return null;
    }
}
