**Title: Prim's Algorithm for Minimum Spanning Tree**

**Introduction:**
This code implements Prim's algorithm to find the minimum spanning tree (MST) of a given graph. The algorithm starts with an initial node, repeatedly adds the minimum-weight edge connecting the MST to an unvisited node, and constructs the MST.

**Components:**

1. **Pair Class:**
   - Defines a simple pair with two values (`first` and `second`).

2. **Solution Class:**
   - Contains the main logic for finding the MST using Prim's algorithm.
   - Utilizes a priority queue to efficiently select the next edge to add to the MST.

**Algorithm Overview:**

1. **Initialization:**
   - Create an adjacency list representation (`adj`) of the graph from the given edges.
   - Initialize a priority queue (`pq`) with a custom comparator (`My`) that prioritizes edges with smaller weights.

2. **Prim's Algorithm:**
   - Initialize an array `visited` to keep track of visited nodes and set all values to `0`.
   - Add an initial node to the priority queue with weight `0`.
   - Iterate while the priority queue is not empty:
     - Poll the priority queue to get the edge with the minimum weight.
     - If the destination node of the edge is already visited, skip the iteration.
     - Otherwise, mark the destination node as visited, add the weight to the MST sum (`sum`), and explore its adjacent unvisited nodes.
       - Add the adjacent unvisited nodes with their weights to the priority queue.

3. **Result:**
   - Return the sum of weights of the edges in the MST (`sum`).

**Revised Code Summary:**

1. Define the `Pair` class.

2. Define the `Solution` class.

3. Implement the `spanningTree` method with parameters `V`, `E`, and `edges`.
   - Create the adjacency list representation of the graph.
   - Initialize the priority queue with the custom comparator.
   - Initialize the `visited` array and `sum`.
   - Perform Prim's algorithm to find the MST sum.
   - Return the `sum`.

**Conclusion:**
The provided code effectively implements Prim's algorithm to find the minimum spanning tree of a given graph. It utilizes a priority queue to select the minimum-weight edges and constructs the MST by exploring adjacent unvisited nodes. The algorithm returns the sum of weights of the edges in the minimum spanning tree.