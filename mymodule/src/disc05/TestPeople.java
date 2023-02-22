package disc05;

public class TestPeople {
    public static void main(String[] args) {
        Person n = new Person("Neil", 12);
        Person a = new Grandma("Ada", 60);
        Grandma v = new Grandma("Vidya", 80);
//        Grandma al = new Person("Alex", 70);    // ce

        n.greet(a);     // Hello, Ada
        n.greet(v);     // Hello, Vidya
        v.greet(a);     // Hello, young whippersnapper
        v.greet((Grandma) a);   // How as bingo, Ada?
        a.greet(n);     // Hello, young whippersnapper
        a.greet(v);     //  Hello, Vidya (×)
                        // Hello, young whippersnapper (√)

        ((Grandma) a).greet(v);     // How as bingo, Vidya?
//        ((Grandma) n).greet(v);     // How as bingo, Vidya? (×)
                                    // re (√, 总是不允许动态类型是 Person 的 cast 到 Grandma)



        /* my test*/
        System.out.println();
        ((Person) a).greet(v);  // Hello, young whippersnapper (cast 仅影响到静态)
        ((Person) v).greet(v);  // Hello, young whippersnapper
    }
}
