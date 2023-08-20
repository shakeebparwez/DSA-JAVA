class Solution
{
    private void dfsToSort(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk)
    {
        visited[node] = true;
        
        for(Integer adjacentNode : adj.get(node))
        {
            if(visited[adjacentNode] == false)
            {
                dfsToSort(adjacentNode, visited, adj, stk);
            }
        }
        
        stk.push(node); // store the first finishing node so that it be last while doing the dfs again on the reverse graph
    }
    
    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjReverse)
    {
        visited[node] = true;
        
        for(Integer adjacentNode : adjReverse.get(node))
        {
            if(visited[adjacentNode] == false)
            {
                dfs(adjacentNode, visited, adjReverse);
            }
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        
        // strongly connected components algorithm
        
        // step 1
        // sort all the edges according to finishing time
        
        boolean[] visited = new boolean[V];
        
        Stack<Integer> stk = new Stack<>();
        
        // perform dfs on the graph
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == false)
            {
                dfsToSort(i, visited, adj, stk);
            }
        }
        
        // step 2
        // reverse the graph
        
        ArrayList<ArrayList<Integer>> adjReverse = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
        {
            adjReverse.add(new ArrayList<>());
        }
        
        Arrays.fill(visited, false);
        
        for(int node = 0; node < V; node++)
        {
            for(int adjacentNode : adj.get(node))
            {
                adjReverse.get(adjacentNode).add(node);
            }
        }
        
        // step 3
        // do a dfs
        int scc_count = 0;
        
        while(!stk.isEmpty())
        {
            int node = stk.pop();
            
            if(visited[node] == false)
            {
                scc_count++;
                dfs(node, visited, adjReverse);
            }
        }
        
        return scc_count;
    }
}
