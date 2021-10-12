package leetcode;

import java.util.*;

public class SortSquaredArray {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        //int[] nums = {-1};
        //int[] nums = {0, 2};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    private static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> lifo = new ArrayDeque<>();
        Queue<Integer> fifo = new LinkedList<>();
        for (int num : nums) {
            if (num < 0) {
                lifo.push(num * num);
            } else {
                fifo.add(num * num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
           if (lifo.isEmpty() && !fifo.isEmpty()) {
               result[i] = fifo.remove();
           } else if (!lifo.isEmpty() && fifo.isEmpty()) {
               result[i] = lifo.pop();
           } else {
               int a = lifo.peek();
               int b = fifo.peek();
               result[i] = (a < b) ? lifo.pop() : fifo.remove();
           }
        }
        return result;
    }

}
