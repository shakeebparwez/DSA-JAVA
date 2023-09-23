class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        int left = 0;
        int right = c;
        int top = 0;
        int bottom = r;
        
        while(left < right && top < bottom)
        {
            // Get every i in the top row
            for(int i = left; i < right; i++)
            {
                ans.add(matrix[top][i]);
            }
            top++;
            
            // Get every i in the right col
            for(int i = top; i < bottom; i++)
            {
                ans.add(matrix[i][right - 1]);
            }
            right--;
            
            if(!(left < right && top < bottom))
            {
                break;
            }
            
            // Get every i in the bottom row
            for(int i = right - 1; i >= left; i--)
            {
                ans.add(matrix[bottom - 1][i]);
            }
            bottom--;
            
            // Get every i in the left col
            for(int i = bottom - 1; i >= top; i--)
            {
                ans.add(matrix[i][left]);    
            }
            left++;
        }
        
        return ans;
    }
}