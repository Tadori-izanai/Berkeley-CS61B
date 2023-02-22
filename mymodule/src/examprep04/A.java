package examprep04;

public class A {
    int fish(A other) {
        return 1;
    }

    int fish(B other) {
        return 2;
    }

    public static void main(String[] args) {
        A y = new B();
        B z = new B();

        System.out.println(y.fish(z));
        System.out.println(z.fish(z));
        System.out.println();
        System.out.println(z.fish(y));
        System.out.println(y.fish(y));
        System.out.println();
        System.out.println(z.fish(z));
        System.out.println(y.fish(y));
    }
}
