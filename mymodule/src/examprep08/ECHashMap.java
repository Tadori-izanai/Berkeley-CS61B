package examprep08;

import java.util.ArrayList;
import java.util.LinkedList;

public class ECHashMap<K, V> {
    private class Node {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key.toString() + ", " + value.toString() + ")";
        }
    }

    private LinkedList<Node>[] buckets;
    private final int M = 4;

    public ECHashMap() {
        buckets = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = Math.floorMod(key.hashCode(), M);
        for (Node n : buckets[index]) {
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        buckets[index].addLast(new Node(key, value));
    }

    public void printAll() {
        for (int i = 0; i < M; i++) {
            System.out.print(i + ": ");
            System.out.println(buckets[i]);
        }
    }
}
