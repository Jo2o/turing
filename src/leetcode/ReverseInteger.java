package leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    private static int reverse(int x) {
        int result = 0;
        int tmp = x;
        while (tmp != 0) {
            int previous = tmp;
            tmp /= 10;
            result = (previous - tmp * 10)  + (result * 10);
        }
        return result;
    }

    private static int reverseWithStrings(int x) {
        boolean isNegative = false;
        String numberAsString = Integer.toString(x);
        if (x < 0) {
            isNegative = true;
            numberAsString = numberAsString.substring(1);
        }

        String reversedAsString = "";
        char[] numberChars = numberAsString.toCharArray();
        for (int i = numberAsString.length()-1; i >=0 ; i--) {
            reversedAsString += numberChars[i];
        }
        int result;
        try {
            result = Integer.parseInt(reversedAsString);
        } catch (NumberFormatException e) {
            return 0;
        }

        return isNegative ? (-1 * result) : result;
    }
}
