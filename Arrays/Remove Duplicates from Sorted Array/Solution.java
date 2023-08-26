class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        // traverse the array
        while(j < nums.length)
        {
            // keep incrementing j counter till we find the distinct element
            if(nums[i] != nums[j])
            {
                // then simply increment the i pointer and store that element in adjacent position
                i++;
                nums[i] = nums[j];
            }

            j++;
        }

        return i + 1;
    }
}