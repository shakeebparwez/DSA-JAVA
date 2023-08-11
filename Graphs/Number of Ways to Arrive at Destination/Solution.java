// defining the pair class
class Pair
{
    long first;
    int second;
    
    Pair(long first, int second)
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

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        
        // creating the adjacency list representation of the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int m = roads.size();
        
        for(int i = 0; i < m; i++)
        {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(2), roads.get(i).get(1)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(2), roads.get(i).get(0)));
        }
        
        
        // inital configuration
        PriorityQueue<Pair> pq = new PriorityQueue<>(new My());
        
        long dist[] = new long[n];
        int ways[] = new int[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        
        dist[0] = 0;
        ways[0] = 1;
        
        pq.add(new Pair(0,0)); // store (dist, node)
        
        int mod = 1000000007;
        
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            
            long distance = p.first;
            int node = p.second;
            
            for(Pair adjP : adj.get(node))
            {
                int adjacentNode = adjP.second;
                long edgeWeight = adjP.first;
                
                // first time when you get this short distance
                if(distance + edgeWeight < dist[adjacentNode])
                {
                    dist[adjacentNode] = distance + edgeWeight;
                    pq.add(new Pair(distance + edgeWeight, adjacentNode));
                    
                    ways[adjacentNode] = ways[node];
                }
                else if(distance + edgeWeight == dist[adjacentNode]) // second time
                {
                    ways[adjacentNode] = (ways[adjacentNode] + ways[node]) % mod;
                }
            }
        }
        
        return ways[n - 1];
    }
}