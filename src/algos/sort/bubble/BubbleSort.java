package algos.sort.bubble;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 8, 9, 3, 6, 1};
        //int[] array = {8, 5, 4, 6, 2, 7};
        System.out.println(Arrays.toString(selectionSort(array)));
    }

    /**
     * Sorted part = END, unsorted = LEFT.<br/>
     * Biggest item bubbles up to the end.<br/>
     * Swap of couples.
     */
    private static int[] selectionSort(int[] array) {
        int length = array.length;
        // 8 5 4 6 2 7
        // 0 1 2 3 4 5     length = 6
        int sortedStart = length;
        for (int i = 0; i < length - 1; i++) {
            sortedStart--;
            for (int j = 0; j < sortedStart; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
