# More Quick Sort, Sorting Summary

## Worst Case of Quicksort

There are four philosophies to avoid the worst case of Quicksort.

<img src="./MoreQuickSort and SortingSummary.assets/image-20230312124337718.png" alt="image-20230312124337718" style="zoom:25%;" />

### Randomness

The worst cases do happen in practice:
* Bad ordering: Array already in sorted order.
* Bad elements: Array with all duplicates. 

Dealing with bad ordering:
-   Strategy #1: Pick pivots randomly.
-   Strategy #2: Shuffle before sorting.

### Smarter Pivot Selection

#### Constant Time

For any pivot selection procedure that is deterministic and costs constant time, there is a family of dangerous inputs that an adversary could easily generate.

>  constant time pivot is what java does

#### Linear Time

Exact median Quicksort is safe: Worst case `Θ(N log N)`, but it is slower than Mergesort.

The method to find the exact median is called the Quick Select.

### Introspection

If Quicksort exceeds some critical value (such as 10 ln N), switch to Mergesort.

### Preprocess

Could analyze array to see if Quicksort will be slow. No obvious way to do this, though.

---



## Quicksort v.s. Mergesort

### Quicksort Flavors

Using this scheme (L3S) yields a Quicksort algorithm that is slower than the Mergesort.

* Pivot selection: Always use leftmost.
* Partition algorithm: Make an array copy then do three scans for red, white, and blue items (white scan trivially finishes in one compare).
* Shuffle before starting to avoid worst case.


### Tony Hoare’s In-place Partitioning Scheme

Using this partitioning scheme (LTHS) yields a very fast Quicksort.

* Left pointer loves small items. (smaller than the pivot)
* Right pointer loves large items. (greater than the pivot)
* Big idea: Walk towards each other, swapping anything they don’t like.

    - when they both encounter something they don't like, they swap, and L++, G--
    - (L do not like items greater than or equals to pivot)
    - (G do not like items less than or equals to pivot)

    <img src="./MoreQuickSort and SortingSummary.assets/image-20230312195616158.png" alt="image-20230312195616158" style="zoom:25%;" />
* End result is that things on left are “small” and things on the right are “large”.

    <img src="./MoreQuickSort and SortingSummary.assets/image-20230312195713572.png" alt="image-20230312195713572" style="zoom:25%;" />

    at last swap the item that G pointing to and the pivot (the beginning item)

More recent pivot/partitioning schemes do somewhat better. The best known Quicksort uses a two-pivot scheme.

---



## Quick Select

Computing the exact median would be great for picking an item to partition around, which could avoid the worst case of Quicksort. However, computing that exact median is inefficient.

However, partitioning can be used to find the exact median, which results in the median identification algorithm.

### Performance

On average, Quick Select will take `Θ(N)` time.

The worst case runtime is `Θ(N ^ 2)` when the array is in sorted order.

However, the Quicksort algorithm with Quick Select to find the exact median is quite slow.

<img src="./MoreQuickSort and SortingSummary.assets/image-20230312202908691.png" alt="image-20230312202908691" style="zoom: 50%;" />

---



## Stability, Adaptiveness, Optimization

### Stability

A sort is said to be stable if order of equivalent items is preserved. 

For example, if an array is sorted by name and then sorted by grades, the relative order of name is preserved if the sorting algorithm is stable.

* Stable: Mergesort and Insertion Sort
* Unstable: Heapsort and Quicksort

    > actually, whether the quick sort is stable, it depends on the partitioning strategy

<img src="./MoreQuickSort and SortingSummary.assets/image-20230312204012715.png" alt="image-20230312204012715" style="zoom:25%;" />

### Optimization

* Switch to insertion sort when a subproblem reaches size 15 or lower.
* Make sort adaptive.
* Exploit restrictions on set of keys.
* For Quicksort, make the algorithm introspective, switching to a different sorting method if recursion goes too deep.

### Arrays.sort

In Java, `Arrays.sort(someArray)` uses:

* Mergesort (specifically the TimSort variant) if `someArray` consists of Objects.
* Quicksort if `someArray` consists of primitives.
