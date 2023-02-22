package chap01;

public class HelloNumbers {
    public static void main(String[] args) {
        for (int i = 0, sum = 0; i < 10; i++) {
            sum += i;
            System.out.print(sum + " ");    // 写为 ' ' 则不一样
        }
        System.out.println();
    }
}
