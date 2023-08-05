# Bubble Sort Algorithm

Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. It is not the most efficient sorting algorithm but can be useful for small datasets or as a learning exercise due to its simplicity.

## Algorithm Steps

1. Start with the first element (index 0) and compare it with the next element (index 1).
2. If the first element is greater than the second element, swap them.
3. Move to the next pair of elements (index 1 and index 2), and repeat step 2.
4. Continue this process for the entire array, moving from left to right. After the first pass, the largest element will be in its correct position at the end of the array.
5. Repeat the process for the remaining elements (excluding the last sorted element) until the entire array is sorted. With each pass, the next largest element will bubble up to its correct position.
6. If no swaps are made in a pass, the array is already sorted, and the algorithm can terminate early.

## Java Implementation

```java
class BubbleSort {
    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n; i++) { // number of passes
            boolean flag = false;

            for (int j = 0; j < n - 1 - i; j++) { // iterate through unsorted portion
                if (arr[j] > arr[j + 1]) { // if the current element is greater than the next element
                    // swap them
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true; // a swap occurred
                }
            }

            if (!flag) { // no swap happened, array is already sorted
                break;
            }
        }
    }
}
```

## Time Complexity

- Average and Worst Case: O(n^2) where n is the number of elements in the array.
- Best Case (when the array is already sorted): O(n), as the algorithm performs a pass without any swaps.

## Properties

- Adaptive: Yes, it performs better when the array is partially sorted.
- Stable: Yes, it maintains the relative order of equal elements.

Bubble Sort is not recommended for large datasets due to its relatively poor performance compared to more efficient algorithms like Quick Sort, Merge Sort, or Heap Sort. However, it serves as a good introductory example of a sorting algorithm and can help build a foundation for understanding more complex sorting techniques.