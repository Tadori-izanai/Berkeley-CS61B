package chap06;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T []) new Object[114514];      // 懒得 resize()
        size = 0;
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size++;
    }

    public int size() {
        return size;
    }


    private class ArraySetIterator implements Iterator<T> {
        int wizPos = 0;
        @Override
        public boolean hasNext() {
            return wizPos < size;
        }
        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos++;
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
//    public String toString() {
//        StringBuilder returnSB = new StringBuilder("{");
//        for (int i = 0; i < size - 1; i++) {
////            returnSB.append(items[i] + ", ");   // 不推荐, 因为还是用到了 String, 改为链式 .append()
//            returnSB.append(items[i]).append(", ");     // StringBuilder.append() 会返回 this, 可以链式
//        }
//        if (size > 0) {
//            returnSB.append(items[size - 1]);
//        }
//        returnSB.append("}");
//        return returnSB.toString();         // 需要 toString()
//    }
    public String toString() {
        ArrayList<String> listOfItems = new ArrayList<>();
        for (T x : this) {
            listOfItems.add(x.toString());
        }
        return "{" + String.join(", ", listOfItems) + "}";
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }


    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
        ArraySet<Glerp> returnSet = new ArraySet<>();
        for (Glerp x : stuff) {
            returnSet.add(x);
        }
        return returnSet;
    }



    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
//        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("horse");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(1989);
        aset.add(6);
        aset.add(4);
        for (int i : aset) {
            System.out.println(i);
        }
        // ugly ver.
        Iterator<Integer> iter = aset.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println(aset);

        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(4);
        aset2.add(6);
        aset2.add(1989);
        System.out.println(aset.equals(aset));
        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals("hello"));
        System.out.println(aset.equals(null));

        ArraySet<String> asetOfString = ArraySet.of("hi", "I'm", "here");
        System.out.println(asetOfString);
    }
}
