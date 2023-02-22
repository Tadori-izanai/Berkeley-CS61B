package chap06;

import java.util.List;
import java.util.ArrayList;

import java.util.Set;
import java.util.HashSet;

public class Example {
    public static void main(String[] args) {
        listsDemo();
        setsDemo();
    }

    public static void listsDemo() {
        List<Integer> L = new ArrayList<>();        // 类似于 python 的 list
        L.add(5);
        L.add(10);
        System.out.println(L);
    }

    public static void setsDemo() {
        Set<String> S = new HashSet<>();
        S.add("Tokyo");
        S.add("Lagos");
        System.out.println(S.contains("Tokyo"));
    }
}
