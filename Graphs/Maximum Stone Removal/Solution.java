class Solution {

    int maxRemove(int[][] stones, int n) {
        // Code here
        
        // finding the dimenstions to initialize the disjoint set data structure
        int maxRow = 0;
        int maxCol = 0;
        
        for(int i = 0; i < n; i++)
        {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow + 1 + maxCol + 1);
        
        // we just need the nodes in disjoint set which are involved in having a stone
        // so we store the rows and columns in set as they will have stones
        // and we just need to count them once for ultimate parents
        
        HashSet<Integer> stoneNodes = new HashSet<>();
        
        for(int i = 0; i < n; i++)
        {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            
            // forming components of stones sharing row and column
            ds.unionBySize(nodeRow, nodeCol);
            
            // adding these rows and columns node containing stones
            stoneNodes.add(nodeRow);
            stoneNodes.add(nodeCol);
        }
        
        int count = 0;
        
        // iterating the nodes containing stones
        for(int node : stoneNodes)
        {
            // if the ultimate parent is same then it can be counted as one component
            if(ds.findUPar(node) == node)
            {
                count++;
            }
        }
        
        // safe removal will be => number of stones - number of components
        // derivation
        // from every component having n stones we can remove n - 1 stones satisfying the given condition
        // "A stone can be removed if it shares either the same row or the same column as another stone that has not been removed."
        
        return n - count;
    }
};
