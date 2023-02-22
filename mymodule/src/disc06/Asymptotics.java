package disc06;

import java.util.Arrays;

public class Asymptotics {
    public static boolean noUniques(int[] array) {
        Arrays.sort(array);
        int N = array.length;

        int index = 0;
        for (int i = 1; i < N; i++) {
            if (array[i] == array[index]) {
                continue;
            }
            // array[i] != array[index]
            if (i == index + 1) {
                return false;
            }
            index = i;
        }
        return (index < N - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 4, 5, 1, 4};
        int[] arr2 = new int[]{1, 1, 4, 5, 1, 4, 5, 5};
        System.out.println(noUniques(arr));
        System.out.println(noUniques(arr2));

        System.out.println(noUniques(new int[]{1, 2, 2}));
    }
}
