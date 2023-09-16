class Solution{
    static int solve(int i, int target, int arr[], int dp[][])
    {
        // when array is finished and target has been reached then return 1 else return 0
        if(i < 0)
        {
            if(target == 0) return 1;
            else return 0;
        }
        
        if(dp[i][target] != -1) return dp[i][target];
        
        // if the given element is not picked in subset then reduce the array index but target will remain same
        int notPick = solve(i - 1, target, arr, dp);
        
        // if the given array element is less than the target and can be picked
        int pick = 0;
        
        if(arr[i] <= target)
        {
            // reduce the array index and update the target as well
            pick = solve(i - 1, target - arr[i], arr, dp);
        }
        
        // if either of pick or not pick gives true then return true else return false
        if(pick == 1 || notPick == 1) dp[i][target] = 1;
        else dp[i][target] = 0;
        
        return dp[i][target];
    }
    
    static int equalPartition(int N, int arr[])
    {
        // code here
        
        // find sum of array elements
        int sum = 0;
        
        for(int val : arr) sum += val;
        
        // if sum is odd it is not possible to partition into two parts
        if(sum % 2 == 1) return 0;
        
        // else find if a subset with half of total sum exists
        int target = sum / 2;
        
        // dp configuration
        int dp[][] = new int[N][target + 1];
        
        for(int array[] : dp) Arrays.fill(array, -1);
        
        // pass the last index and target sum to achieve
        return solve(N - 1, target, arr, dp);
    }
}