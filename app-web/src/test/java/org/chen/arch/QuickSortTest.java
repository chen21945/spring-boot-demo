package org.chen.arch;

import java.util.Arrays;

public class QuickSortTest {

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int key = arr[low];
        int i = low + 1, j = high;
        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j--];
            }
            while (i < j && arr[i] <= key) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i++];
            }
        }
        arr[i] = key;
        quickSort(arr, low, j);
        quickSort(arr, i, high);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3};
        quickSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
