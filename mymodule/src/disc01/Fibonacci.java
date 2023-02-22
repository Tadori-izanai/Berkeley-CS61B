package disc01;

public class Fibonacci {
    public static int fib(int n) {
        if (n < 2)
            return n;
        return (fib(n - 1) + fib(n - 2));
    }


    public static int fib2(int n, int k, int f0, int f1) {
        if (n == k)
            return f0;
        else
            return fib2(n, k + 1, f1, f0 + f1);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 9; i++)
            System.out.println(fib(i));
    }
}
