package disc03;

import java.util.Arrays;

public class IntArray {
    public static int[] insert(int[] arr, int item, int position) {
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, position);
        result[position] = item;
        System.arraycopy(arr, position, result, position + 1, arr.length - position);
        return result;
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int j = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int[] replicate(int[] arr) {
        int total = 0;
        for (int i : arr)
            total += i;
        int[] result = new int[total];

        int count = 0;
        for (int a : arr) {
            for (int j = 0; j < a; j++)
                result[count++] = a;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = new int[] {1, 1, 4, 1, 4};
        int[] b = insert(a, 5, 3);
        System.out.println(Arrays.toString(b));

        reverse(b);
        System.out.println(Arrays.toString(b));

        int[] c = replicate(b);
        System.out.println(Arrays.toString(c));
    }
}
