package kyndryl;

import java.util.*;

public class TwoNumbersSumSearch {
    /**
     * We are looking for two songs with different lengths.
     * Their total length is set by 'targetLength' attribute
     *
     * a) Modify the algorithm to be able to find more fits
     * b) Modify the algorithm to have adjustable threshold
     */

    public static void main(String[] args) {
        int targetLength = 60;
        int[] songLengths = new int[] { 40, 31, 22, 15, 6, 72, 29, 21, 20};

        List<int[]> resultPairs = findSongs(songLengths, targetLength);
        resultPairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }

    public static List<int[]> findSongs(int[] lengths, int targetLength) {
        if (lengths == null || lengths.length == 0) {
            throw new IllegalArgumentException("!!!");
        }

        List<int[]> resultPairs = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < lengths.length; i++) {
            int currentLen = lengths[i];
            int wanted = targetLength - currentLen;
            if (set.contains(wanted)) {
                int[] result = new int[2];
                result[0] = currentLen;
                result[1] = wanted;
                resultPairs.add(result);
            } else {
                set.add(lengths[i]);
            }
        }
        return resultPairs;
    }

}








