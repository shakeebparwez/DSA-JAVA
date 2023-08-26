class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        // two pointers for implementing sliding window
        int i = 0;
        int j = 0;
        
        // hashmap to store the count of distinct letters
        HashMap<Character, Integer> map = new HashMap<>();
        
        // variable for keeping track of maximum length possible substring
        int maxLength = -1;
        
        while(j < s.length())
        {
            // put the letter in map and increase the frequency by 1 and if not present then default value of frequency returned will be 0
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            // if the distinct letters are more than k
            while(map.size() > k)
            {
                // deecrease the frequency of character
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                
                // if the frequency becomes 0 then remove that letter from the map
                if(map.get(s.charAt(i)) == 0)
                {
                    map.remove(s.charAt(i));
                }
                
                // window size decreased
                i++;
            }
            
            // if the map contains exactly the k letters
            if(map.size() == k)
            {
                // update the max length by comparing it with new length of window size given by j - i + 1
                maxLength = Math.max(maxLength, j - i + 1);
            }
            
            // increase the window size
            j++;
        }
        
        return maxLength;
    }
}
