package examprep05;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorOfIterators implements Iterator<Integer> {
    private List<Iterator<Integer>> iList;
    private int size;
    private int index;

    public IteratorOfIterators(List<Iterator<Integer>> a) {
        iList = a;
        size = a.size();
        index = 0;
    }

    @Override
    public boolean hasNext() {
        int cnt = 0;
        while (!iList.get(index).hasNext() && cnt < size) {
            index = (index + 1) % size;
            cnt++;
        }
        return (cnt < size);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Integer result = iList.get(index).next();
        index = (index + 1) % size;
        return result;
    }
}
