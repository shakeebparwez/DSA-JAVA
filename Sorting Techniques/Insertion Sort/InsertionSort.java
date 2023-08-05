class InsertionSort {
    static void insert(int arr[], int i) {
        // Your code here
        int j = i - 1; // size of sorted array
        int ele = arr[j + 1]; // element to be inserted

        while (j > -1 && arr[j] > ele) // find place to be inserted
        {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = ele; // insert
    }

    // Function to sort the array using insertion sort algorithm.
    public void insertionSort(int arr[], int n) {
        // code here
        for (int i = 1; i < n; i++) {
            insert(arr, i); // take initial array of 1 element and then insert all other elements one by one
                            // in sorted order
        }
    }
}

// Time Complexity: O(n^2) [Reverse sorted], O(n) [Normally sorted]
// Properties: Adaptive, Stable