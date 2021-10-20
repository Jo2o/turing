package turing;

import java.util.*;

public class XPlusOne {

    public static void main(String[] args) {
        System.out.println(calPoints(new int[] {1, 2, 3, 2}));
    }

    private static int calPoints(int[] ops) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int current : ops) {
            map.merge(current, 1, Integer::sum);
        }

        int previous = 0;
        int mainCounter = 0;
        int sameNumberCounter = 1;

        for (int i = 0; i < ops.length; i++) {
            int current = ops[i];
            if (i == 0) {
                previous = ops[0];
                continue;
            } else {
                if (current == previous) {
                    sameNumberCounter++;
                } else if (current == (previous + 1)) {
                    sameNumberCounter = 1;
                    mainCounter++;
                } else {
                    sameNumberCounter = 1;
                }
            }
        }
        return 0;
    }

}
