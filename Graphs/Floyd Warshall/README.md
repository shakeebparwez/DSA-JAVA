**Title: Floyd-Warshall Algorithm for All-Pairs Shortest Paths**

**Introduction:**
This code implements the Floyd-Warshall algorithm, which computes the shortest paths between all pairs of nodes in a graph, including negative-weight edges. It is based on the concept of dynamic programming and uses matrix operations.

**Components:**

1. **Solution Class:**
   - Contains the main logic for the Floyd-Warshall algorithm.
   - Replaces `-1` values with large positive values and performs matrix updates to find shortest paths.

**Algorithm Overview:**

1. **Initialization:**
   - Replace `-1` values with a large positive value (`1e8`) to represent infinity.

2. **Floyd-Warshall Algorithm:**
   - Iterate through all nodes `via` (an intermediate node) to find the shortest paths.
     - Update the cost matrix by considering paths through `via`.
     - Use matrix multiplication-like operation: `matrix[i][j] = min(matrix[i][j], matrix[i][via] + matrix[via][j])`.

3. **Negative Cycle Check:**
   - After the algorithm completes, check for negative cycles by scanning the diagonal of the cost matrix.
     - If any value on the diagonal is negative, a negative cycle exists.

4. **Result:**
   - Replace positive infinity (`1e8`) with `-1` in the cost matrix for readability.

**Revised Code Summary:**

1. Define the `Solution` class.

2. Implement the `shortest_distance` method with parameter `matrix`.
   - Replace `-1` values with positive infinity.
   - Perform the Floyd-Warshall algorithm to find shortest paths.
   - Check for negative cycles.
   - Replace positive infinity with `-1` for readability.

**Conclusion:**
The provided code effectively implements the Floyd-Warshall algorithm to find the shortest paths between all pairs of nodes in a graph, including negative-weight edges. It replaces initial `-1` values with positive infinity and performs matrix operations to find the shortest paths. The algorithm also includes a negative cycle check and finalizes the cost matrix for display.