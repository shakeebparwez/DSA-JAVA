// defining a pair class
class Pair 
{
    int first;
    int second;
    
    Pair(int first, int second) 
    {
        this.first = first;
        this.second = second;
    }
}

// defining a comparator for the min heap configuration of priority queue
class My implements Comparator<Pair>
{
    public int compare(Pair p1, Pair p2) // compares p2 (new) with p1 (old)
    {
        if(p1.first > p2.first) return 1; // if the p2.first is smaller make it on top
        else if(p1.first < p2.first) return -1; // else keep it below
        else return 0; // in case of equality do nothing
    }
}

class Solution 
{
    public static List<Integer> shortestPath(int n, int m, int edges[][]) 
    {
        // code here
        
        // creating the adjacency list representation of the given graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) 
        {
            adj.add(new ArrayList<>());
        }
        
        
        for(int i = 0; i < m; i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        
        // creating the priority queue with min heap configuration
        PriorityQueue<Pair> pQueue = new PriorityQueue<>(new My());
        
        int dist[] = new int[n + 1]; // distance of every vertex from given source
        int parent[] = new int[n + 1]; // array to trace back the path
        
        // initial configuration
        for(int i = 1; i <= n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        
        dist[1] = 0; // 1 is the source
        pQueue.add(new Pair(0, 1)); // pairs are stored in the form of (dist, node)
        
        while(!pQueue.isEmpty()) // iterate for all the pairs in priority queue
        {
            Pair p = pQueue.poll();
            
            int distance = p.first;
            int node = p.second;
            
            for(Pair it : adj.get(node))
            {
                int adjacentNode = it.first;
                int edgeWeight = it.second;
                
                if(distance + edgeWeight < dist[adjacentNode]) // if you can reach the adjacent node in lesser distance then its existing distance
                {
                    dist[adjacentNode] = distance + edgeWeight; // update the shorter distance
                    pQueue.add(new Pair(distance + edgeWeight, adjacentNode)); // add this updated (dist, node) pair
                    parent[adjacentNode] = node; // keep track of the parent of this adjacent node
                }
            }
        }
        
        // declare the path array
        List<Integer> path = new ArrayList<>();
        
        // if the destination can't be reached return -1
        if(dist[n] == Integer.MAX_VALUE)
        {
            path.add(-1);
            return path;
        }
        else
        {
            int dest = n;
            
            while(parent[dest] != dest) // trace back the path from parent array
            {
                path.add(dest);
                dest = parent[dest];
            }
            
            path.add(1);
            Collections.reverse(path); // reverse the list to get actual path
            
            return path;
        }
    }
}