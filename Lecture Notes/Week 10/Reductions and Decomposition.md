# Reductions and Decomposition

## Topological Sort

* Topological Sort is an ordering of a graph's vertices such that for every directed edge u→v, u comes beforev in the ordering.
* Topological sorts only apply to directed, acyclic (no cycles) graphs (DAG).

    > For undireceted graph, each edge creates a cycle:
    >
    > <img src="./Reductions and Decomposition.assets/image-20230309151326356.png" alt="image-20230309151326356" style="zoom:25%;" />
* Topological sort is called a linearization of the graph, since all the vertices in the graph could be redrawn in one line.

<img src="./Reductions and Decomposition.assets/image-20230309150255543.png" alt="image-20230309150255543" style="zoom:25%;" />

<img src="./Reductions and Decomposition.assets/image-20230309151458283.png" alt="image-20230309151458283" style="zoom:25%;" />

### Topological Sort Algorithm

* Perform a DFS traversal from every vertex in the graph, not clearing markings in between traversals.
* Record DFS postorder along the way.
* Topological ordering is the reverse of the postorder.

<img src="./Reductions and Decomposition.assets/image-20230309150442306.png" alt="image-20230309150442306" style="zoom:25%;" />

The total runtime of DFS is `O(V + E)`.

```pseudocode
topological(DAG):
    initialize marked array
    initialize postOrder list
    for all vertices in DAG:
        if vertex is not marked:
            dfs(vertex, marked, postOrder)
    return postOrder reversed

dfs(vertex, marked, postOrder):
    marked[vertex] = true
    for neighbor of vertex:
        dfs(neighbor, marked, postOrder)
    postOrder.add(vertex)
```

---

## Shortest Path Algorithm for DAGs

* Visit vertices in topological order. (instead of pop from a PQ)
* On each visit, relax all outgoing edges.

<img src="./Reductions and Decomposition.assets/image-20230309200217686.png" alt="image-20230309200217686" style="zoom:25%;" />

runtimes:

- Finding a topological sort takes $O(V+ E)$

- relaxing each vertex also takes $O(V+  E)$, so the total runtime is $O(V + E)$

    > Dijkstra's takes $O((V + E) \log V)$

---

## Longest Paths Problem

<img src="./Reductions and Decomposition.assets/image-20230309200516149.png" alt="image-20230309200516149" style="zoom:25%;" />

Consider the problem of finding the longest path from a start vertex to every other vertex. The path must be simple (contain no cycles).

It turns out that best known algorithm is exponential (impractically inefficient).

Negating all the edge weights and finding the shortest path leaves us in a tricky situation because then we could have negative cycles and we could go around and around them indefinitely.

### Longest Paths on DAGs

<img src="./Reductions and Decomposition.assets/image-20230309201332803.png" alt="image-20230309201332803" style="zoom:25%;" />

- This process is known as **reduction**. Since DAG-SPT can be used to solve DAG-LPT, we say that "DAG-LPT reduces to DAG-SPT."

<img src="./Reductions and Decomposition.assets/image-20230309201625635.png" alt="image-20230309201625635" style="zoom:25%;" />

## Reduction

<img src="./Reductions and Decomposition.assets/image-20230309202429136.png" alt="image-20230309202429136" style="zoom:25%;" />









