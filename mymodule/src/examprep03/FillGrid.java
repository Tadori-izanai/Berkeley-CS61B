package examprep03;

import java.util.Arrays;

public class FillGrid {
    public static void main(String[] args) {
        int[] LL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0};
        int[] UR = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[][] SS = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        System.out.println("SS.length = " + SS.length);

        fillGrid(LL, UR, SS);
        System.out.println(Arrays.deepToString(SS));
    }

    public static void fillGrid(int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int kL, kR;
        kL = kR = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                S[i][j] = LL[kL++];
            }
            for (int j = i + 1; j < N; j++) {
                S[i][j] = UR[kR++];
            }
        }

    }
}
