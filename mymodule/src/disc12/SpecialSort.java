package disc12;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class SpecialSort {
    // The given array only contains 0's, 1's and 2's

    /** sort the arr */
    public static void specialSort(int[] arr) {
        int front = 0;
        int back = arr.length - 1;
        int curr = 0;

        while (curr <= back) {
            if (arr[curr] < 1) {
                swap(arr, curr, front);
                front += 1;
                curr += 1;
            } else if (arr[curr] > 1) {
                swap(arr, curr, back);
                back -= 1;
            } else {
                curr += 1;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /** return a sorted array of arr, arr remains unchanged */
    public static int[] countSort(int[] arr) {
        // this initializes each element to the default value for that type (0 for int)
        int[] countEachNumber = new int[3];

        for (int x : arr) {
            countEachNumber[x] += 1;
        }

        int[] result = new int[arr.length];
        int ind = 0;
        for (int i = 0; i < 3; i += 1) {
            for (int j = 0; j < countEachNumber[i]; j += 1) {
                result[ind] = i;
                ind += 1;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i += 1) {
            int size = StdRandom.uniform(4, 16);
            int[] a = new int[size];
            for (int k = 0; k < size; k += 1) {
                a[k] = StdRandom.uniform(0, 3);
            }

            System.out.println(Arrays.toString(a));

            int[] aCount = countSort(a);
            System.out.println(Arrays.toString(aCount));

            specialSort(a);
            System.out.println(Arrays.toString(a));
            System.out.println();
        }
    }
}
