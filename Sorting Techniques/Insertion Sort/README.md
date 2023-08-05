# Insertion Sort Algorithm

Insertion Sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as Quick Sort, Merge Sort, or Heap Sort. However, it performs well for small lists or lists that are already mostly sorted.

## Algorithm Steps

1. Start from the second element (index 1) and consider it as an element to be inserted into the sorted portion.
2. Compare the element with the elements in the sorted portion (left of the current element).
3. Shift all the elements in the sorted portion that are greater than the current element one position to the right.
4. Insert the current element into its correct position in the sorted portion.
5. Move to the next element and repeat steps 2-4 until all elements are sorted.

## Java Implementation

```java
class InsertionSort {
    static void insert(int arr[], int i) {
        int j = i - 1;
        int ele = arr[j + 1];

        while (j > -1 && arr[j] > ele) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = ele;
    }

    public void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            insert(arr, i);
        }
    }
}
```

## Time Complexity

- Average and Worst Case: O(n^2) where n is the number of elements in the array. It involves nested loops and requires shifting elements.
- Best Case (when the array is already sorted): O(n), as each element only needs to be compared with the previous elements.

## Properties

- Adaptive: Yes, it performs better when the array is partially sorted.
- Stable: Yes, the relative order of equal elements is maintained.

Insertion Sort is suitable for small datasets or when the array is almost sorted, but for larger datasets, more efficient algorithms are preferred. While it might not be the fastest sorting algorithm, it's relatively easy to understand and implement, making it useful for educational purposes and for situations where simplicity and stability are important.