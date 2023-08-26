class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        int complement = 0;

        // hash map to store the number along with its index
        HashMap<Integer,Integer> map = new HashMap<>();

        // iterate the array
        for(int i = 0; i < nums.length; i++)
        {
            // store the complement required
            complement = target - nums[i];

            // if map contains the complement
            if(map.containsKey(complement))
            {
                // get the index of the complement from the map
                ans[0] = map.get(complement);
                ans[1] = i;

                // answer obtained hence break out of loop
                break;
            }

            // store the number along with its index in the map so that it can be used to search in constant time if it is the complement of some other element
            map.put(nums[i], i);
        }

        return ans;
    }
}
