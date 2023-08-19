**Title: Connecting the Graph with Minimum Edges**

**Introduction:**
The provided code aims to determine the minimum number of extra edges needed to connect all components of a graph. It utilizes the Disjoint Set data structure to establish connections and count the components. The code then calculates the minimum number of extra edges required to connect all components together.

**Components:**

1. **Solution Class:**
   - Implements the `Solve` function to calculate the minimum number of extra edges required to connect all components of the graph.

2. **Solve Function:**
   - Takes the number of vertices (`V`) and a 2D array `edge` representing the edges between vertices.
   - Initializes a `DisjointSet` instance with `V` vertices.
   - Initializes `countExtras` to keep track of the number of extra edges needed.
   - Iterates through each edge and checks whether both vertices have the same ultimate parent (belong to the same component) using `findUPar` method.
   - If the vertices have the same parent, it increments `countExtras`, as the edge is not required to connect different components.
   - If the vertices have different parents, it calls the `unionBySize` method to connect them.

3. **Count Components:**
   - Initializes `countComponents` to count the number of components.
   - Loops through all vertices (0 to `V - 1`).
   - If the ultimate parent of a vertex is itself (`findUPar(i) == i`), it indicates that the vertex is the representative of its component. Increment `countComponents`.

4. **Calculate Minimum Edges:**
   - If the number of extra edges is greater than or equal to the number of components minus 1 (`countExtras >= countComponents - 1`), it means that the graph can be connected with `countComponents - 1` edges.
   - Returns `countComponents - 1` as the minimum number of extra edges needed to connect all components.
   - If it's not possible to connect all components with the given extra edges, returns `-1`.

**Explanation:**
The code uses the Disjoint Set data structure to determine the minimum number of extra edges required to connect all components of a graph. It checks whether each edge is needed to connect different components or not. After processing all edges, it calculates the number of components and extra edges. If there are enough extra edges to connect all components, it returns the minimum number of edges required. Otherwise, it returns `-1` to indicate that it's not possible to connect all components with the given edges.

**Conclusion:**
The provided code is effective in calculating the minimum number of extra edges required to connect all components of a graph. It utilizes the Disjoint Set data structure to efficiently establish connections and count components. The code is capable of determining whether it's possible to connect all components with the given extra edges and returns the appropriate result accordingly.