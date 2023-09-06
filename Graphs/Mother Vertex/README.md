The provided Java code is used to find a "Mother Vertex" in a directed graph. A mother vertex is a vertex from which we can reach all other vertices in the graph.

Here's how the code works:

1. It uses a depth-first search (DFS) approach to traverse the graph.

2. The `dfs` function performs a depth-first search starting from a given `node`. It marks the `node` as visited and recursively explores all its adjacent nodes.

3. During the DFS traversal, it pushes the visited nodes into a stack `stk`. The idea is to put the nodes in topological order so that the minimum value node comes on top.

4. After the initial DFS traversal, it checks the top node in the stack. This node can potentially be a mother vertex. To confirm, it clears the stack, resets the `visited` array, and performs another DFS traversal starting from this node.

5. If all nodes are visited during the second DFS traversal, it means that this node can reach all other nodes, making it a mother vertex. In this case, it returns the node as the result.

6. If there are any unvisited nodes after the second DFS traversal, it returns -1, indicating that there is no mother vertex in the graph.

Overall, this code efficiently finds a mother vertex in a directed graph by using two DFS traversals to verify the condition that a mother vertex must be able to reach all other vertices in the graph.