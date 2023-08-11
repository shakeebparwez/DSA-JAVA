class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int dist[] = new int[V];
        
        Arrays.fill(dist, (int)1e8);
        
        dist[S] = 0;
        
        // O(V * E)
        
        // since in a graph of n nodes, in worst case, you will take n - 1 edges to reach from the first to the last, thereby we iterate for n - 1 iterations
        for(int i = 0; i < V - 1; i++)
        {
            for(ArrayList<Integer> edge : edges)
            {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                
                if(dist[u] != 1e8 && dist[u] + wt < dist[v])
                {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        
        // nth relaxation to check negative cycle
        for(ArrayList<Integer> edge : edges)
        {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
                
            if(dist[u] != 1e8 && dist[u] + wt < dist[v])
            {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        
        return dist;
    }
}