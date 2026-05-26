# Detailed Notes: Sorting and Searching

## 1. Overview

Sorting means arranging elements in a particular order, usually ascending or descending.

Searching means finding whether a value exists in a collection, and if yes, where it exists.

These are two of the most important topics in data structures and algorithms because:
- sorting makes data easier to process
- searching becomes faster on sorted data
- many real-world programs depend on both

---

## 2. Why Sorting and Searching Matter

- Sorting helps in:
  - finding duplicates
  - ranking data
  - preparing data for binary search
  - improving readability and processing
- Searching helps in:
  - finding a student record
  - locating a number in an array
  - checking if an item exists
  - fast lookup in applications

---

## 3. Types of Sorting

Sorting algorithms are commonly divided into:

- Comparison-based sorting
  - bubble sort
  - selection sort
  - insertion sort
  - merge sort
  - quick sort
  - heap sort
- Non-comparison sorting
  - counting sort
  - radix sort
  - bucket sort

---

## 4. Important Sorting Terms

- Stable sort
  - keeps equal elements in the same relative order
- Unstable sort
  - may change the relative order of equal elements
- In-place sort
  - uses very little extra memory
- Out-of-place sort
  - uses extra memory

---

## 5. Bubble Sort

Bubble sort compares adjacent elements and swaps them if they are in the wrong order.

### Idea
- compare neighboring values
- move the largest value to the end in each pass
- repeat until sorted

### Diagram

```text
Array:  5   1   4   2   8

Pass 1:
5   1   4   2   8
|---|
1   5   4   2   8
    |---|
1   4   5   2   8
        |---|
1   4   2   5   8
            |---|
1   4   2   5   8
```

After first pass, the largest element is at the end.

### Time Complexity
- best case: O(n) if already sorted
- average case: O(n^2)
- worst case: O(n^2)

### Space Complexity
- O(1)

### Use
- educational purpose
- very small datasets

---

## 6. Selection Sort

Selection sort selects the smallest element from the unsorted part and places it at the beginning.

### Idea
- divide array into sorted and unsorted parts
- find minimum from unsorted part
- swap with first unsorted position

### Diagram

```text
Array:  64   25   12   22   11

Step 1:
find minimum = 11
11   25   12   22   64

Step 2:
find minimum in remaining part = 12
11   12   25   22   64

Step 3:
11   12   22   25   64
```

### Time Complexity
- best case: O(n^2)
- average case: O(n^2)
- worst case: O(n^2)

### Space Complexity
- O(1)

### Use
- when swaps should be minimized
- small arrays

---

## 7. Insertion Sort

Insertion sort builds the sorted array one element at a time.

### Idea
- take one element
- insert it into the correct position in the sorted part
- repeat

### Diagram

```text
Array:  9   5   1   4   3

Step 1:
9

Step 2:
5   9

Step 3:
1   5   9

Step 4:
1   4   5   9

Step 5:
1   3   4   5   9
```

### Time Complexity
- best case: O(n) if nearly sorted
- average case: O(n^2)
- worst case: O(n^2)

### Space Complexity
- O(1)

### Use
- good for small or nearly sorted arrays

---

## 8. Merge Sort

Merge sort follows the divide and conquer approach.

### Idea
- divide the array into halves
- sort each half recursively
- merge the sorted halves

### Diagram

```text
Original:
8   3   2   9   7   1   5   4

Divide:
8   3   2   9       7   1   5   4
8   3     2   9     7   1     5   4
8   3  2  9  7  1  5  4

Merge:
3   8     2   9     1   7     4   5
2   3   8   9     1   4   5   7
1   2   3   4   5   7   8   9
```

### Merge Process Diagram

```text
Left sorted:   1   4   7
Right sorted:  2   3   6

Merged:
1   2   3   4   6   7
```

### Time Complexity
- best case: O(n log n)
- average case: O(n log n)
- worst case: O(n log n)

### Space Complexity
- O(n)

### Use
- stable sorting
- useful for large datasets
- good when predictable O(n log n) time is needed

---

## 9. Quick Sort

Quick sort also uses divide and conquer.

### Idea
- choose a pivot
- place smaller values on left
- place larger values on right
- recursively sort both parts

### Diagram

```text
Array:  10   7   8   9   1   5
Pivot = 5

Partition:
1   5   10   7   8   9

Then sort left and right parts:
1   5   7   8   9   10
```

