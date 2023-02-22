package chap02;

import java.util.Arrays;

public class test02 {
    public static void main(String[] args) {
        int[] x = new int[]{-1, 2, 5, 4, 99};
        int[] b = {9, 10, 11};
        System.arraycopy(b, 0, x, 3, 2);
        System.out.println(Arrays.toString(x));
    }
}
