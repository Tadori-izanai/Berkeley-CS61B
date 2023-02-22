package chap04;

public class RotatingSLList<Item> extends SLList<Item> {
    public void rotateRight() {
        addFirst(removeLast());
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> L = new RotatingSLList<>();
        L.addLast(1);
        L.addLast(1);
        L.addLast(4);
        L.addLast(5);
        L.addLast(1);
        L.addLast(4);
        L.print();
        L.rotateRight();
        L.print();
    }
}
