**Title: Kruskal's Algorithm for Minimum Spanning Tree**

**Introduction:**
Kruskal's algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) of a connected, undirected graph. It aims to find the subset of edges that forms a tree connecting all the vertices with the minimum total edge weight.

**Components:**

1. **EdgeComparator Class:**
   - Implements the `Comparator` interface to define a custom comparator for sorting edges based on their weights.
   - Used to sort the edges in ascending order of weights.

2. **Solution Class:**
   - Implements Kruskal's algorithm to find the Minimum Spanning Tree.
   - Uses the `EdgeComparator` to sort the edges by weight before processing.

**Kruskal's Algorithm:**

- **Sort Edges:**
  - Sorts the given edges in ascending order of their weights using the custom `EdgeComparator`.

- **Initialization:**
  - Initializes a `DisjointSet` instance with `V` vertices.

- **Iterate Through Edges:**
  - Iterates through the sorted edges one by one.
  - For each edge `(u, v, wt)`:
    - Checks if the vertices `u` and `v` are in different components using `findUPar` method.
    - If they are not in the same component, adds the weight `wt` to the MST and performs a union using `unionBySize` method to connect the vertices.

- **Return MST Weight:**
  - Returns the total weight of the Minimum Spanning Tree.

**Conclusion:**
The provided code effectively implements Kruskal's algorithm to find the Minimum Spanning Tree of a given graph. It demonstrates the process of sorting edges by weight, initializing the disjoint set, and iteratively selecting edges to form the MST. The algorithm ensures that no cycles are formed while adding edges, resulting in a tree connecting all vertices with the minimum possible total weight.