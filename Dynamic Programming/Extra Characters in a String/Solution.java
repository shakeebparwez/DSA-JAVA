class Solution {
    private int solve(int i, String s, HashSet<String> set, int dp[]) {
        // base condition if index reaches string length return 0 as the string is finished no extra character
        if(i == s.length())
        {
            return 0;
        }

        // memoization
        if(dp[i] != -1)
        {
            return dp[i];
        }

        // first we just take the index character as extra and solve for the string from index + 1
        int notFound = 1 + solve(i + 1, s, set, dp);

        // now we try to check if any substring is present in the set or not
        int found = Integer.MAX_VALUE;

        // form all the substrings from given index i to last index of the string
        for(int j = i; j < s.length(); j++)
        {
            // if the substring is found in dictionary
            if(set.contains(s.substring(i, j + 1)))
            {
                // update found by solving for the string starting from next index of where the substring ended
                found = Math.min(found, solve(j + 1, s, set, dp));
            }
        }

        // store the minimum of both the answers
        dp[i] = Math.min(notFound, found);

        return dp[i];
    }

    public int minExtraChar(String s, String[] dictionary) {
        // since the dictionary includes distinct words we create a hashset of words so that searching time gets optimized
        HashSet<String> set = new HashSet<>();

        for(String word : dictionary)
        {
            set.add(word);
        }

        // dp array for memoization
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);

        // start from 0 index of string
        int minimum_extra_characters = solve(0, s, set, dp);

        return minimum_extra_characters;
    }
}