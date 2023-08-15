// to sort edges on the basis of weight
class EdgeComparator implements Comparator<int[]> {
    public int compare(int[] edge1, int[] edge2) {
        return Integer.compare(edge1[2], edge2[2]);
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    
	    // sort the edges in increasing order of weight
	    Arrays.sort(edges, new EdgeComparator());
	    
	    // initial setup
	    DisjointSet ds = new DisjointSet(V);
	    
	    int mstWeight = 0;
	    
	    // select the edges one by one with minimum weight
	    for(int i = 0; i < edges.length; i++)
	    {
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        // detect if the vertices are in different components
	        if(ds.findUPar(u) != ds.findUPar(v))
	        {
	            // add the weight if not forming cycle
	            mstWeight += wt;
	            ds.unionBySize(u, v);
	        }
	        
	    }
	    
	    return mstWeight;
	    
	}
}