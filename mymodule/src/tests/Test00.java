package tests;

import java.util.*;

public class Test00 {
    public static void main(String[] args) {
        List<Integer> L = new ArrayList<>();
        System.out.println(-1 / 2);

        Model m = new Model(1);
        System.out.println(m.val());


        Model n = new Model(1);

        Set<Model> s = new HashSet<>();
        s.add(m);
        s.add(n);
        System.out.println(s);


        System.out.println(
            (new Model(1)).equals(new Model(1))
        );


        Map<Integer, Integer> hm = new HashMap<>();

    }
}
