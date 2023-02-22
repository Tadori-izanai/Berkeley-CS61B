package chap04;

public class AList<TypeName> implements List61B<TypeName> {
    private final int RFACTOR = 2;
    private int size;
    private TypeName[] items;


    public AList() {
        size = 0;
//        items = new int[100];
        items = (TypeName []) new Object[8];
    }

    public void resize(int x) {
        TypeName a[] = (TypeName []) new Object[x];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(TypeName x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[size] = x;
        size++;
    }
    
    public TypeName getLast() {
        return items[size - 1];
    }

    public TypeName get(int i) {
        return items[i];
    }
    
    public int size() {
        return size;
    }
    
    public TypeName removeLast() {
        TypeName last = getLast();
        items[size] = null;     // null out
        size--;
        return last;
    }


    // 新增的 method
    public TypeName getFirst() {
        // TODO
        return null;
    }

    public void addFirst(TypeName item) {
        // TODO
    }

    public void insert(TypeName item, int position) {
        // TODO
    }
}
