# Heaps and PQs

## Priority Queue Interface

The abstract data type "priority queue" could be used to find the smallest or largest element quickly instead of searching through the whole tree. There can be memory benefits to using this data structure.

```java
/** (Min) Priority Queue: Allowing tracking and removal of 
  * the smallest item in a priority queue. */
public interface MinPQ<Item> {
    /** Adds the item to the priority queue. */
    public void add(Item x);
    /** Returns the smallest item in the priority queue. */
    public Item getSmallest();
    /** Removes the smallest item from the priority queue. */
    public Item removeSmallest();
    /** Returns the size of the priority queue. */
    public int size();
}
```

## Binary min-heapa

<img src="./Heaps and PQs.assets/image-20230301095414716.png" alt="image-20230301095414716" style="zoom:25%;" />

<img src="./Heaps and PQs.assets/image-20230301095622454.png" alt="image-20230301095622454" style="zoom:25%;" />

<img src="./Heaps and PQs.assets/image-20230301095907769.png" alt="image-20230301095907769" style="zoom:25%;" />

### add and removeLast

<img src="./Heaps and PQs.assets/image-20230301100931629.png" alt="image-20230301100931629" style="zoom:25%;" />

---

## Tree Representation

There are many approaches to represent trees.

### Approach 1a, 1b, and 1c

Create mappings between nodes and their children.

```java
public class Tree1A<Key> {
  Key k;
  Tree1A left;
  Tree1A middle;
  Tree1A right;
  ...
}
```

<!-- ![Tree1A](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-09%20at%209.54.04%20PM.png "Tree1A") -->

<img src="./Heaps and PQs.assets/image-20230301101521461.png" alt="image-20230301101521461" style="zoom:25%;" />

```java
public class Tree1B<Key> {
  Key k;
  Tree1B[] children;
  ...
}
```

<!-- ![Tree1B](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-09%20at%2010.03.15%20PM.png "Tree1B") -->

<img src="./Heaps and PQs.assets/image-20230301101628683.png" alt="image-20230301101628683" style="zoom:25%;" />

```java
public class Tree1C<Key> {
  Key k;
  Tree1C favoredChild;
  Tree1C sibling;
  ...
}
```

<!-- ![Tree1C](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-09%20at%2010.08.44%20PM.png "Tree1C") -->

<img src="./Heaps and PQs.assets/image-20230301101736969.png" alt="image-20230301101736969" style="zoom:25%;" />

### Approach 2

Store the keys array as well as a parents array.

```java
public class Tree2<Key> {
  Key[] keys;
  int[] parents;
  ...
}
```

<!-- ![Tree2](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-09%20at%2010.15.11%20PM.png "Tree2") -->

<img src="./Heaps and PQs.assets/image-20230301102125164.png" alt="image-20230301102125164" style="zoom:25%;" />

### Approach 3

Assume that our tree is complete: So the `parents[]` is determinate

```java
public class Tree3<Key> {
  Key[] keys;
  ...
}
```

<!--![Tree3](https://joshhug.gitbooks.io/hug61b/content/assets/Screen%20Shot%202019-03-09%20at%2010.26.05%20PM.png "Tree3") -->

<img src="./Heaps and PQs.assets/image-20230301102354563.png" alt="image-20230301102354563" style="zoom:25%;" />

swim to the proper position:
```java
public void swim(int k) {
    if (keys[parent(k)].compareTo(keys[k]) > 0) {
        swap(k, parent(k));
        swim(parent(k));
    }
}

private int parent(int k) {
    return (k - 1) / 2;			// -1 / 2 == 0. it's ok.
}

private void swap(int p, int q) {
    K tmp = keys[p];
    keys[p] = keys[q];
    keys[q] = tmp;
}
```

### Approach 3b

Comparing to approach 3, approach 3b offset everything by 1 spot

<img src="./Heaps and PQs.assets/image-20230301110045700.png" alt="image-20230301110045700" style="zoom:25%;" />

### Comparing to alternative implemenations

<img src="./Heaps and PQs.assets/image-20230301110400610.png" alt="image-20230301110400610" style="zoom:25%;" />

- Heap operations are **amortized** analysis, since the array will have to resize (not a big deal)
- BST's can have constant time `getSmallest` if pointer is stored to smallest element
- Array-based heaps take around 1/3rd the memory it takes to represent a heap using approach 1A (direct pointers to children)

---

## Implementation

### Heap Structure

Binary min-heap has the following properties:

* Min-heap: Every node is less than or equal to both of its children.
* Complete: Missing items only at the bottom level (if any), all nodes are as far left as possible.

![Heap](https://joshhug.gitbooks.io/hug61b/content/assets/heap-13.2.1.png "Heap")

The `Tree3` could be used to implement the heap structure. Leave one empty spot at the beginning to simplify computation. 

* `leftChild(k)` = k * 2
* `rightChild(k)` = k * 2 + 1
* `parent(k)` = k / 2

### Heap Operations

* `add`: Add to the end of heap temporarily. Swim up the hierarchy to the proper place. (Swimming involves swapping nodes if child < parent)
* `getSmallest`: Return the root of the heap.
* `removeSmallest`: Swap the last item in the heap into the root. Sink down the hierarchy to the proper place.

Here's the code of swim operation:

```java
public void swim(int k) {
    if (keys[parent(k)] ≻ keys[k]) {
       swap(k, parent(k));
       swim(parent(k));              
    }
}
```

### Runtime

Ordered Array

* `add`: ` Θ(N)`
* `getSmallest`: ` Θ(1)`
* `removeSmallest`: ` Θ(N)`

Bushy BST

* `add`: ` Θ(log N)`
* `getSmallest`: ` Θ(log N)`
* `removeSmallest`: ` Θ(log N)`

HashTable

* `add`: ` Θ(1)`
* `getSmallest`: ` Θ(N)`
* `removeSmallest`: ` Θ(N)`

Heap Structure

* `add`: ` Θ(log N)`
* `getSmallest`: ` Θ(1)`
* `removeSmallest`: ` Θ(log N)`

---

## Data structure summary

<img src="./Heaps and PQs.assets/image-20230301112029938.png" alt="image-20230301112029938" style="zoom:25%;" />

<img src="./Heaps and PQs.assets/image-20230301112110978.png" alt="image-20230301112110978" style="zoom: 25%;" />

<img src="./Heaps and PQs.assets/image-20230301112235206.png" alt="image-20230301112235206" style="zoom:25%;" />



