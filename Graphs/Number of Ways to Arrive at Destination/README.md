**Title: Number of Ways to Arrive at Destination using Dijkstra's Algorithm**

**Introduction:**
This code solves the problem of finding the number of ways to arrive at the destination node from the starting node in a graph, considering edge weights. It also counts the ways to reach each node while ensuring the shortest path.

**Components:**

1. **Pair Class:**
   - A class to store pairs of a long integer and an integer.
   - Contains a constructor to initialize the pair.

2. **Comparator Class (My):**
   - Implements the `Comparator` interface to define custom ordering for pairs based on long integer values.

3. **Solution Class:**
   - Contains the main logic for finding the number of ways to arrive at the destination.
   - Utilizes Dijkstra's algorithm with modifications to count ways.

**Algorithm Overview:**

1. **Initialization:**
   - Create an adjacency list representation (`adj`) of the graph.
   - Initialize a priority queue (`pq`) with custom comparator.
   - Create arrays for distances (`dist`) and ways (`ways`), both initialized with maximum values and zeros respectively, except for the starting node.

2. **Dijkstra's Algorithm:**
   - While the priority queue is not empty, dequeue a pair.
   - For each adjacent pair:
     - Calculate new distance.
     - If the new distance is smaller than the existing distance, update distance and ways.
     - If the new distance is the same as the existing distance, update ways.
     - Enqueue adjacent nodes with updated distance.

3. **Result:**
   - Return the number of ways to arrive at the destination node.

**Revised Code Summary:**

1. Import necessary packages.

2. Define the `Pair` class.

3. Define the `My` class to implement the comparator.

4. Define the `Solution` class:
   - Implement the `countPaths` method with parameters `n` and `roads`.
   - Initialize adjacency list (`adj`), priority queue (`pq`), distance array (`dist`), and ways array (`ways`).
   - Implement Dijkstra's algorithm with way counting:
     - Update ways if new distance is smaller.
     - Update ways if new distance is the same.
   - Return the number of ways to arrive at the destination.

**Conclusion:**
The provided code effectively solves the problem of finding the number of ways to arrive at the destination node while considering edge weights in a graph using Dijkstra's algorithm. It ensures that the shortest path is maintained and calculates the number of ways to reach each node.