class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        // create a 2d array list
        List<List<Integer>> adj = new ArrayList<>();
        
        // add a empty array list corresponding to each vertex from 0 to V - 1
        for(int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        // traverse the edges and add the corresponding vertices to the arraylist of given vertex and make it both directions as it is a undirected graph
        for(int i = 0; i < edges.length; i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        return adj;
    }
}