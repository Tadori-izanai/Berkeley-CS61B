package chap09;

public class WeighedQuickUnionDS implements DisjointSets {
    protected int[] parent;

    public WeighedQuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }


    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }


    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void connect(int p, int q) {
        if (p == q) {
            return;
        }
        int pRoot = find(p);
        int qRoot = find(q);

        if (-parent[pRoot] > -parent[qRoot]) {
            parent[pRoot] += parent[qRoot];
            parent[qRoot] = pRoot;

        } else if (-parent[pRoot] < -parent[qRoot]) {
            parent[qRoot] += parent[pRoot];
            parent[pRoot] = qRoot;

        } else {
            // Break ties by choosing the smaller integer to be the root
            if (pRoot < qRoot) {
                parent[pRoot] += parent[qRoot];
                parent[qRoot] = pRoot;
            } else {
                parent[qRoot] += parent[pRoot];
                parent[pRoot] = qRoot;
            }
        }
    }

}
