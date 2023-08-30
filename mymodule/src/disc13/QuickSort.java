package disc13;

import java.util.Arrays;

public class QuickSort {
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int[] pivotIndices = partition(arr, low, high);
            quicksort(arr, low, pivotIndices[0] - 1);
            quicksort(arr, pivotIndices[1] + 1, high);
        }
    }

    public static int[] partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int mid = low;
        int[] pivotIndices = new int[2];
        while (mid <= high) {
            if (arr[mid] < pivot) {
                swap(arr, mid, low);
                mid++;
                low++;
            } else if (arr[mid] > pivot) {
                swap(arr, mid, high);
                high--;
            } else {
                mid++;
            }
        }
        pivotIndices[0] = low;
        pivotIndices[1] = high;
        return pivotIndices;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {18, 7, 22, 34, 99, 18, 11, 4};
        partition(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
