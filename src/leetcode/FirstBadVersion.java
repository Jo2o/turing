package leetcode;

import static java.lang.Math.abs;

public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }

    private static int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }

        int start = 1;
        int end = n;
        int middle = n/2;

        while (abs(start - middle) >= 1) {
            if (isBadVersion(middle)) {
                end = middle;
                middle = end/2;
            } else {
                start = middle;
                middle = middle + (end - middle)/2;
            }
        }

        if (isBadVersion(middle)) {
            return middle;
        }
        if (isBadVersion(middle + 1)) {
            return middle + 1;
        }
        return end;
    }

    // 1 1 1 X X
    // 1 2 3 4 5
    private static boolean isBadVersion(int version) {
        if (version < 3) {
            return false;
        }
        return true;
    }

//    // 1 1 1 1 1 X X
//    // 1 2 3 4 5 6 7
//    private static boolean isBadVersion(int version) {
//        if (version < 6) {
//            return false;
//        }
//        return true;
//    }

}
