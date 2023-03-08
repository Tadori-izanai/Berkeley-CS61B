package chap18;

public class TestPaths {
    public static void main(String[] args) {
        Graph G = generateGraph();

//        Paths P = new DepthFirstPaths(G, 0);
        Paths P = new BreadthFirstPaths(G, 0);

        System.out.println(G.E());
        System.out.println(P.pathTo(7));

        test();
    }

    private static Graph generateGraph() {
//        Graph G = new ListBasedGraph(9);
        Graph G = new MatrixBasedGraph(9);
        G.addEdge(0, 1);
        G.addEdge(2, 1);
        G.addEdge(4, 1);
        G.addEdge(4, 3);
        G.addEdge(4, 5);
        G.addEdge(2, 5);
        G.addEdge(5, 6);
        G.addEdge(5, 8);
        G.addEdge(6, 7);
        return G;
    }


    private static void test() {
        Graph G = new ListBasedGraph(7);
        G.addEdge(0, 1);
        G.addEdge(0, 3);
        G.addEdge(2, 1);
        G.addEdge(3, 1);
        G.addEdge(2, 5);
        G.addEdge(3, 5);
        G.addEdge(3, 4);
        G.addEdge(5, 4);
        G.addEdge(5, 6);

        DepthFirstPaths P = new DepthFirstPaths(G, 0);
        System.out.println("post-order:");
        P.printPostorder(G);
        System.out.println("pre-order:");
        P.printPreorder(G);

    }
}
