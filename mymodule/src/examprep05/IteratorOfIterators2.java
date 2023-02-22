package examprep05;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorOfIterators2 implements Iterator<Integer> {
    private LinkedList<Iterator<Integer>> iterators;

    public IteratorOfIterators2(List<Iterator<Integer>> a) {
        iterators = new LinkedList<>();
        for (Iterator<Integer> iter : a) {
            if (iter.hasNext()) {
                iterators.add(iter);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !iterators.isEmpty();
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Iterator<Integer> tmp = iterators.removeFirst();
        Integer result = tmp.next();
        if (tmp.hasNext()) {
            iterators.addLast(tmp);
        }
        return result;
    }

}
