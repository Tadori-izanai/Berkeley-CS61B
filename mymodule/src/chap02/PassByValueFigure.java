package chap02;

public class PassByValueFigure {
    public static void main(String[] args) {
        Walrus walrus = new Walrus(3500, 10.5);
        int x = 5;
        doStuff(walrus, x);
        System.out.println(walrus);
        System.out.println(x);
    }
    public static void doStuff(Walrus w, int x) {
        w.weight -= 100;
        x -= 5;
    }
}
