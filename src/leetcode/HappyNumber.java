package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    /**
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     *
     * Input: n = 19 => Output: true
     * Explanation:
     *      1^2 + 9^2 = 82
     *      8^2 + 2^2 = 68
     *      6^2 + 8^2 = 100
     *      1^2 + 0^2 + 0^2 = 1
     */
    private static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> history = new HashSet<>();
        while ((n != 1) && (!history.contains(n))) {
            history.add(n);
            String numberString = Integer.toString(n);
            int numberDigitCount = numberString.length();
            n = 0;
            for (int i = 0; i < numberDigitCount; i++) {
                int digit =  Integer.parseInt(String.valueOf(numberString.toCharArray()[i]));
                n += (digit * digit);
            }
        }
        return n == 1;
    }

}
