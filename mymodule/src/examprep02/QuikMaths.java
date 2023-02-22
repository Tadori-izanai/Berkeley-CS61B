package examprep02;

public class QuikMaths {
    public static void multiplyBy3(int [] A) {
        for (int x : A)
            x *= 3; // 注意此处只是 x 依次取 A[0], ..., A[A.length - 1], 没有改变 A
    }

    public static void multiplyBy2(int[] A) {
        int[] B = A;
        for (int i = 0; i < B.length; i++)
            B[i] *= 2;
    }

    public static void swap(int A, int B) {
        int temp = B;
        B = A;
        A = temp;
    }

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{2, 3, 3, 4};
        multiplyBy3(arr);               // 还是 2, 3, 3, 4

        arr = new int[]{2, 3, 3, 4};
        multiplyBy2(arr);               // 便乘 4, 6, 6, 8

        int a = 6;
        int b = 7;
        swap(a, b);                     // 没有交换
    }
}
