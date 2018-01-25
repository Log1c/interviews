package ua.logic.bifit;

import java.util.Arrays;

/**
 * Created by Log1c on 11.02.2015.
 */
public class Permutator {

    public static void main(String[] args) {
        final int SIZE = 3;

        int[] data = createArrayIntegers(SIZE);
        permute(data, data.length);
    }

    public static void permute (int[] arr, int size) {
        if (size < 2) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int k = 0; k < size; k++){
                swap(arr, k, size - 1);
                permute(arr, size - 1);
                swap(arr, k, size - 1);
            }
        }
    }

    private static void swap(int[] arr, int index0, int index1) {
        int tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }

    private static int[] createArrayIntegers(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }


}