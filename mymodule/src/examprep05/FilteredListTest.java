package examprep05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class FilteredListTest {
    public static class MyFilter implements Predicate<Integer> {
        @Override
        public boolean test(Integer x) {
            return (x % 2 == 0);
        }
    }

    @Test
    public void myTest() {
        int N = 50000 * 2;

        // more random tests
        for (int i = 0; i < 114; i++) {
            List<Integer> AL = new LinkedList<>();
            int size = StdRandom.uniform(0, N);
            for (int k = 0; k < size; k++) {
                AL.add(StdRandom.uniform(0, 114514));
            }

            FilteredList<Integer> FL = new FilteredList<>(AL, new MyFilter());

            List<Integer> result = new LinkedList<>();
            for (Integer n : FL) {
                result.add(n);
            }

//            System.out.println(AL);
//            System.out.println(result);

            MyFilter f = new MyFilter();
            for (Integer n : AL) {
                if (f.test(n)) {
                    assertEquals(n, result.remove(0));
                }
            }
        }

        // test
        ArrayList<Integer> AL = new ArrayList<>();
        AL.add(1);
        AL.add(1);
        AL.add(4); //
        AL.add(5);
        AL.add(1);
        AL.add(4); //
        AL.add(1);
        AL.add(9);
        AL.add(1); //
        AL.add(9);
        AL.add(8);
        AL.add(1); //
        AL.add(0);
        System.out.println(AL);

        FilteredList<Integer> FL = new FilteredList<>(AL, new MyFilter());

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : FL) {
            result.add(i);
        }
        System.out.println(result);

        MyFilter f = new MyFilter();
        for (Integer i : AL) {
            if (f.test(i)) {
                assertEquals(i, result.remove(0));
            }
        }
    }
}
