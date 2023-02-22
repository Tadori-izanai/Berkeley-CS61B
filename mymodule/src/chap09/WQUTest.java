package chap09;

public class WQUTest {
    public static void main(String[] args) {
        DisjointSets ds = new WeighedQuickUnionDS(9);
        ds.connect(2, 3);
        ds.connect(1, 2);
        ds.connect(5, 7);
        ds.connect(8, 4);
        ds.connect(7, 2);

        ds.connect(0, 6);
        ds.connect(6, 4);
        ds.connect(6, 3);

        DisjointSets ds1 = new WQUWithPathCompressionDS(9);
        ds1.connect(2, 3);
        ds1.connect(1, 2);
        ds1.connect(5, 7);
        ds1.connect(8, 4);
        ds1.connect(7, 2);
        ds1.isConnected(3, 3);

        ds1.connect(0, 6);
        ds1.connect(6, 4);
        ds1.connect(6, 3);
        ds1.isConnected(8, 6);
    }
}
