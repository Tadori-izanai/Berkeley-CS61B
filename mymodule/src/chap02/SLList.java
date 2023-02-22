package chap02;

public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

//    public IntNode first;
//    private IntNode first;
    private IntNode sentinel;
    private int size;
    private IntNode last;


    public SLList(int x) {
//        first = new IntNode(x, null);
        sentinel = new IntNode(114154, null);   // 不妨 114514
        sentinel.next = new IntNode(x, null);
        size = 1;
        last = sentinel.next;
    }

    public SLList() {
//        first = null;
        sentinel = new IntNode(114514, null);
        size = 0;
        last = sentinel;
    }

    public void addFirst(int x) {
//        first = new IntNode(x, first);
        sentinel.next = new IntNode(x, sentinel.next);  // 注意所有 node 都要在 sb 之后
        size++;
    }

    public int getFirst() {
//        return first.item;
        return sentinel.next.item;
    }

    // 尝试编写 size()
//    public int size() {
//        int count = 0;
//        for (IntNode iter = first; iter != null; iter = iter.next)
//            count++;
//        return count;
//    }

    public void addLastOriginal(int x) {
    // >>>> 修正
//        if (first == null) {
//            first = new IntNode(x, null);
//            return;
//        }
    // <<<<
//        IntNode iter = first;
        IntNode iter = sentinel;
        while (iter.next != null)
            iter = iter.next;
        iter.next = new IntNode(x, null);
        size++;
    }

    public void addLast(int x) {
        last.next = new IntNode(x, null);
        last = last.next;
        size++;
    }

    // 使用递归实现 size (注意这里写的是 IntNode 的 size())
    // 因为只有 IntNode 才能采用递归来实现
//    public static int size(IntNode p) {
//        if (p.next == null)
//            return 1;
//        return (1 + size(p.next));
//    }
//    // 然后写 SLList 的 size()
//    public int size() {
//        return size(first);
//    }

    public int size() {
        return size;
    }





    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());

        // test size()
        System.out.println("L.size() = " + L.size());
        // test addLast()
        L.addLast(20);
        System.out.println("L.size() = " + L.size());

        // 测试空的 SLList
        SLList L2 = new SLList();
        L2.addLast(10);
        L2.addFirst(5);
        L2.addLast(15);
        System.out.println("L2.size() = " + L2.size());
        System.out.println("L2.getFirst() = " + L2.getFirst());
    }


}
