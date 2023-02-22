package examprep04;

public class DMSList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }
        public int max() {
            return Math.max(item, next.max());
        }
    }

    private IntNode sentinel;

    public DMSList() {
        sentinel = new IntNode(-1000, new RearIntNode());    // TODO: fill h
    }
    // assume always x > 0
    public void insertFront(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
    }
    /* Returns 0 if list is empty. Otherwise, returns the max element. */
    public int max() {
        return sentinel.next.max();
    }

    // TODO: make the max() in DMSList work
    public class RearIntNode extends IntNode {
        public RearIntNode() {
            super(-114514, null);
        }

        @Override
        public int max() {
            return -114514;
        }
    }



    public static void main(String[] args) {
        DMSList dl = new DMSList();
        dl.insertFront(5);
        dl.insertFront(1);
        dl.insertFront(4);
        System.out.println(dl.max());
    }
}
