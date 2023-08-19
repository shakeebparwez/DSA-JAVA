class Solution {

    public int Solve(int V, int[][] edge) {
        // Code here
        
        // declare disjoint set data structure
        DisjointSet ds = new DisjointSet(V);
        
        int countExtras = 0;
        
        for(int i = 0; i < edge.length; i++)
        {
            int u = edge[i][0];
            int v = edge[i][1];
            
            // if the parents are same then that edge is just an extra because it is part of one component only    
            if(ds.findUPar(u) == ds.findUPar(v))
            {
                countExtras++;
            }
            else
            {
                // else add it into the disjoint set and include as one component
                ds.unionBySize(u, v);
            }
        }
        
        int countComponents = 0;
        
        // for counting number of components
        for(int i = 0; i < V; i++)
        {
            // it is a component if the ultimate parent is same as the node
            if(ds.findUPar(i) == i)
            {
                countComponents++;
            }
        }
        
        // to connect n components you need n - edges
        if(countExtras >= countComponents - 1)
        {
            return countComponents - 1;
        }
        else // if not possible return -1
        {
            return -1;
        }
    }
}