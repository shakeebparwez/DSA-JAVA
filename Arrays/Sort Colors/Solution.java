class Solution {
    public void sortColors(int[] nums) {
        // 0 to low - 1 => 0's
        // low to mid - 1 => 1's
        // mid to n - 1 => 2's
        
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // move mid pointer and shift the elements to their right position
        while(mid <= high)
        {
            // if 0 is found swap it with low pointer and increment both mid and low as both mid and low are now sorted
            if(nums[mid] == 0)
            {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                low++;
                mid++;
            }
            // if 1 is found just increment the mid as it is already at right place
            else if(nums[mid] == 1)
            {
                mid++;
            }
            // if 2 is found swap it with high pointer and decrement only high pointer because it is not guaranteed that mid will be sorted after swap so we check for that again
            else if(nums[mid] == 2)
            {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}