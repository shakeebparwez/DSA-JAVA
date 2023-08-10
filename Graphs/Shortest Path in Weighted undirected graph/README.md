**Title: Dijkstra's Algorithm for Shortest Path in Java**

**Introduction:**
This code implements Dijkstra's algorithm to find the shortest path in an undirected graph. The algorithm calculates the shortest distance from a given source node to all other nodes and also constructs the shortest path for each node.

**Components:**

1. **Pair Class:**
   - A simple class to hold pairs of integers, representing nodes and distances.
   - Contains a constructor to initialize the pair.

2. **Comparator Class (My):**
   - Implements the `Comparator` interface to define custom ordering for pairs.
   - Compares pairs based on the distance (first element) in ascending order.

3. **Solution Class:**
   - Contains the main logic for finding the shortest path.
   - Implements Dijkstra's algorithm using a min heap (`PriorityQueue`) to efficiently manage nodes by their distances.

**Algorithm Overview:**

1. **Graph Representation:**
   - The graph is represented using an adjacency list (`adj`) where each node has a list of adjacent nodes with their corresponding edge weights.

2. **Priority Queue:**
   - A min heap (`pQueue`) is used to manage nodes based on their distances from the source node.

3. **Initialization:**
   - Initializes distance and parent arrays.
   - Sets the distance of the source node to 0 and adds it to the priority queue.

4. **Dijkstra's Algorithm:**
   - While the priority queue is not empty, extract the node with the shortest distance.
   - For each adjacent node, update the distance if a shorter path is found.
   - Update the parent and add the updated pair to the priority queue.

5. **Path Construction:**
   - If the destination node is unreachable (distance remains `Integer.MAX_VALUE`), return `-1`.
   - Otherwise, construct the shortest path by tracing back from the destination node using the parent array.

**Revised Code Summary:**

1. Import necessary packages.

2. Define the `Pair` class.

3. Define the `My` class to implement the comparator.

4. Define the `Solution` class:
   - Implement the `shortestPath` method with parameters `n`, `m`, and `edges`.
   - Create the adjacency list representation (`adj`) of the graph.
   - Initialize distance and parent arrays.
   - Set distance of source node to 0 and add to priority queue.
   - Apply Dijkstra's algorithm using priority queue:
     - Extract the node with the shortest distance.
     - Update distances for adjacent nodes if a shorter path is found.
     - Update parent and add updated pairs to priority queue.
   - Construct the shortest path using parent array:
     - If destination is unreachable, return `[-1]`.
     - Otherwise, trace back path and reverse it for correct order.

**Conclusion:**
The provided code implements Dijkstra's algorithm to find the shortest path in a graph efficiently. It uses a min heap priority queue for optimal node selection and distance updates. The algorithm provides a way to find the shortest path from a source node to all other nodes in the graph, along with constructing the actual path for each node.