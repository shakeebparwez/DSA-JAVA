class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // sort both the arrays
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int i = 0;
        int j = 0;

        while(i < g.length && j < s.length)
        {
            // try to satisfy the least greedy child with the least size cookie available
            if(s[j] >= g[i])
            {
                count++;
                i++;
            }
            
            // increment to the next cookie and repeat
            j++;
        }

        return count;
    }
}