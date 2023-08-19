class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        // declare disjoint set data structure
        DisjointSet ds = new DisjointSet(V);
        
        // create the edges in dijoint set data structure
        for(int i = 0; i < V; i++)
        {
            for(int j = 0; j < V; j++)
            {
                if(adj.get(i).get(j) ==  1)
                {
                    ds.unionBySize(i, j);
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < V; i++)
        {
            // if the ultimate parent is same as the vertex itself it is one component
            if(ds.findUPar(i) == i)
            {
                count++;
            }
        }
        
        return count;
    }
};