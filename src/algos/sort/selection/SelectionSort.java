package algos.sort.selection;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 8, 9, 3, 6, 1};
        System.out.println(Arrays.toString(selectionSort(array)));
    }

    /**
     * Sorted part = LEFT, unsorted = RIGHT.<br/>
     * Move current item to look for smaller number.<br/>
     * Update current minimum index.<br/>
     * Swap.
     */
    private static int[] selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < (length - 1); i++) {       // there is swap therefore (length - 1)
            int minIdx = i;                            // setup current minimum index
            for (int j = (i + 1); j < length; j++) {
                if (array[j] < array[minIdx]) {        // look for smaller item
                    minIdx = j;                        // update minimum index
                }
            }
            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
        return array;
    }

}
