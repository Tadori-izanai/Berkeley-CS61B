package disc04;

public class D {
    public static class A {
        public int x = 5;
        public void m1() {
            System.out.println("Am1-> " + x);
        }
        public void m2() {
            System.out.println("Am2-> " + this.x);
        }
        public void update() {
            x = 99;
        }
    }

    public static class B extends A {
        public void m2() {
            System.out.println("Bm2-> " + x);
        }
        public void m2(int y) {
            System.out.println("Bm2y-> " + y);
        }
        public void m3() {
            System.out.println("Bm3-> " + "called");
        }
    }

    public static class C extends B {
        public int y = x + 1;       // 没问题 (
        public void m2() {
            System.out.println("Cm2-> " + super.x);
        }
        public void m4() {
//            System.out.println("Cm4-> " + super.super.x);         // 不允许 super.super
        }
        public void m5() {
            System.out.println("Cm5-> " + y);
        }
    }


    public static void main(String[] args) {
//        B a0 = new A();

        A b0 = new B();
        System.out.println(b0.x);   // 5
        b0.m1();                    // Am1-> 5
        b0.m2();                    // Bm2-> 5
//        b0.m2(61);                   // ! 不能编译 !

        B b1 = new B();
        b1.m2(61);              // Bm2-> 61
        b1.m3();                    // Bm3-> called

        A c0 = new C();
        c0.m2();                    // Cm2-> 5

//        C c1 = (A) new C();
        A a1 = (A) c0;
        C c2 = (C) a1;
        c2.m3();                    // Bm3-> called
        c2.m4();
        c2.m5();                    // Cm5-> 6;

        ((C) c0).m3();              // Bm3-> called
//        (C) c0.m2();

        b0.update();
        b0.m1();                    // Am1-> 99
    }
}
