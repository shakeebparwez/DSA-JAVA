class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int max_consecutive_count = 0;

        // iterate the array
        while(i < nums.length)
        {
            int count = 0;

            // keep incrementing count if it is a one
            while(i < nums.length && nums[i] == 1)
            {
                count++;
                i++;
            }

            // store the maximum count of ones got in this one consecutive iteration and the previously gotten count
            max_consecutive_count = Math.max(max_consecutive_count, count);
            i++;
        }

        return max_consecutive_count;
    }
}