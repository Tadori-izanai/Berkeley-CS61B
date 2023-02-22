package chap03;

public class Sort {
    public static void sort(String[] arr) {
        sort(arr, 0);
    }
    private static void sort(String[] arr, int start) {
        if (start < arr.length) {
            int smallestIndex = findSmallestIndex(arr, start);
            swap(arr, start, smallestIndex);
            sort(arr, start + 1);
        }
    }



    public static String findSmallest(String[] str) {
        String smallest = str[0];
        for (String s : str) {
            if (s.compareTo(smallest) < 0)
                smallest = s;
        }
        return smallest;
    }

    private static int findSmallestIndex(String[] str) {
        int smallestIndex = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].compareTo(str[smallestIndex]) < 0)
                smallestIndex = i;
        }
        return smallestIndex;
    }

    private static int findSmallestIndex(String[] str, int start) {
        int smallestIndex = start;
        for (int i = start; i < str.length; i++) {
            if (str[i].compareTo(str[smallestIndex]) < 0)
                smallestIndex = i;
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

}
