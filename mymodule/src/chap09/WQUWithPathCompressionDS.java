package chap09;

public class WQUWithPathCompressionDS extends WeighedQuickUnionDS {
    public WQUWithPathCompressionDS(int N) {
        super(N);
    }

    private void find(int p) {
        int pRoot = p;
        while (parent[pRoot] >= 0) {
            pRoot = parent[pRoot];
        }   // to find the root `pRoot`

        while (p != pRoot) {
            int pParent = parent[p];
            parent[p] = pRoot;
            p = pParent;
        }   // Set `patent` on all nodes along the path to `pRoot`
    }

    @Override
    public boolean isConnected(int p, int q) {
        find(p);
        find(q);
        return super.isConnected(p, q);
    }

    @Override
    public void connect(int p, int q) {
        find(p);
        find(q);
        super.connect(p, q);
    }
}
