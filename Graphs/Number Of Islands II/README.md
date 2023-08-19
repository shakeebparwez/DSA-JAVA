**Title: Number of Islands II**

**Introduction:**
The provided code aims to track the number of islands formed after each land addition in a grid. It uses the Disjoint Set data structure to efficiently handle the merging of islands and maintain the count of islands during the process.

**Number of Islands II Algorithm:**

1. **Solution Class:**
   - Implements the `numOfIslands` function to calculate the number of islands after each land addition in the grid.
   
2. **Initialization:**
   - Initializes a `DisjointSet` instance `ds` with the total number of cells in the grid (rows * cols).
   - Initializes a 2D boolean array `visited` to keep track of visited cells.
   - Initializes a `count` variable to track the current number of islands.
   - Initializes an `ans` list to store the counts of islands after each operation.

3. **Iterating Over Operations:**
   - Iterates through each operation provided in the `operators` array.
   - Retrieves the row and column of the current operation.
   
4. **Checking Visited Cells:**
   - If the cell corresponding to the current operation is already visited, adds the current `count` to the `ans` list and continues to the next iteration.
   - Otherwise, marks the current cell as visited and increments the `count` to represent a new island.

5. **Checking Surrounding Cells:**
   - Defines delta arrays `deltaRow` and `deltaCol` to calculate adjacent cell coordinates.
   - Iterates through the four possible directions (up, right, down, left) to check the surrounding cells.
   - Calculates the coordinates of the adjacent cell (`adjacentRow` and `adjacentCol`).
   
6. **Merging Islands:**
   - Checks if the adjacent cell is within the grid bounds and is also marked as land (visited).
   - If the conditions are met, calculates the node numbers of the current cell and adjacent cell using the formula `row * cols + col`.
   - Checks whether the ultimate parents of the two cells are the same (belong to the same island).
     - If not, performs a union by size operation between the two cells using the `unionBySize` method of the Disjoint Set `ds`.
     - Decreases the `count` as the two independent islands have merged.

7. **Adding Island Count to Answer:**
   - Adds the current `count` value to the `ans` list after processing each operation.

8. **Returning Answer:**
   - Returns the `ans` list containing the counts of islands after each operation.

**Explanation:**
The code uses the Disjoint Set data structure to efficiently handle the addition of land cells and the merging of islands. It tracks visited cells, counts the number of islands after each operation, and merges adjacent islands if land cells are connected. The resulting list `ans` contains the counts of islands after each land addition operation.

**Conclusion:**
The provided code is effective in calculating the number of islands after each land addition operation in a grid. It leverages the Disjoint Set data structure to efficiently manage the merging process and maintains the count of islands. The code successfully handles the addition of land cells and maintains an updated count of islands, providing insights into the island formation process over time.