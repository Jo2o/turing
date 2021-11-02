package algos.sort.counting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] array = new int[] {3, 0, 2, 0, 0, 2, 2};
        int k = 3;
        System.out.println(Arrays.toString(countingSort(array, k)));
    }

    private static int[] countingSort(int[] array, int k) {
        int[] result = new int[array.length];
        int[] occurrences = new int[k + 1];

        // occurrences [ ][ ][ ][ ] - how many times is value of the index in the input array?
        //             0  1  2  3
        for (int i = 0; i < array.length; i++) {
            occurrences[array[i]]++;
        }
        // occurrences [3][0][3][1]
        int idx = 0; // idx of the result array
        for (int i = 0; i < occurrences.length; i++) {
            while (occurrences[i] > 0) { // decrease occurrences by one by adding the number to the next index in the result array
                result[idx++] = i;
                occurrences[i]--;
            }
        }

        return result;
    }
}
