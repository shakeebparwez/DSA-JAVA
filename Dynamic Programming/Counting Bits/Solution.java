class Solution {
    public int[] countBits(int n) {
        // brute force => for all num 1 to n run a while loop checking if modulo 2 gives 1 that means that the first bit has 1 and then divide the num by 2 to shift the bit to the right O(n * logn)

        // optimized solution O(n)

        // create the answer array
        int[] dp = new int[n + 1];

        // for 0 the number of ones are 0
        dp[0] = 0;

        // offset the first time a particular place bit is set
        int offset = 1;

        // iterate all the numbers from 1 to n
        for(int i = 1; i <= n; i++)
        {
            // every time you find a new set bit place update the offset
            if(2 * offset == i)
            {
                offset = i;
            }
            
            // 1 is for the new set bit and add the previous calculated bit count for remaining places
            dp[i] = 1 + dp[i - offset];    
        }

        return dp;
    }
}