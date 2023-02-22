package examprep05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorOfIteratorsTest implements Iterable<Integer> {
    private List<Iterator<Integer>> a;

    public IteratorOfIteratorsTest(List<Iterator<Integer>> a) {
        this.a = a;
    }

    public Iterator<Integer> iterator() {
        return new IteratorOfIterators(a);
//        return new IteratorOfIterators2(a);
    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 3, 4, 5));
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>(List.of(2));

        ArrayList<Iterator<Integer>> AL = new ArrayList<>(
            List.of(A.iterator(), B.iterator(), C.iterator())
        );

        IteratorOfIteratorsTest II = new IteratorOfIteratorsTest(AL);

        for (Integer i : II) {
            System.out.println(i);
        }
    }
}
