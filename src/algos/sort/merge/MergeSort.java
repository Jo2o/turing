package algos.sort.merge;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

//        int[] array1 = {5, 8};
//        int[] array2 = {2, 9};
//        System.out.println(merge(array1, array2));

        int[] array = {5, 8, 9, 2, 1, 5, 3, 6};
        System.out.println(Arrays.toString(mergeSort(array)));

    }

    private static int[] mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) {
            return array;
        }
        int middleIdx = length / 2;

        int[] leftHalf = new int[middleIdx];
        for (int i = 0; i < middleIdx; i++) {
            leftHalf[i] = array[i];
        }

        int[] rightHalf = new int[length - middleIdx];
        for (int i = middleIdx; i < length; i++) {
            rightHalf[i - middleIdx] = array[i];
        }

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        return merge(leftHalf, rightHalf);
    }

    private static int[] merge(int[] array1, int[] array2) {
        int array1Length = array1.length;
        int array2Length = array2.length;
        int[] result = new int[array1Length + array2Length];

        int i = 0;
        int j = 0;
        int k = 0;

        while ((i < array1Length) && (j < array2Length)) {
            if (array1[i] < array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < array1Length) {
            result[k++] = array1[i++];
        }

        while (j < array2Length) {
            result[k++] = array2[j++];
        }

        return result;
    }
}
