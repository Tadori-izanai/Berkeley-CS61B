# Range Searching and Multi-Dimensional Data

> some expanding interface of out Set:
>
> - `select(int i)`: returns the ith samllest item in the set
> - `rank(T x)`: returns the "rank" of `x` in set
> - `subSet(T from, T to):` returns all items between `from` and `to`
> - `nearest(T x)`: returns the value closest to `x`

## Introduction

Multi-Dimensional data strucutres could perform operations on a set of Body objects in space.

* 2D Range Finding: Count the objects in a specific region.
* Nearest Neighbors: Find the closest object to another object.

## HashTable ()

If the objects are stored in a HashTable, the problems above could be solved inefficiently.

* Runtime: `Θ(N)`, since the bucket that each object resides in is effectively random.

<img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308184505551.png" alt="image-20230308184505551" style="zoom:25%;" />

---

## Uniform Partitioning

The HashTable could be enhanced if each object is stored in a specific bucket based on its position. The space could be divided with a grid, and each portion is corresponded to a bucket in the HashTable, which is called "spatial hashing".

Instead of using the `hashCode()` method, each object provide a `getX()` and `getY()` method so that it can compute its own bucket number.

This method could reduce the amount of buckets to be searched, so that it is faster than without spatial partitioning on average.

* Runtime: `Θ(N)`, since the amount of grids is a constant.

## X-Based Tree or Y-Based Tree

Search Trees could explicitly track the order of items. To build a tree of objects in a two-dimensional space, the items should be comparable.

* X-Based Tree: Compare objects only based on their x-coordinate.
* Y-Based Tree: Compare objects only based on their y-coordinate.

Here's an example of X-Based Tree:

<!-- ![X-Based Tree](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-15%20at%2011.40.56%20AM.png) -->

<!-- ![X-Based Tree](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-15%20at%2011.41.02%20AM.png) -->

If a range finding operation is performed in the green rectangle, the right child of the root node is ignored. Skipping searching through parts of the search tree is called "pruning".

* Search in the optimized dimension: `log N`, due to the pruning operation.
* Search in the non-optimized dimension: `N`, which could be optimized with the QuadTree.

## QuadTree

The QuadTree is a tree data structure which could partition a two-dimensional space by recursively subdividing it into four quadrants.

<!-- ![QuadTree](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-16%20at%201.33.04%20AM.png) -->

<!-- ![QuadTree](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-16%20at%201.33.08%20AM.png) -->

<img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308172803379.png" alt="image-20230308172803379" style="zoom:25%;" />

<img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308172818031.png" alt="image-20230308172818031" style="zoom:25%;" />

* Each node has exactly four children: The northwest, northeast, southeast, and southwest region.
* The node B is inserted as the NE child of node A, since B resides in the northeast quadrant of A.

<!-- ![QuadTree](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-16%20at%201.46.01%20AM.png) -->

<img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308173405011.png" alt="image-20230308173405011" style="zoom:25%;" />

If a range finding operation is performed in the green rectangle, from any node the quadrants which the green rectangle does not lie within could be ignored and pruned away.

Quad-Trees are effective in 2-D spaces, but K-D trees could perform the operations in higher dimension spaces.

---

## K-D Trees

> k-d means "k dimensional"

The K-D Tree could extend the hierarchical partitioning idea to multi-dimensions, which works by rotating through all the dimensions by each level.

For the 2-D case, it partitions like an X-based Tree on the first level, then like a Y-based Tree on the next, then as an X-based Tree on third level, etc. 

* Each node has two children, since each level is partitioned into "greater" and "less than".
* (To break ties) Items equal in one dimension should always be stored in the "greater" part of its parent node. (If there are the same keys caming in a dimension, cannot just replace the value)

<!-- ![K-D Tree](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-16%20at%205.33.01%20PM.png) -->

<!-- ![K-D Tree](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-16%20at%201.57.42%20AM.png) -->

<img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308180800345.png" alt="image-20230308180800345" style="zoom:25%;" />

<img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308180811056.png" alt="image-20230308180811056" style="zoom:25%;" />

To find the point that is the nearest neighbor to a query point, we follow this procedure in our K-D Tree:

- Start at the root and store that point as the "best so far". Compute its distance to the query point, and save that as the "score to beat". In the image above, we start at A whose distance to the flagged point is 4.5.
- This node partitions the space around it into two subspaces. For each subspace, ask: "Can a better point be possibly found inside of this space?" This question can be answered by computing the shortest distance between the query point and the edge of our subspace (see dotted purple line below).
- Continue recursively for each subspace identified as containing a possibly better point.
- In the end, our "best so far" is the best point; the point closest to the query point.

> Project note 1: it is incredibly important that you consider the child first
>
> - Intuition is that we want to search more promising parts of the space first, so we can prune less promising parts later.
>
> - e.g. consider E first
>
>     <img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308182040418.png" alt="image-20230308182040418" style="zoom:25%;" />
>
> <img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308183334629.png" alt="image-20230308183334629" style="zoom: 25%;" />

### Nearest Neighbor

<!-- ![K-D Tree](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-16%20at%205.42.50%20PM.png) -->

* Start at the root and compute its distance to the query point, and save that as the minimum distance.
* For each subspace the node partitioned into, try to find a better point by computing the shortest distance between the query point and the edge of the subspace.
* Compute recursively for each subspace which might contains a possibly better point.
* Return the point with the minimum distance.

Pseudocode

<img src="./Range Searching and Multi-Dimensional Data.assets/image-20230308183822908.png" alt="image-20230308183822908" style="zoom:25%;" />







