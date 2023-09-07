class Solution {
    private int solve(int i, int j, int[][] obstacleGrid, int[][] dp) {
        // if the coordinate is valid but that cell has an obstacle then do not count the path by returning 0
        if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1)
        {
            return 0;
        }
        
        // if reached invalid location do not count the path by returning 0
        if(i < 0 || j < 0)
        {
            return 0;
        }

        // if reached the target count the path by returning 1
        if(i == 0 && j == 0)
        {
            return 1;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        // move one level up and get the count of reaching that particular cooridnate
        int up = solve(i - 1, j, obstacleGrid, dp);

        // similarly get the count of reaching the left side of the cell
        int left = solve(i, j - 1, obstacleGrid, dp);

        // both the up and left sum will be the number of ways of reaching the target cell
        dp[i][j] = up + left;

        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;

        // dp array for memoization
        int[][] dp = new int[M][N];

        for(int[] arr : dp)
        {
            Arrays.fill(arr, -1);
        }

        // get the count of unique paths for reaching (m - 1, n - 1) coordinate
        int count_unique_paths = solve(M - 1, N - 1, obstacleGrid, dp);

        return count_unique_paths;
    }
}