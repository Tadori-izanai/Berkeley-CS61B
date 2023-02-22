package chap02;

public class AList {
    private final int RFACTOR = 2;
    private int size;
    private int[] items;

    /** Creates an empty list. */
    public AList() {
        size = 0;
        items = new int[100];
    }

    public void resize(int x) {
        int a[] = new int[x];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int last = getLast();
        size--;
        return last;
    }
}
