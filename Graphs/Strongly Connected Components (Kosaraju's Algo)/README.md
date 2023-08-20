**Title: Strongly Connected Components using Kosaraju's Algorithm**

**Introduction:**
The provided code implements Kosaraju's algorithm to find the number of strongly connected components (SCCs) in a given directed graph. Kosaraju's algorithm is a two-pass algorithm that first sorts the nodes based on their finishing times using Depth First Search (DFS) and then performs DFS on the reversed graph to count the SCCs.

**Kosaraju's Algorithm Steps:**

1. **Solution Class:**
   - Implements the `kosaraju` function to find the number of strongly connected components in the graph.

2. **DFS to Sort:**
   - Implements the `dfsToSort` function to perform DFS on the graph and store nodes in a stack based on their finishing times.
   - Marks the node as visited.
   - Iterates through each adjacent node and recursively calls `dfsToSort` if the adjacent node is not visited.

3. **DFS on Reversed Graph:**
   - Implements the `dfs` function to perform DFS on the reversed graph.
   - Marks the node as visited.
   - Iterates through each adjacent node in the reversed graph and recursively calls `dfs` if the adjacent node is not visited.

4. **Kosaraju's Algorithm:**
   - Initializes a boolean array `visited` to keep track of visited nodes.
   - Initializes an empty stack `stk` to store nodes based on their finishing times.

5. **DFS for Sorting:**
   - Performs DFS on the graph using the `dfsToSort` function for nodes that are not visited.
   - Pushes nodes onto the stack in the order of their finishing times.

6. **Reversing the Graph:**
   - Initializes a new array list `adjReverse` to represent the reversed graph.
   - Fills the `adjReverse` list with empty ArrayLists.
   - Initializes the `visited` array again to mark nodes as unvisited.
   - Iterates through each node and its adjacent nodes in the original graph, adding edges to the `adjReverse` list.

7. **DFS to Count SCCs:**
   - Initializes a variable `scc_count` to count the number of SCCs.
   - While the stack is not empty, pops nodes from the stack.
   - If the node is not visited, increments `scc_count` and performs DFS on the reversed graph using the `dfs` function.

8. **Returning SCC Count:**
   - Returns the final count of strongly connected components.

**Explanation:**
The code effectively applies Kosaraju's algorithm to find the number of strongly connected components in a directed graph. The algorithm involves sorting the nodes based on their finishing times and then performing DFS on the reversed graph to count the SCCs. By utilizing DFS and stack operations, the code accurately calculates the number of SCCs in the graph.

**Conclusion:**
The provided code successfully implements Kosaraju's algorithm to find the number of strongly connected components in a directed graph. By following the steps of the algorithm, including sorting nodes based on finishing times and performing DFS on the reversed graph, the code determines the count of SCCs. The result provides insights into the structural connectivity of the graph.