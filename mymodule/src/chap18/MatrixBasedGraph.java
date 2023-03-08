package chap18;

import java.util.ArrayList;
import java.util.List;

public class MatrixBasedGraph implements Graph {
    private final int V;
    private int E;
    private boolean[][] m;

    public MatrixBasedGraph(int V) {
        this.V = V;
        this.E = 0;

        m = new boolean[V][V];
        for (int i = 0; i < V; i += 1) {
            for (int j = 0; j < V; j += 1) {
                m[i][j] = false;
            }
        }
    }

    @Override
    public void addEdge(int v, int w) {
        m[v][w] = true;
        m[w][v] = true;
        E += 1;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        List<Integer> L = new ArrayList<>();
        for (int w = 0; w < V; w += 1) {
            if (m[v][w]) {
                L.add(w);
            }
        }
        return L;
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }
}
