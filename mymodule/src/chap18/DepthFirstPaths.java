package chap18;

import java.util.ArrayList;
import java.util.Collections;

public class DepthFirstPaths implements Paths {
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int V;
    private final int s;


    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public void printPostorder(Graph G) {
        boolean[] visited = genBooleanArray(V);
        printPostorderHelper(G, s, visited);
    }
    public void printPreorder(Graph G) {
        boolean[] visited = genBooleanArray(V);
        printPreorderHelper(G, s, visited);
    }
    private boolean[] genBooleanArray(int size) {
        boolean[] b = new boolean[size];
        for (int i = 0; i < size; i += 1) {
            b[i] = false;
        }
        return b;
    }
    private void printPostorderHelper(Graph G, int v, boolean[] visited) {
        if (!visited[v]) {
            visited[v] = true;
            for (int w : G.adj(v)) {
                printPostorderHelper(G, w, visited);
            }
            System.out.println(v);
        }
    }
    private void printPreorderHelper(Graph G, int v, boolean[] visited) {
        if (!visited[v]) {
            visited[v] = true;
            System.out.println(v);
            for (int w : G.adj(v)) {
                printPreorderHelper(G, w, visited);
            }
        }
    }


    public DepthFirstPaths(Graph G, int s) {
        this.V = G.V();
        this.s = s;

        marked = genBooleanArray(V);

        edgeTo = new int[V];
        edgeTo[s] = s;

        dfs(G, s);
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        ArrayList<Integer> path = new ArrayList<>();
        while (v != s) {
            path.add(v);
            v = edgeTo[v];
        }
        path.add(s);
        Collections.reverse(path);      // important!
        return path;
    }
}
