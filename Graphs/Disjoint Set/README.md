**Title: Disjoint Set Data Structures [Union by Rank and Union by Size]**

**Introduction:**
This code implements two variations of the Disjoint Set data structure: Union by Rank and Union by Size. These data structures are used to efficiently manage disjoint sets and perform union-find operations.

**Components:**

1. **DisjointSet Class:**
   - Implements the disjoint set data structure.
   - Contains methods for initializing, finding ultimate parents, and performing unions using both Union by Rank and Union by Size approaches.

2. **Main Class:**
   - Contains the main method to demonstrate the usage of the DisjointSet class.
   - Demonstrates the functionality of both Union by Rank and Union by Size approaches.

**Disjoint Set:**

- **Initialization:**
  - Initializes `rank`, `parent`, and `size` lists for each element in the disjoint set.
  - Each element is initially its own parent, and the rank and size are set to 0 or 1.

- **Find Ultimate Parent (`findUPar`):**
  - Implements path compression to find the ultimate parent of a given element.
  - Uses recursion to traverse up the hierarchy until the ultimate parent is reached.
  - Updates parent pointers during traversal to optimize future find operations.

- **Union by Rank (`unionByRank`):**
  - Combines two disjoint sets by connecting the ultimate parents of the elements.
  - Uses rank to optimize the union operation:
    - Connects the smaller rank set to the larger rank set.
    - If ranks are equal, connects one set and increments the rank of the other set.
    - Performs path compression while connecting.

- **Union by Size (`unionBySize`):**
  - Combines two disjoint sets by connecting the ultimate parents of the elements.
  - Uses size to optimize the union operation:
    - Connects the smaller size set to the larger size set.
    - Updates the size of the larger size set.
    - Performs path compression while connecting.

**Main Class:**

- Demonstrates the usage of both Union by Rank and Union by Size approaches.
- Initializes a DisjointSet instance with a specified number of elements.
- Performs union operations and finds ultimate parents for different elements.
- Prints whether two elements are in the same set or not.

**Conclusion:**
The provided code effectively implements both the Union by Rank and Union by Size variations of the Disjoint Set data structure. It demonstrates how to initialize disjoint sets, find ultimate parents, and perform union operations using these approaches. The code showcases the optimized nature of these data structures for maintaining disjoint sets and efficiently performing union-find operations.