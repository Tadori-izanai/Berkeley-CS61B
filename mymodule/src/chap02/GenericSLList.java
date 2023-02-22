package chap02;

public class GenericSLList<ListType> {
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


    public GenericSLList(ListType x) {
        sentinel = new StuffNode(x, null);          // 不妨把 x 丢到 sentinel 中
        sentinel.next = new StuffNode(x, null);
        size = 1;
        last = sentinel.next;
    }

    public GenericSLList() {
        sentinel = new StuffNode(null, null);   // 不妨把 null 丢到 sentinel 中
        last = sentinel;
    }

    public void addFirst(ListType x) {
        sentinel.next = new StuffNode(x, sentinel.next);    // 注意所有 node 都要在 sb 之后
        size++;
    }

    public ListType getFirst() {
        return sentinel.next.item;
    }

    public void addLast(ListType x) {
        last.next = new StuffNode(x, null);
        last = last.next;
        size++;
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        GenericSLList<String> d = new GenericSLList<>("hello");
        d.addLast("world");
        System.out.println("d.size() = " + d.size());
        System.out.println("d.getFirst() = " + d.getFirst());

        GenericSLList<Integer> d1 = new GenericSLList<>();
        d1.addLast(10);
        d1.addFirst(5);
        d1.addLast(15);
        System.out.println("d1.size() = " + d1.size());
        System.out.println("d1.getFirst() = " + d1.getFirst());
    }
}
