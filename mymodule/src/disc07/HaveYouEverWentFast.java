package disc07;

public class HaveYouEverWentFast {
    public static boolean findSum(int[] A, int x) {
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int sum = A[i] + A[j];
            if (sum < x) {
                i++;
            } else if (sum > x) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean findSumNSquare(int[] A, int x) {
        for (int i : A) {
            for (int j : A) {
                if (i + j == x) {
                    return true;
                }
            }
        }
        return false;
    }

}
