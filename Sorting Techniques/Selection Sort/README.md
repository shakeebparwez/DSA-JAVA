# Selection Sort Algorithm

Selection Sort is a simple sorting algorithm that sorts an array by repeatedly finding the minimum element from the unsorted part of the array and putting it at the beginning. This is done by swapping the found minimum element with the first element of the unsorted portion. Selection Sort divides the array into two parts: the sorted part and the unsorted part. 

## Algorithm Steps

1. Find the minimum element in the unsorted part of the array.
2. Swap the minimum element with the first element of the unsorted part.
3. Move the boundary between the sorted and unsorted parts one element to the right.
4. Repeat steps 1-3 until the entire array is sorted.

## Java Implementation

```java
class SelectionSort {
    int select(int arr[], int i) {
        int j = i;
        int k = i;

        while (j < arr.length) {
            if (arr[j] < arr[k]) {
                k = j;
            }
            j++;
        }

        return k;
    }

    void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int small = select(arr, i);

            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }
    }
}
```

## Time Complexity

- Average and Worst Case: O(n^2) where n is the number of elements in the array. Since it involves nested loops, the number of comparisons and swaps can be quite large.
- Best Case: O(n^2), as the algorithm doesn't take advantage of any existing order.

## Properties

- Adaptive: No, it doesn't perform better when the array is partially sorted.
- Stable: No, the relative order of equal elements might change.

Selection Sort is not efficient for large datasets, and it performs slower compared to more advanced sorting algorithms like Quick Sort, Merge Sort, or Heap Sort. Despite its simplicity, it's mainly used for educational purposes and understanding sorting algorithms. Its primary advantage is that it requires only a small number of swaps, which can be important for memory-constrained systems.