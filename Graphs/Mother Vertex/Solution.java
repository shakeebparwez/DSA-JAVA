class Solution
{
    //Function to find a Mother Vertex in the Graph.
    private void dfs(int node, ArrayList<ArrayList<Integer>>adj, boolean[] visited, Stack<Integer> stk)
    {
        visited[node] = true;
        
        for(int adjacentNode : adj.get(node))
        {
            if(visited[adjacentNode] == false)
            {
                dfs(adjacentNode, adj, visited, stk);
            }
        }
        
        // on returning put the node into stack
        stk.push(node);
    }
    
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        // visited array to keep track of visited elements
        boolean[] visited = new boolean[V];
        
        // stack to form a topological ordering
        Stack<Integer> stk = new Stack<>();
        
        // perform dfs starting from node 0 till all nodes are marked visited so that minimum value node comes on top
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == false)
            {
                dfs(i, adj, visited, stk);
            }
        }
        
        // the topmost element can be the mother vertex but we need to check so perform one more dfs traversal starting from that node
        int node = stk.pop();
        stk.clear();
        
        Arrays.fill(visited, false);
        
        dfs(node, adj, visited, stk);
        
        // if all nodes are not visited then return -1
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == false)
            {
                return -1;
            }
        }
        
        return node;
    }
}
