// defining the pair class
class Pair
{
    int first;
    int second;
    
    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        
        // edge case if the starting and ending number are same
        if(start == end)
        {
            return 0;
        }
        
        // intital configuration
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        
        int results[] = new int[100000];
        Arrays.fill(results, Integer.MAX_VALUE);
        
        results[start] = 0;
        
        int mod = 100000;
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            
            int steps = p.first;
            int node = p.second;
            
            for(int x : arr) // iterate all elements of the array
            {
                int result = (x * node) % mod; // find the all possible products
                
                if(steps + 1 < results[result]) // update the steps if it is minimal to reach
                {
                    results[result] = steps + 1;
                    
                    if(result == end) // if end reached it is the answer as the steps are increasing uniformly
                    {
                        return steps + 1;
                    }
                    
                    q.add(new Pair(steps + 1, result)); // insert the (steps, result) pair
                }
            }
        }
        
        return -1;
    }
}