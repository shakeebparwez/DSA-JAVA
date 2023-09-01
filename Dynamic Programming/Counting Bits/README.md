**Title: Counting Bits**

**Introduction:**
The provided code implements an optimized solution for the "Counting Bits" problem. The problem asks for an array where the value at index i represents the count of 1's in the binary representation of the number i.

**Algorithm:**
The code aims to build an array `dp` where each index `i` stores the count of 1's in the binary representation of the number `i`. The algorithm utilizes an optimized approach to calculate this efficiently.

1. Initialize an array `dp` of size `n + 1` to store the count of 1's for each number from 0 to n.
2. Initialize the first value of the array `dp[0]` to 0, as the number 0 has no set bits.
3. Initialize an `offset` variable to 1. This offset represents the position of the leftmost set bit for each iteration.
4. Iterate through the array from 1 to n (both inclusive):
   - Check if the current index `i` is at a position that is a power of 2 (`2 * offset == i`).
     - If true, update the `offset` to the current value of `i`.
   - Calculate the count of set bits for the current number using the formula `1 + dp[i - offset]`. This means adding 1 for the newly set bit and using the precalculated count for the remaining bits at positions less than the current offset.
   - Store the calculated count in the `dp` array at index `i`.
5. Return the `dp` array, which contains the count of 1's for each number from 0 to n.

**Complexity Analysis:**
- Time Complexity: The code iterates through the range from 1 to n once, performing constant-time operations for each iteration. Hence, the time complexity of the algorithm is O(n).
- Space Complexity: The algorithm uses an array `dp` of size `n + 1` to store the count of 1's for each number. Therefore, the space complexity is O(n).

**Conclusion:**
The provided code efficiently solves the "Counting Bits" problem by calculating the count of 1's in the binary representation of each number from 0 to n. It utilizes a clever approach that optimizes the calculation by leveraging the previously calculated count for specific bit positions. This results in an overall linear time complexity solution.