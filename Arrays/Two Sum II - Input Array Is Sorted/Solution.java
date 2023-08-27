class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int N = numbers.length;

        // initialize one pointer to start and other pointer to the end of the array
        int low = 0;
        int high = N - 1;

        int ans[] = new int[2];

        // iterate while i is less than j
        while(low < high)
        {
            // if the sum is equal to target then store their 1-indexes and break out of loop since is is given their is only 1 answer
            if(numbers[low] + numbers[high] == target)
            {
                ans[0] = low + 1;
                ans[1] = high + 1;
                break;
            }
            // if their sum is less then increase the low pointer to increase the sum
            else if(numbers[low] + numbers[high] < target)
            {
                low++;
            }
            // if their sum is more then decrease the high pointer to decrease the sum
            else if(numbers[low] + numbers[high] > target)
            {
                high--;
            }
        }

        return ans;
    }
}