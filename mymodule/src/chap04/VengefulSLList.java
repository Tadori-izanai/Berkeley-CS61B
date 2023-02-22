package chap04;

public class VengefulSLList<Item> extends SLList<Item>{
    private SLList<Item> deletedItems = new SLList<>();

    @Override
    public Item removeLast() {
        Item lastItem = super.removeLast();     // call superclass's version of removeLast()
        deletedItems.addLast(lastItem);
        return lastItem;
    }

    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs = new VengefulSLList<>();
        vs.addLast(1);
        vs.addLast(1);
        vs.addLast(4);
        vs.addLast(5);
        vs.addLast(1);
        vs.addLast(4);
        vs.removeLast();
        vs.removeLast();
        vs.removeLast();
        vs.printLostItems();
    }
}
