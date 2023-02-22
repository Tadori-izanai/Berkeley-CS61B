package chap02;

import java.util.Arrays;

public class ArrayDenger {
    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] z = new int [3][];
        z[0] = x[0];
        z[1] = x[1];
        z[2] = x[2];
        z[0][0] = -z[0][0];

        int[][] w = new int[3][3];
        System.arraycopy(x[0], 0, w[0], 0, 3);
        System.arraycopy(x[1], 0, w[1], 0, 3);
        System.arraycopy(x[2], 0, w[2], 0, 3);
        w[0][0] = -w[0][0];

        System.out.println("Arrays.toString(x[0]) = " + Arrays.toString(x[0]));
        System.out.println("Arrays.toString(x[1]) = " + Arrays.toString(x[1]));
        System.out.println("Arrays.toString(x[2]) = " + Arrays.toString(x[2]));
        System.out.println("Arrays.toString(z[0]) = " + Arrays.toString(z[0]));
        System.out.println("Arrays.toString(z[1]) = " + Arrays.toString(z[1]));
        System.out.println("Arrays.toString(z[2]) = " + Arrays.toString(z[2]));
        System.out.println("Arrays.toString(w[0]) = " + Arrays.toString(w[0]));
        System.out.println("Arrays.toString(w[1]) = " + Arrays.toString(w[1]));
        System.out.println("Arrays.toString(w[2]) = " + Arrays.toString(w[2]));
    }
}
