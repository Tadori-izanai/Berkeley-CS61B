package chap11;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;

        // `public` is Redundant (
        BSTNode(K key, V value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private BSTNode root = null;
    private int size = 0;


    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        return containsKeyHelper(root, key);
    }
    private boolean containsKeyHelper(BSTNode p, K key) {
        if (p == null) {
            return false;
        }
        if (key.compareTo(p.key) == 0) {
            return true;
        } else if (key.compareTo(p.key) < 0) {
            return containsKeyHelper(p.left, key);
        } else {
            return containsKeyHelper(p.right, key);
        }
    }

    /** Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(root, key);
    }
    private V getHelper(BSTNode p, K key) {
        if (p == null) {
            return null;
        }
        if (key.compareTo(p.key) == 0) {
            return p.value;
        } else if (key.compareTo(p.key) < 0) {
            return getHelper(p.left, key);
        } else {
            return getHelper(p.right, key);
        }
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    /** Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        root = putHelper(root, key, value);
    }
    private BSTNode putHelper(BSTNode p, K key, V value) {
        if (p == null) {
            size++;
            return new BSTNode(key, value, null, null);
        }
        if (key.compareTo(p.key) == 0) {
            p.value = value;
        } else if (key.compareTo(p.key) < 0) {
            p.left = putHelper(p.left, key, value);
        } else {
            p.right = putHelper(p.right, key, value);
        }
        return p;
    }

    /** Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet() {
        Set<K> s = new TreeSet<>();
        loadKeys(root, s);
        return s;
    }
    private void loadKeys(BSTNode p, Set<K> s) {
        if (p != null) {
            loadKeys(p.left, s);
            s.add(p.key);
            loadKeys(p.right, s);
        }
    }

    /** Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        if (!containsKey(key)) {
            return null;
        }
        V result = get(key);
        root = removeHelper(root, key);
        size--;
        return result;
    }
    private BSTNode removeHelper(BSTNode p, K key) {
        if (p == null) {
            return null;
        }
        int cmp = key.compareTo(p.key);
        if (cmp == 0) {
            if (p.left == null) {
                return p.right;
            }
            if (p.right == null) {
                return p.left;
            }
            p = searchPredecessor(p);
            p.left = removeHelper(p.left, p.key);
        }
        if (cmp < 0) {
            p.left = removeHelper(p.left, key);
        } else {
            p.right = removeHelper(p.right, key);
        }
        return p;
    }
    private BSTNode searchPredecessor(BSTNode p) {
        BSTNode q = p.left;
        while (q.right != null) {
            q = q.right;
        }
        return new BSTNode(q.key, q.value, p.left, p.right);
    }

    /** Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        if (!containsKey(key)) {
            return null;
        }
        if (!get(key).equals(value)) {
            return null;
        }
        removeHelper(root, key);
        size--;
        return value;
    }

    /** return iterator (迫真) */
    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

    /** Prints out the BSTMap in order of increasing Key */
    public void printInOrder() {
        System.out.println("{");
        printInOrderHelper(root, true);
        System.out.println("\n}");
    }
    private void printInOrderHelper(BSTNode p, boolean first) {
        if (p != null) {
            printInOrderHelper(p.left, first);
            if (!first) {
                System.out.println(",");
            } else {
                first = false;
            }
            System.out.print("\t" + p.key + ": " + p.value);
            printInOrderHelper(p.right, first);
        }
    }



    private BSTNode rotateRootRight(BSTNode h) {
        BSTNode x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }
    private BSTNode rotateRootLeft(BSTNode h) {
        BSTNode x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }
    public void rotateRootRight() {
        root = rotateRootRight(root);
    }
    public void rotateRootLeft() {
        root = rotateRootLeft(root);
    }
}
