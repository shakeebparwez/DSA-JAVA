**Title: Remove Duplicates from Sorted Array**

**Introduction:**
The provided code addresses the task of removing duplicates from a sorted array in-place and returning the new length of the array containing distinct elements.

**Algorithm:**
The algorithm utilizes two pointers, `i` and `j`, to traverse the sorted array and replace duplicate elements with distinct elements.

1. **Initialization:**
   - Initialize two pointers, `i` and `j`, both initially set to `0`.
   - The pointer `i` will represent the position of the last distinct element encountered.

2. **Traversal and Replacement:**
   - Begin traversing the array using the pointer `j`.
   - For each element `nums[j]`:
     - If the element at `nums[i]` is different from `nums[j]` (indicating a distinct element), increment `i` by `1` and update `nums[i]` with the value of `nums[j]`.
     - Continue incrementing `j` to move through the array.

3. **Result:**
   - After traversing the entire array, the pointer `i` will indicate the index of the last distinct element.
   - The length of the new array containing distinct elements is `i + 1`.

**Explanation:**
By comparing adjacent elements, the algorithm identifies duplicates and replaces them with distinct elements. The pointer `i` ensures that the distinct elements are positioned correctly in the array. The algorithm modifies the input array in-place, creating a new array with only the unique elements.

**Complexity Analysis:**
- Time Complexity: The algorithm iterates through the array once, with each operation taking constant time. Thus, the time complexity is O(N), where N is the length of the array.
- Space Complexity: The algorithm modifies the array in-place without requiring additional memory, resulting in a space complexity of O(1).

**Conclusion:**
The provided code offers an efficient solution to the problem of removing duplicates from a sorted array while preserving the original order of the distinct elements. By using two pointers to identify and replace duplicates, the algorithm ensures an in-place transformation and a linear time complexity.