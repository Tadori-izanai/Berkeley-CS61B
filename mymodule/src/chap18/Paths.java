package chap18;

public interface Paths {
//    Paths(Graph G, int s);  // not allowed

    boolean hasPathTo(int v);
    Iterable<Integer> pathTo(int v);    // path from s to v (if any)
}
