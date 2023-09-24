class My implements Comparator<String>
{
    public int compare(String str1, String str2)
    {
        // Compare strings based on their lengths
        int length1 = str1.length();
        int length2 = str2.length();

        // Compare by length
        if (length1 < length2) {
            return -1;
        } else if (length1 > length2) {
            return 1;
        } else {
            // If lengths are equal, compare lexicographically
            return str1.compareTo(str2);
        }
    }
}

class Solution {
    // check if the smaller string is a subsequence of larger string and their length difference is of one
    private boolean isPossible(String s1, String s2) {
        if(s1.length() != s2.length() + 1) return false;

        int first = 0;
        int second = 0;

        while(first < s1.length() && second < s2.length())
        {
            if(s1.charAt(first) == s2.charAt(second))
            {
                first++;
                second++;
            }
            else
            {
                first++;
            }
        }

        if(second == s2.length()) return true;
        else return false;
    }

    private int solve(int ind, int prevInd, String[] words, int[][] dp) {
        if(ind == words.length) return 0;

        if(dp[ind][prevInd + 1] != -1) return dp[ind][prevInd + 1];

        int notTake = 0 + solve(ind + 1, prevInd, words, dp);
        int take = 0;

        if(prevInd == -1 || isPossible(words[ind], words[prevInd]))
        {
            take = 1 + solve(ind + 1, ind, words, dp);
        }

        dp[ind][prevInd + 1] = Math.max(notTake, take);

        return dp[ind][prevInd + 1];
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, new My());
        
        int dp[][] = new int[words.length][words.length + 1];
        for(int row[]: dp) Arrays.fill(row, -1);

        return solve(0, -1, words, dp);
    }
}