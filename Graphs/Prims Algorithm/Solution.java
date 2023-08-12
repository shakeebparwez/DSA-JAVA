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

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    
	    // first creating the adjacency list from edges representation
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
	    for(int i = 0; i < V; i++)
	    {
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i = 0; i < edges.length; i++)
	    {
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(u).add(new Pair(wt, v));
	        adj.get(v).add(new Pair(wt, u));
	    }
	    
	    // initial configuration
	    PriorityQueue<Pair> pq = new PriorityQueue<>(new My());
	    
	    int visited[] = new int[V];
	    Arrays.fill(visited, 0);
	    
	    pq.add(new Pair(0, 0));
	    int sum = 0;
	    
	    while(!pq.isEmpty())
	    {
	        Pair p = pq.poll(); // take out the minimum weight node
	        
	        int weight = p.first;
	        int node = p.second;
	        
	        // if the node taken out is visited then skip the iteration
	        if(visited[node] == 1)
	        {
	            continue;
	        }
	        
	        // else add it to the mst
	        visited[node] = 1;
	        sum = sum + weight;
	        
	        for(Pair adjP : adj.get(node)) // add the unvisited adjacent nodes to priority queue
	        {
	            int edgeWeight = adjP.first;
	            int adjacentNode = adjP.second;
	            
	            if(visited[adjacentNode] == 0)
	            {
	                pq.add(new Pair(edgeWeight, adjacentNode));
	            }
	        }
	    }
	    
	    return sum;
	}
}
