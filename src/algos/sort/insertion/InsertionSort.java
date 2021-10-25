package algos.sort.insertion;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 8, 9, 3, 6, 1};
        //int[] array = {8, 5, 4, 6, 2, 7};
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    /**
     * Sorted part = START, unsorted = LEFT.<br/>
     * Move by swapping into the correct place in the sorted part.<br/>
     */
    private static int[] insertionSort(int[] array) {
        int length = array.length;
        // 8 5 4 6 2 7
        // 0 1 2 3 4 5     length = 6
        for (int i = 1; i < length; i++) {
            int current = array[i];
            for (int j = i - 1; j > -1; j--) {
                if (current < array[j]) {
                    int temp = current;
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
