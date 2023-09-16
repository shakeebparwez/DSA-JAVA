class Solution {
    public int candy(int[] ratings) {
        int N = ratings.length;
        
        int[] left = new int[N];

        // give 1 candy to all
        Arrays.fill(left, 1);

        // increment the candy count from left to right rating comparison
        for(int i = 1; i < N; i++)
        {
            if(ratings[i] > ratings[i - 1])
            {
                left[i] = left[i - 1] + 1;
            }
        }

        int[] right = new int[N];

        // give 1 candy to all
        Arrays.fill(right, 1);

        // increment the candy count from right to left rating comparison
        for(int i = N - 2; i >= 0; i--)
        {
            if(ratings[i] > ratings[i + 1])
            {
                right[i] = right[i + 1] + 1;
            }
        }


        int minimum_candy = 0;

        // the actual minimum candy needed by each child will be the max of both left and right comparisons
        for(int i = 0; i < N; i++)
        {
            minimum_candy += Math.max(left[i], right[i]);
        }

        return minimum_candy;
    }
}