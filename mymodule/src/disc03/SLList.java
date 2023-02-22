package disc03;

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    // 在 position 的位置插入一个 node
    public void insert(int item, int position) {
        if (first == null || position == 0) {
            addFirst(item);
            return;
        }

        IntNode iter = first;
        for (int i = 0; i < position - 1; i++)
            iter = iter.next;

        iter.next = new IntNode(item, iter.next);
    }


    // 反转
    public void reverse() {
        SLList answer = new SLList();
        for (IntNode p = first; p != null; p = p.next) {
            answer.addFirst(p.item);
        }
        first = answer.first;
    }

    public void reverse3() {
        IntNode front = null;
        IntNode iter = first;
        while (iter != null) {
            IntNode temp = iter.next;   // 先把下一次所要迭代的 node 保存下来
            iter.next = front;
            front = iter;
            iter = temp;
        }
        first = front;
    }

    public void reverseRecursive() {
        first = getReverseFront(first);
    }
    private IntNode getReverseFront(IntNode front) {
        if (front == null || front.next == null)
            return front;
        IntNode reversed = getReverseFront(front.next);
        front.next.next = front;
        front.next = null;
        return reversed;
    }





    public static void main(String[] args) {
        SLList L = new SLList();
//        L.addFirst(2);
//        L.addFirst(6);
//        L.addFirst(5);
//        L.insert(10, 1);
//
//        L.reverse();
//        L.reverse3();

        L.addFirst(3);
        L.addFirst(2);
        L.addFirst(1);
        L.addFirst(0);

        L.reverseRecursive();
    }
}
