package chap18;

public interface Graph {
//    public Graph(int V);        // not allowed in interface

    /** add an edge v-w */
    void addEdge(int v, int w);

    /** vertices adjacent to v */
    Iterable<Integer> adj(int v);

    /** number of vertices */
    int V();

    /** number of edges */
    int E();

    /** the degree of a vertex v */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree += 1;
        }
        return degree;
    }

    /** prints all edges */
    public static void print(Graph G) {
        for (int v = 0; v < G.V(); v += 1) {
            for (int w : G.adj(v)) {
                System.out.println(v + " - " + w);
            }
        }
    }

}
