# Basic Sorts

## Definition of Sorting

An ordering relation < for keys a, b, and c has the following properties:

*   Law of Trichotomy: Exactly one of a < b, a = b, b < a is true.
    
*   Law of Transitivity: If a < b, and b < c, then a < c.

A sort is a permutation (re-arrangement) of a sequence of elements that puts the keys into non-decreasing order relative to a given ordering relation.
In Java, ordering relations are typically given in the form of `compareTo` or `compare` methods.

```java
import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
	public int compare(String x, String b) {
		return x.length() - b.length();
	}
}
```

<img src="./Basic Sorts.assets/image-20230309205636520.png" alt="image-20230309205636520" style="zoom:25%;" />

---

## Performance of Algorithms

The **Time Complexity** of an algorithm is the characterization of its runtime efficiency. Dijkstra’s has time complexity `O(E log V)`.

The **Space Complexity** of an algorithm is the characterization of its **extra** memory usage. Dijkstra’s has space complexity `Θ(V)`.

---

## Selection Sort

### Steps of Selection Sort
* Find the smallest item.
* Swap the item to the front and fix it.
* Repeat for unfixed items until all items are fixed.

### Runtime
`Θ(N^2)` time if an array is used to store the items.

---

## Heap Sort

### Naive

Maintain a max-oriented heap to get the maximum item fast.
* Insert all items into a max heap, and discard input array. Create output array.
* Delete largest item from the max heap.
* Put largest item at the end of the unused part of the output array.

#### Runtime

*  Getting items into the heap `O(N log N)` time.
*  Selecting largest item: `Θ(1)` time.
*  Removing largest item: `O(log N)` for each removal.
The overall runtime is `O(N log N)`.
*  BTW, the memory usage is $\Theta(N)$

### In-Place

Rather than inserting into a new array of length N + 1, use a process known as “bottom-up heapification” to convert the array into a heap. This approach could avoid the need for extra copy of all data.

1. Bottom-up heapification:

    - Sink nodes in reverse level order: sink(k) (K = N-1,N-2,...,0)
    - after sinking, guaranteed that tree rooted at position k is a heap
2. repeat N times:
    - delete largest item from the max heap, swapping root with last item in the heap (and then sink the top item in the heap)

<img src="./Basic Sorts.assets/image-20230309213151934.png" alt="image-20230309213151934" style="zoom:25%;" />

#### Runtime

- The Time Complexity of In-Place Heap Sort is the same as the Naive Heap Sort.

    - Bottom-up heapification: $O(N\log N)$
    - Selection largest item: $\Theta(1)$
    - Removing largest item: $O(\log N)$

    <img src="./Basic Sorts.assets/image-20230309213802274.png" alt="image-20230309213802274" style="zoom: 25%;" />
- The Space Complexity of In-Place Heap Sort is `Θ(1)`. 
    (assumes implemented iteratively, not recursively)

---

## Merge Sort

-   Split items into 2 roughly even pieces.
-   Mergesort each half recursively.
-   Merge the two sorted halves to form the final result.

#### Runtime

- The Time Complexity of Merge Sort is `Θ(N log N)`.
- The Space Complexity of Merge Sort is `Θ(N)`.

---

## Insertion Sort

-   Starting with an empty output sequence.
-   Add each item from input, inserting into output at right point.
-   Perform these steps in place by swapping with previous items.

Example:
```
P O T A T O (0 swap)
O P T A T O (1 swap)
O P T A T O (0 swap)
A O P T T O (3 swaps)
A O P T T O (0 swap)
A O O P T T (3 swaps)
```

On arrays with a small number of inversions, insertion sort is extremely fast.
For small arrays (N < 15 or so), insertion sort is fastest.

#### Runtime

- The best case for insertion sort is `Θ(N)`.
- The worst case of insertion sort is `Θ(N ^ 2)`.

### In-place version

<img src="./Basic Sorts.assets/image-20230309215921348.png" alt="image-20230309215921348" style="zoom:25%;" />

The runtime:

<img src="./Basic Sorts.assets/image-20230312101012998.png" alt="image-20230312101012998" style="zoom:25%;" />

- best case: Theta(N)

- worst case: Theta(N^2)

- insertion sort on almost sorted arrays does little work

    <img src="./Basic Sorts.assets/image-20230312101525648.png" alt="image-20230312101525648" style="zoom:25%;" />

- other spots
  
    <img src="./Basic Sorts.assets/image-20230312102341293.png" alt="image-20230312102341293" style="zoom:25%;" />

---

Sorts so far:

<img src="./Basic Sorts.assets/image-20230312102523982.png" alt="image-20230312102523982" style="zoom:25%;" />











