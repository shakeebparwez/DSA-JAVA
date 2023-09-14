class Solution{
    
    private int solve(int ind, int sum, int arr[], int dp[][])
    {
        // if we reach the negative index
        if(ind < 0)
        {
            // and sum has become 0 than a solution has been obtained
            if(sum == 0) return 1;
            // else return 0
            else return 0;
        }
        
        if(dp[ind][sum] != -1) return dp[ind][sum];
        
        // if we do not take the element in the subset then just reduce the index and call the solve function again
        int notPick = solve(ind - 1, sum, arr, dp);
        
        // if we take the element then first check whether the given element is less than equal to the sum else we can not pick
        int pick = 0;
        
        if(arr[ind] <= sum)
        {
            // reduce the index by 1 and also reduce the target sum by the element value
            pick = solve(ind - 1, sum - arr[ind], arr, dp);
        }
        
        // store the total answer as sum of pick and not pick
        dp[ind][sum] = (pick + notPick) % 1000000007;
        
        return dp[ind][sum];
    }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    // initialize the dp array
	    int dp[][] = new int[n][sum + 1];
	    
	    for(int array[] : dp)
	    {
	        Arrays.fill(array, -1);
	    }
	    
	    // call the solve function with last index of array and the target sum
	    return solve(n - 1, sum, arr, dp);
	} 
}