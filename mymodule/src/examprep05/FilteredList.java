package examprep05;

import java.util.*;

public class FilteredList<T> implements Iterable<T> {
    private List<T> lst;
    private Predicate<T> pred;

    public FilteredList(List<T> L, Predicate<T> filter) {
        this.lst = L;
        this.pred = filter;
    }

    @Override
    public Iterator<T> iterator() {
//        return new FilteredListIteratorGangster();
//        return new FilteredListIterator();
        return new FilteredListIteratorMoreEfficient();
    }


    private class FilteredListIteratorGangster implements Iterator<T> {
        ArrayList<T> items;
        Iterator<T> iter;

        public FilteredListIteratorGangster() {
            items = new ArrayList<>();
            for (T item : lst) {
                if (pred.test(item)) {
                    items.add(item);
                }
            }
            iter = items.iterator();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public T next() {
            return iter.next();
        }
    }


    private class FilteredListIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            while (index < lst.size() && !pred.test(lst.get(index))) {
                index++;
            }
            return (index < lst.size());
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T result = lst.get(index);
            index++;
            return result;
        }
    }


    private class FilteredListIteratorMoreEfficient implements Iterator<T> {
        Iterator<T> iter = lst.iterator();
        T currentItem;
        boolean flag = false;

        public FilteredListIteratorMoreEfficient() {
            if (iter.hasNext()) {
                move();
            }
        }

        private void move() {
            if (iter.hasNext()) {
                currentItem = iter.next();
            }
            while (iter.hasNext() && !pred.test(currentItem)) {
                currentItem = iter.next();
            }

            flag = pred.test(currentItem);
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext() || flag;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (!iter.hasNext() && flag) {
                flag = false;
                return currentItem;
            }

            T result = currentItem;
            move();
            return result;
        }
    }
}
