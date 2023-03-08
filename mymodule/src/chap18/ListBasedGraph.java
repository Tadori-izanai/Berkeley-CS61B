package chap18;

import java.util.ArrayList;
import java.util.List;

public class ListBasedGraph implements Graph {
    private final int V;
    private int E;
    private List<Integer>[] adj;


    public ListBasedGraph(int V) {
        this.V = V;
        this.E = 0;

        adj = (List<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i += 1) {
            adj[i] = new ArrayList<>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E += 1;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
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
