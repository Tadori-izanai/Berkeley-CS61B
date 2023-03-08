package chap18;

import java.util.*;

public class BreadthFirstPaths implements Paths {
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int[] distTo;
    private final int V;
    private final int s;


    // non-recursive
    private void bfs(Graph G, int s) {
        Queue<Integer> fringe = new ArrayDeque<>();
        fringe.add(s);
        marked[s] = true;
        distTo[s] = 0;

        while (!fringe.isEmpty()) {
            int v = fringe.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    fringe.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }

    public BreadthFirstPaths(Graph G, int s) {
        this.V = G.V();
        this.s = s;

        marked = new boolean[V];
        for (int i = 0; i < V; i += 1) {
            marked[i] = false;
        }

        edgeTo = new int[V];
        edgeTo[s] = s;

        distTo = new int[V];

        bfs(G, s);
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
