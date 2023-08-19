class Solution {
    
    public int MaxConnection(int grid[][]) {
        //Your code here
        int N = grid.length;
        
        // creating disjoint set data structure
        DisjointSet ds = new DisjointSet(N * N);
        
        // initializing the disjoint set configutation
        for(int row = 0; row < N; row++)
        {
            for(int col = 0; col < N; col++)
            {
                // find the cells having 1
                if(grid[row][col] == 0)
                {
                    continue;
                }
                
                // including the surrounding ones within one parent component disjoint set
                int deltaRow[] = {-1, 0, 1, 0};
                int deltaCol[] = {0, -1, 0, 1};
                
                for(int i = 0; i < 4; i++)
                {
                    int newRow = row + deltaRow[i];
                    int newCol = col + deltaCol[i];
                    
                    if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && grid[newRow][newCol] == 1)
                    {
                        // finding the node number for (row, col) using the formula => row * number of cols + col
                        int nodeNumber = row * N + col;
                        int adjacentNodeNumber = newRow * N + newCol;
                        
                        ds.unionBySize(nodeNumber, adjacentNodeNumber);
                    }
                }
            }
        }
        
        // start flipping the 0's to 1's and count the largest groups of ones
        int max = 0;
        
        for(int row = 0; row < N; row++)
        {
            for(int col = 0; col < N; col++)
            {
                // find the cells having 0
                if(grid[row][col] == 1)
                {
                    continue;
                }
                
                // checking components of 1's to connect with in surrounding
                int deltaRow[] = {-1, 0, 1, 0};
                int deltaCol[] = {0, -1, 0, 1};
                
                // to store the parent of each component found
                HashSet<Integer> components = new HashSet<>();
                
                for(int i = 0; i < 4; i++)
                {
                    int newRow = row + deltaRow[i];
                    int newCol = col + deltaCol[i];
                    
                    // adding the parent of each component in the hashset in order to prevent repetitive addition of size of same component again
                    
                    if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && grid[newRow][newCol] == 1)
                    {
                        components.add(ds.findUPar(newRow * N + newCol));
                    }
                }
                
                int sizeTotal = 0;
                
                // adding the size of components of 1's found
                for(int parents : components)
                {
                    sizeTotal += ds.size.get(parents);   
                }
                
                // getting the maximum ones in one single combined component by flipping a zero
                max = Math.max(max, sizeTotal + 1);
            }
        }
        
        // if the max doesn't change that means there were no zero found and hence all the cells are simply ones
        if(max == 0)
        {
            // return size of matrix in this case
            return N * N;
        }
        else
        {
            return max;
        }
    }
    
}