package chap02;

public class GenericAList<TypeName> {
    private final int RFACTOR = 2;
    private int size;
    private TypeName[] items;


    public GenericAList() {
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


    public static void main(String[] args) {
        GenericAList<String> A = new GenericAList<>();
        A.addLast("hello");
        A.addLast("world");
        System.out.println(A.size());
        System.out.println(A.get(0));
        System.out.println(A.removeLast());
        System.out.println(A.size());
    }
}
