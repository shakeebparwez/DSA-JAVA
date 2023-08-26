**Title: Sort Colors**

**Introduction:**
The provided code aims to sort an array of integers containing three distinct elements: `0`, `1`, and `2`. The goal is to arrange the array in such a way that all occurrences of `0` appear before all occurrences of `1`, which in turn appear before all occurrences of `2`.

**Algorithm:**
The algorithm uses a two-pointer approach to partition the array into three segments while sorting the elements in-place.

1. **Initialization:**
   - Initialize three pointers: `low`, `mid`, and `high`, all initially set to `0`, to keep track of the segments.
   - `low` represents the rightmost boundary of `0`s segment.
   - `mid` represents the rightmost boundary of `1`s segment.
   - `high` represents the leftmost boundary of `2`s segment.

2. **Partitioning:**
   - Iterate through the array using the `mid` pointer until it reaches or crosses the `high` pointer.
   - For each element at `nums[mid]`:
     - If `0` is encountered, swap the element with the element at `nums[low]`, and increment both `mid` and `low`.
     - If `1` is encountered, only increment `mid` since elements with `1` are already in the right place.
     - If `2` is encountered, swap the element with the element at `nums[high]`, and decrement only the `high` pointer (not `mid`).

3. **Traversal:**
   - Continue this process until `mid` crosses or meets `high`.

**Explanation:**
The algorithm effectively partitions the array into three segments based on the values `0`, `1`, and `2`. As it iterates through the array, the pointers `low`, `mid`, and `high` ensure that the `0`s are placed before the `1`s and the `1`s are placed before the `2`s. Swapping elements with `0` and `2` pointers and incrementing or decrementing them as needed ensures that the array is sorted as required.

**Complexity Analysis:**
- Time Complexity: The algorithm traverses the array exactly once, performing a constant number of operations for each element. Thus, the time complexity is O(N), where N is the length of the array.
- Space Complexity: The algorithm sorts the array in-place without using any additional data structures, resulting in a space complexity of O(1).

**Conclusion:**
The provided code offers an efficient solution for sorting an array with three distinct elements. By partitioning the array into segments and swapping elements as needed, the algorithm achieves the desired sorting order while minimizing the number of operations and ensuring a linear time complexity.