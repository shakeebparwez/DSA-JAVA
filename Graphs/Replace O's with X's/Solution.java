class Solution{
    
    static void dfs(int row, int col, char a[][], boolean visited[][], int n, int m)
    {
        visited[row][col] = true;
        
        int deltaRow[] = {-1, 0, +1, 0};
        int deltaCol[] = {0, -1, 0, +1};
        
        for(int i = 0; i < 4; i++)
        {
            int neighbourRow = row + deltaRow[i];
            int neighbourCol = col + deltaCol[i];
            
            if(neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m)
            {
                if(a[neighbourRow][neighbourCol] == 'O' && visited[neighbourRow][neighbourCol] == false)
                {
                    dfs(neighbourRow, neighbourCol, a, visited, n, m);
                }
            }
        }
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        // approach => 
        // traverse the boundary of matrix
        // if there is a 'O' then perform dfs
        // and mark all those 'O's reachable from boundary as true in visited matrix
        // then replace all those 'O's with visited as true with X
        
        // code here
        boolean visited[][] = new boolean[n][m];
        
        for(int j = 0; j < m; j++)
        {
            if(a[0][j] == 'O' && visited[0][j] == false)
            {
                dfs(0, j, a, visited, n, m);
            }
            
            if(a[n - 1][j] == 'O' && visited[n - 1][j] == false)
            {
                dfs(n - 1, j, a, visited, n, m);
            }
        }
        
        for(int i = 1; i < n - 1; i++)
        {
            if(a[i][0] == 'O' && visited[i][0] == false)
            {
                dfs(i, 0, a, visited, n, m);
            }
            
            if(a[i][m - 1] == 'O' && visited[i][m - 1] == false)
            {
                dfs(i, m - 1, a, visited, n, m);
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(a[i][j] == 'O' && visited[i][j] == false)
                {
                    a[i][j] = 'X';
                }
            }
        }
        
        return a;
    }
}