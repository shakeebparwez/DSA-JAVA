class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        
        // creating disjoint set data structure
        DisjointSet ds = new DisjointSet(rows * cols);
        
        // initial configuration
        boolean[][] visited = new boolean[rows][cols];
        
        int count = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        // starting iterating over operations
        for(int i = 0; i < operators.length; i++)
        {
            int row = operators[i][0];
            int col = operators[i][1];
            
            // if already the query is visited skip the iteration
            if(visited[row][col] == true)
            {
                ans.add(count);
                continue;
            }
            
            // else mark the given coordinate as land
            visited[row][col] = true;
            
            // first increase the component count
            count++;
            
            // now check the surrounding region that if it can be merged into another component
            int deltaRow[] = {-1, 0, 1, 0};
            int deltaCol[] = {0, 1, 0, -1};
            
            for(int j = 0; j < 4; j++)
            {
                // finding the coordinate of surrounding cells
                int adjacentRow = row + deltaRow[j];
                int adjacentCol = col + deltaCol[j];
                
                // checking if it is a valid cell coordinate and whether is a land or not by using visited array
                if(adjacentRow < rows && adjacentRow >= 0 && adjacentCol >= 0 && adjacentCol < cols && visited[adjacentRow][adjacentCol] == true)
                {
                    // finding the cell number of a node(row, col) by using the formula => row * no of cols  + col
                    int nodeNumber = row * cols + col;
                    int adjacentNodeNumber = adjacentRow * cols + adjacentCol;
                    
                    // if the component ultimate parents are not same
                    if(ds.findUPar(nodeNumber) != ds.findUPar(adjacentNodeNumber))
                    {
                        // decrease the count of independent components
                        count--;
                        
                        // and attach the component to an existing component
                        ds.unionBySize(nodeNumber, adjacentNodeNumber);
                    }
                }
            }
            
            ans.add(count);
        }
        
        return ans;
    }
    
}