### Partition Diagram

```text
[ 8   3   1   7   0   10   2 ]

Pivot = 2

Smaller than pivot: 1, 0
Equal to pivot: 2
Greater than pivot: 8, 3, 7, 10

Result after partition:
1   0   2   8   3   7   10
```

### Time Complexity
- best case: O(n log n)
- average case: O(n log n)
- worst case: O(n^2)

### Space Complexity
- O(log n) average for recursion
- O(n) worst case

### Use
- very fast in practice
- commonly used in interviews and applications

---

## 10. Counting Sort

Counting sort is a non-comparison sort.

### Idea
- count frequency of each value
- reconstruct the sorted array from counts

### Diagram

```text
Array:  4   2   2   8   3   3   1

Count:
1 -> 1
2 -> 2
3 -> 2
4 -> 1
8 -> 1

Sorted:
1   2   2   3   3   4   8
```

### Time Complexity
- O(n + k)
  - n = number of elements
  - k = range of values

### Space Complexity
- O(k)

### Use
- when values are in a limited range
- very efficient for integers

---

## 11. Searching

Searching means finding an element in a collection.

Main types:
- linear search
- binary search

---

## 12. Linear Search

Linear search checks each element one by one.

### Idea
- start from the first element
- compare with target
- stop when found or array ends

### Diagram

```text
Array:  12   35   7   19   4
Target: 19

Check 12 -> no
Check 35 -> no
Check 7  -> no
Check 19 -> yes
```

### Time Complexity
- best case: O(1)
- average case: O(n)
- worst case: O(n)

### Space Complexity
- O(1)

### Use
- unsorted arrays
- small datasets

---

## 13. Binary Search

Binary search works only on sorted arrays.

### Idea
- find middle element
- compare with target
- if target is smaller, search left half
- if target is larger, search right half

### Diagram

```text
Sorted Array:
2   5   8   12   16   23   38   56   72   91

Target = 23

Step 1:
middle = 16
23 > 16, go right

Step 2:
23   38   56   72   91
middle = 56
23 < 56, go left

Step 3:
23   38
middle = 23
found
```

### Interval Shrinking Diagram

```text
[ 2   5   8   12   16   23   38   56   72   91 ]
              mid

If target is smaller:
[ 2   5   8   12   16 ]

If target is larger:
                      [ 23   38   56   72   91 ]
```

### Time Complexity
- best case: O(1)
- average case: O(log n)
- worst case: O(log n)

### Space Complexity
- O(1) iterative
- O(log n) recursive because of call stack

### Use
- sorted arrays
- very fast searching

---

## 14. Binary Search Conditions

Binary search works only when:
- the array is sorted
- the list supports random access
- comparisons can be made directly

Binary search does not work well on:
- unsorted arrays
- linked lists without efficient middle access

---

## 15. Sorting vs Searching

- Sorting arranges data
- Searching finds data

Relation:
- sorting often helps searching become faster
- binary search requires sorted data
- unsorted data usually uses linear search

---

## 16. Comparison of Sorting Algorithms

- Bubble sort
  - simple
  - slow
- Selection sort
  - simple
  - fewer swaps
- Insertion sort
  - good for nearly sorted arrays
- Merge sort
  - stable
  - O(n log n)
- Quick sort
  - fast in practice
  - worst case O(n^2)
- Counting sort
  - very fast for limited integer range

---

## 17. Comparison of Searching Algorithms

- Linear search
  - works on unsorted data
  - simple but slow
- Binary search
  - works on sorted data only
  - much faster

---

## 18. Common Mistakes

- using binary search on unsorted data
- forgetting to update low and high correctly in binary search
- comparing wrong indices in sorting
- ignoring boundary conditions
- using expensive sorting when a simpler method is enough

---

## 19. Java Example Idea

### Linear Search Example
```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

### Binary Search Example
```java
public static int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}
```

---

## 20. Final Summary

- Sorting organizes data.
- Searching finds data.
- Linear search works on any array but is slow.
- Binary search is fast but needs sorted data.
- Merge sort gives stable O(n log n) performance.
- Quick sort is fast in practice.
- Insertion sort is good for small or nearly sorted arrays.
- Counting sort is excellent for limited integer ranges.

---

If you want, I can turn this into:
- a shorter classroom note
- an exam revision sheet
- a Java-focused version with code for every algorithm