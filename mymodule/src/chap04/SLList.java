package chap04;

public class SLList<ListType> implements List61B<ListType> {
    // 注意 node 不能声明为 static, 不然无法使用 ListType
    public class StuffNode {
        public ListType item;
        public StuffNode next;

        public StuffNode(ListType i, StuffNode n) {
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;
    private StuffNode last;

    public SLList(ListType x) {
        sentinel = new StuffNode(x, null);          // 不妨把 x 丢到 sentinel 中
        sentinel.next = new StuffNode(x, null);
        size = 1;
        last = sentinel.next;
    }

    public SLList() {
        sentinel = new StuffNode(null, null);   // 不妨把 null 丢到 sentinel 中
        last = sentinel;
    }

    @Override
    public void addFirst(ListType x) {
        sentinel.next = new StuffNode(x, sentinel.next);    // 注意所有 node 都要在 sb 之后
        size++;
    }

    @Override
    public ListType getFirst() {
        return sentinel.next.item;
    }

    @Override
    public void addLast(ListType x) {
        last.next = new StuffNode(x, null);
        last = last.next;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    // Section 4.1 新增 method
    @Override
    public ListType get(int index) {
        StuffNode iter = sentinel.next;
        while (index-- > 0) {
            iter = iter.next;
        }
        return iter.item;
    }


//    public static void main(String[] args) {
//        SLList<String> d = new SLList<>("hello");
//        d.addLast("world");
//        System.out.println("d.size() = " + d.size());
//        System.out.println("d.getFirst() = " + d.getFirst());
//
//        SLList<Integer> d1 = new SLList<>();
//        d1.addLast(10);
//        d1.addFirst(5);
//        d1.addLast(15);
//        System.out.println("d1.size() = " + d1.size());
//        System.out.println("d1.getFirst() = " + d1.getFirst());
//
//        System.out.println("d1.get(1) = " + d1.get(1));
//    }


    // 新增部分
    @Override
    public ListType getLast() {
        // TODO
        return null;
    }

    @Override
    public ListType removeLast() {
        if (size == 0) {
            return null;
        }
        ListType lastItem = last.item;
        StuffNode p = sentinel;
        while (p.next != last) {
            p = p.next;
        }
        p.next = null;
        last = p;
        size--;
        return lastItem;
    }

    @Override
    public void insert(ListType item, int position) {
        // TODO
    }


    // 接口中的 default method 也可以 override
    @Override public void print() {
        System.out.println("print() in SLList");
        for (StuffNode p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
}
