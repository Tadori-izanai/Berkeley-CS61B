# Quick Sort

## Partitoning

To partition an array a[] on element x = a[i] is to rearrange a[] so that:
- x moves to position j. (probably the same as i)
- All entries to the left of x are <= x.
- All entries to the right of x are >= x.

<img src="./Quick Sort.assets/image-20230312104529524.png" alt="image-20230312104529524" style="zoom:25%;" />

##  Partiton Sort (a.k.a Quick Sort)

Quicksorting N items:
-   Partition on leftmost item.
-   Quicksort left half.
-   Quicksort right half.
For most common situations, Quick Sort is empirically the fastest sort.

<img src="./Quick Sort.assets/image-20230312111753836.png" alt="image-20230312111753836" style="zoom:25%;" />

### Runtime

Best Case: Pivot Always Lands in the Middle.

Runtime for the best case: `Θ(N log N)`.

Worst Case: Pivot Always Lands at Beginning of Array.

Runtime for the worst case: `Θ(N ^ 2)`.

The average runtime is `Θ(N log N)`.

<img src="./Quick Sort.assets/image-20230312112121883.png" alt="image-20230312112121883" style="zoom:25%;" />

- call stack uses $\Theta (N)$. Exclude this, it takes constant memory

### Performance

The performance of Quick Sort depend critically on:
-   How the pivot is selected.
-   How the partition is performed around that pivot.
-   Other optimizations.

The rare worst case will happen when:
-   Bad ordering: Array already in sorted order or almost sorted order.
-   Bad elements: Array with all duplicates.

Methods to avoid the worst case:
-   Always use the median as the pivot.
-   Randomly swap two indices occasionally.
-   Shuffle before sorting.
-   Partition from the center of the array.







