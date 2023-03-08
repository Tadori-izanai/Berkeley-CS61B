# Shortest Paths

## BFS v.s. DFS for Path Finding

* BFS returns path with shortest number of edges.
* Time efficiency is similar for both algorithms.
* Space Efficiency is quite different.
* * DFS is worse for spindly graphs. (Call stack gets very deep.)
* * BFS is worse for bushy graphs. (Queue gets very large.)
* Track the `distTo` and `edgeTo` arrays requires `Θ(V)` memory.

## Shortest Path Tree

* For every vertex v (which is not s) in the graph, find the shortest path from s to v.
* Combine all the edges that the algorithm found above.
* regardless the graph is directed or not

<img src="./Shortest Paths.assets/image-20230305175240380.png" alt="image-20230305175240380" style="zoom:25%;" />

- The shortest path tree (SPT) always has (V - 1) edges
    - actually, for any tree, it has (V - 1) edges, supposing the number of vertices is V

---

## Dijkstra's Algorithm

Instead of BFS, an algorithm which takes into account edge distances (edge weights) is created. (Perform a best first search)

* Create a priority queue.
* Add s to the priority queue with priority 0. 
* Add all other vertices to the priority queue with priority infinity.
* While the priority queue is not empty, and relax all of the edges going out from the vertex.

As long as the edges are all non-negative, Dijkstra's is guaranteed to be optimal.

### Relax

* For the popped vertex v, iterate through its edges.
* For the edge (v,w), compare the `currentBestDistToV + weight(v,w)` and `currentBestDistToW`.
* If the former is smaller, set the `currentBestDistToW = currentBestDistToV + weight(v,w)`, and set `edgeTo[w] = v`.
* Never relax edges that point to already visited vertices.

### Code

```pseudocode
def dijkstras(source):
    PQ.add(source, 0)
    For all other vertices, v:
    	PQ.add(v, infinity)
    while PQ is not empty:
        p = PQ.removeSmallest()
        relax(all edges from p)

def relax(edge p -> q with weight w):
   if q is visited:			/* i.e. q is not in PQ*/
       return
   if distTo[p] + weight(edge) < distTo[q]:
       distTo[q] = distTo[p] + w
       edgeTo[q] = p
       PQ.changePriority(q, distTo[q])
```

<img src="./Shortest Paths.assets/image-20230305183036466.png" alt="image-20230305183036466" style="zoom:25%;" />

- `edgeTo[v]` is the best known predecessor of v
- `distTo[v]` is the best known total distance from source to v
- `PQ` contains all unvisited vertices in order of `distTo()`

### Proof

* At start, `distTo[source] = 0`.
* After relaxing all edges from source, assume v1 is the closet vertex to the source.
* Suppose there's another path `(s,va,vb,...,v1)`, which is shorter than `(s,v1)`.
* Since `(s,va)` is longer than `(s,v1)`, that path doesn't exist.
* Thus, v1 is the closet vertex to the source, and that argument is still valid for all the edges of v1.

> Dijkstra's alg can fail if graph has negative edges

> The proof waht wiki gives:
>
> *Proof of Dijkstra's algorithm is constructed by induction on the number of visited nodes.*
>
> *Invariant hypothesis*: For each visited node v, dist[v] is the shortest distance from source to v, and for each unvisited node u, dist[u] is the shortest distance from source to u when traveling via visited nodes only, or infinity if no such path exists. (Note: we do not assume dist[u] is the actual shortest distance for unvisited nodes, while dist[v] is the actual shortest distance)
>
> The base case is when there is just one visited node, namely the initial node source, in which case the hypothesis is [trivial](https://en.wikipedia.org/wiki/Triviality_(mathematics)).
>
> Next, assume the hypothesis for *k-1* visited nodes. Next, we choose u to be the next visited node according to the algorithm. ==We claim that dist[u] is the shortest distance from source to u.==
>
> To prove that claim, we will proceed with a proof by contradiction. ==If there were a shorter path, then there can be two cases, either the shortest path contains another unvisited node or not.==
>
> <u>In the first case</u> (the shorter path contains a unvisited node w), let w be the first unvisited node on the shortest path. By the induction hypothesis, the shortest path from source to u and w through visited node only has cost dist[u] and dist[w] respectively. That means the cost of going from source to u through w has the cost of at least dist[w] + the minimal cost of going from w to u. As the edge costs are positive, the minimal cost of going from w to u is a positive number.
>
> Also dist[u] < dist[w] because the algorithm picked u instead of w.
>
> Now we arrived at a contradiction that dist[u] < dist[w] yet dist[w] + a positive number < dist[u].
>
> <u>In the second case</u> (the shorter path contains no unvisited nodes), let w be the last but one node on the shortest path. That means dist[w] + Graph.Edges[w,u] < dist[u]. That is a contradiction because by the time w is visited, it should have set dist[u] to at most dist[w] + Graph.Edges[w,u].
>
> For all other visited nodes v, the induction hypothesis told us dist[v] is the shortest distance from source already, and the algorithm step is not changing that.
>
> After processing u, it will still be true that for each unvisited node w, dist[w] will be the shortest distance from source to w using visited nodes only, because if there were a shorter path that doesn't go by u we would have found it previously, and if there were a shorter path using u we would have updated it when processing u.
>
> After all nodes are visited, the shortest path from source to any node v consists only of visited nodes, therefore dist[v] is the shortest distance.

### Runtime

Dijkstra's Algorithm is based on the PQ.k

Overall runtime: `O(V log(V) + V log(V) + E log(V))`

Connected graph: `O(E log V)` (E > V)

* `add`: V, each costing `O(log V)` time.
* `removeSmallest`: V, each costing `O(log V)` time.
* `changePriority`: E, each costing `O(log V)` time.

<img src="./Shortest Paths.assets/image-20230305213208364.png" alt="image-20230305213208364" style="zoom:25%;" />

---

<br>

1. Dijkstra's relax

    ```pseudocode
    def visit(v):
    	for each edge(v, w) with weight n:
    		if distTo[w] > n + distTo[v]:
    			distTo[w] = n + distTo[v]
    			edgeTo[w] = v
        Reorder fringe as needed
    ```

    Sigle destination relax
    ```pseudocode
    def relax(v):
    	if v == target:
    		exit
       	for each edge(v, w) with weight n:
       		if distTo[w] > n + distTo[v]:
       			distTo[w] = n + distTo[v]
    			edgeTo[w] = v
    ```

### A*

```java
shortestPath(Graph G, int start, int end, int[] weight, int[] h, int[] parent, double dist) {
    for (int v = 0; v < G.numVertices(); v += 1) {
        dist[v] = /* infty */;
        parent[v] = -1;
    }
    dist[start] = 0;
    
    /* Graph-traversal schema replacement for A* search */
}
```

- collection_of_vertices [A* search]: the priority queue of vertices ordered by the value of `distTo[v] + h(v)` values
    - `h(v)` is a consistent heuristic estimate of distance from `v` to `end`
    - for Dijkstra's alg, the `h(v)` equals to 0

    1. `h(v)` must not bigger than the actual shortest-path length from `v` to `end`

    2. if `(v, w)` is an edge, then `h(v) <= weigh[(v, w)] + h(w)`

---

<img src="./Shortest Paths.assets/image-20230307195155874.png" alt="image-20230307195155874" style="zoom: 50%;" />













