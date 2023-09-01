**Title: Search in a Binary Search Tree**

**Introduction:**
The provided code defines a solution for searching a value in a Binary Search Tree (BST). The Binary Search Tree is a binary tree data structure where the left subtree of a node contains values less than the node's value, and the right subtree contains values greater than the node's value.

**Algorithm:**
The algorithm for searching a value in a Binary Search Tree (BST) is implemented using an iterative approach. The steps of the algorithm are as follows:

1. Initialize a temporary TreeNode called `temp` and set it to the root of the BST.

2. Use a while loop to perform the search:
   - Check if `temp` is not null.
   - If the value of the current `temp` node (`temp.val`) is equal to the target `val`, it means the value has been found in the BST. In this case, return the `temp` node, which represents the node containing the target value.
   - If `temp.val` is less than the target `val`, it means the target value may be in the right subtree of the current `temp` node. Therefore, update `temp` to `temp.right` to move to the right child.
   - If `temp.val` is greater than the target `val`, it means the target value may be in the left subtree of the current `temp` node. Therefore, update `temp` to `temp.left` to move to the left child.

3. If the while loop exits without finding the target value, return `null` to indicate that the value was not found in the BST.

**Complexity Analysis:**
- Time Complexity: The time complexity of this algorithm is O(h), where h is the height of the BST. In the worst case, when the BST is skewed, the height is n (the number of nodes), resulting in a time complexity of O(n). In the average case, when the BST is balanced, the height is logarithmic, resulting in a time complexity of O(log n).
- Space Complexity: The space complexity is O(1) since the algorithm uses a constant amount of extra space for the `temp` variable and does not use additional data structures.

**Conclusion:**
The provided code offers a solution for searching a value in a Binary Search Tree (BST) using an iterative approach. It efficiently traverses the BST based on the value comparison at each step, ultimately returning the node containing the target value if found or `null` if the value is not present in the BST.