class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here
        
        // the algorithm is not much intuitive as the other ones
        // it is more of a brute force, where all combination of paths have been tried to get the shortest paths
        
        // replace the -1 with infinity
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                if(matrix[i][j] == -1)
                {
                    matrix[i][j] = (int)1e8;
                }
            }
        }
        
        // updating the cost matrix for every via nodes
        for(int via = 0; via < matrix.length; via++)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                for(int j = 0; j < matrix.length; j++)
                {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }
        
        // if the costing of any node from 0 to n (costing of node to node itself is lesser than 0)
        // we can say negative cycle exists
        
        // for(i = 0 -> n)
        // {
        //      if(matrix[i][j] < 0)
        //      {
        //          "negative cycle"
        //      }
        // }
        
        // replace the infinty with -1
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                if(matrix[i][j] == 1e8)
                {
                    matrix[i][j] = -1;
                }
            }
        }
        
        // the first and last step is done just to make the initial configuration fit with Math.min(a, b)
    }
}