class Solution
{
    //Function to return Breadth First Traversal of given graph.
    private int time = 0;
    
    private void dfs(int node, int parent, boolean[] visited, int[] discovery, int[] low, boolean[] articulationPoint, ArrayList<ArrayList<Integer>> adj)
    {
        // mark the node as visited
        visited[node] = true;
        
        // time stamp the discovery and low array with time value
        discovery[node] = time;
        low[node] = time;
        
        // then increment the time
        time++;
        
        // to check for the starting node if it is having more than 2 child then obviously it is a articulation point
        int child = 0;
        
        // traverse the adjacent nodes
        for(int adjacentNode : adj.get(node))
        {
            // if the adjacent node is parent then skip the iteration
            if(adjacentNode == parent)
            {
                continue;
            }
            
            // if the adjacent node is unvisited then start dfs on that
            if(visited[adjacentNode] == false)
            {
                dfs(adjacentNode, node, visited, discovery, low, articulationPoint, adj);
                
                // while returning update the lowest accessible time for the node
                low[node] = Math.min(low[node], low[adjacentNode]);
                
                // check for articulation point
                // if the adjacent node has a higher lowest accessible time node with it or even same as that of the discovery time for the node to be checked for articulation point
                if(low[adjacentNode] >= discovery[node] && parent != -1)
                {
                    // this condition is not applicable for parent node
                    // we will check for parent based on number of childs
                    
                    // a higher accessible time means that the adjacent node is connected throught the given node to the other components and there is not any other way around to reach
                    articulationPoint[node] = true;
                }
                
                // if dfs is performed then there is a child count increment
                child++;
            }
            else
            {
                // if the adjacent node is visited then we update the low of the node based on the discovery time of the adjacent node   
                low[node] = Math.min(low[node], discovery[adjacentNode]);
            }
        }
        
        // if it is a parent with more than one child then it is also a articulation point
        if(child > 1 && parent == -1)
        {
            articulationPoint[node] = true;
        }
    }
    
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        
        boolean[] visited = new boolean[V];
        
        // store the time of insertion during dfs
        int[] discovery = new int[V];
        
        // store the minimum accessible time of all adjacent nodes apart from parent and visited nodes
        int[] low = new int[V];
        
        // nodes on whose removal the graph breaks into multiple components
        boolean[] articulationPoint = new boolean[V];
        
        // start dfs traversal
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == false)
            {
                dfs(i, -1, visited, discovery, low, articulationPoint, adj);
            }
        }
        
        // store the found articulation points during the traversal in the answer arraylist
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
        {
            if(articulationPoint[i] == true)
            {
                ans.add(i);
            }
        }
        
        // if no articulation point is found then add -1
        if(ans.size() == 0)
        {
            ans.add(-1);
        }
        
        return ans;
    }
}