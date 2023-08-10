// defining pair class
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

// defining a tuple class
class Tuple
{
    int first;
    int second;
    int third;
    
    Tuple(int first, int second, int third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        // creating adjacency list representation of the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int m = flights.length;
        
        for(int i = 0; i < m; i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        // initial configuration
        Queue<Tuple> q = new LinkedList<>();
        
        q.add(new Tuple(0, src, 0));
        
        int costs[] = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        
        costs[src] = 0;
        
        while(!q.isEmpty())
        {
            Tuple t = q.poll();
            
            int stops = t.first;
            int node = t.second;
            int cost = t.third;
            
            if(stops > k) // skip if max stops reached
            {
                continue;
            }
            
            for(Pair p : adj.get(node)) // traverse the adjacent node
            {
                int adjacentNode = p.first;
                int edgeWeight = p.second;
                
                if(cost + edgeWeight < costs[adjacentNode] && stops <= k) // update the costs if its small but also at the time stops should be within the limits
                {
                    costs[adjacentNode] = cost + edgeWeight; // updating the minimal costs
                    q.add(new Tuple(stops + 1, adjacentNode, cost + edgeWeight)); // insert the adjacent node into queue
                }
            }
        }
        
        if(costs[dst] == Integer.MAX_VALUE) // if the destination is unreachable
        {
            return -1;
        }
        else
        {
            return costs[dst];
        }
        
    }
}
