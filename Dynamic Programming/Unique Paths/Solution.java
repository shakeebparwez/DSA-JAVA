class Solution {
    private int solve(int i, int j, int[][] dp) {
        // if reached the target count the path by returning 1
        if(i == 0 && j == 0)
        {
            return 1;
        }

        // if reached invalid location do not count the path by returning 0
        if(i < 0 || j < 0)
        {
            return 0;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }

        // move one level up and get the count of reaching that particular cooridnate
        int up = solve(i - 1, j, dp);

        // similarly get the count of reaching the left side of the cell
        int left = solve(i, j - 1, dp);

        // both the up and left sum will be the number of ways of reaching the target cell
        dp[i][j] = up + left;

        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        // dp array for memoization
        int[][] dp = new int[m][n];

        for(int[] arr : dp)
        {
            Arrays.fill(arr, -1);
        }
        
        // get the count of unique paths for reaching (m - 1, n - 1) coordinate
        int count_of_paths = solve(m - 1, n - 1, dp);
        
        return count_of_paths;
    }
}