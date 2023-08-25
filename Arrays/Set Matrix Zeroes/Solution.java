class Solution {
    public void setZeroes(int[][] matrix) {
        // storing the dimensions of matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // flags to check for the (0,0) cell from where row or column or both have to be changed to zeroes
        boolean rowFlag = false;
        boolean colFlag = false;

        // checking for 0 in the row-0
        for(int col = 0; col < M; col++)
        {
            // if found mark the row flag as true
            if(matrix[0][col] == 0)
            {
                rowFlag = true;
            }
        }

        // checking for 0 in the col-0
        for(int row = 0; row < N; row++)
        {
            // if found mark the col flag as true
            if(matrix[row][0] == 0)
            {
                colFlag = true;
            }
        }

        // traversing the matrix
        for(int row = 0; row < N; row++)
        {
            for(int col = 0; col < M; col++)
            {
                // if a cell with zero is found
                if(matrix[row][col] == 0)
                {
                    // store the 0 in the corresponding row-0 and col-0 of the matrix
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // traverse the row-0
        for(int col = 1; col < M; col++)
        {
            // if zero is found then make the whole column under bottom of it as 0 
            if(matrix[0][col] == 0)
            {
                for(int row = 1; row < N; row++)
                {
                    matrix[row][col] = 0;
                }
            }
        }

        // traverse the col-0
        for(int row = 1; row < N; row++)
        {
            // if zero is found then make the whole row on left of it as 0
            if(matrix[row][0] == 0)
            {
                for(int col = 1; col < M; col++)
                {
                    matrix[row][col] = 0;
                }
            }
        }

        // if row flag is set make the whole row-0 as zero
        if(rowFlag)
        {
            for(int col = 0; col < M; col++)
            {
                matrix[0][col] = 0;
            }
        }

        // if col flag is set make the whole col-0 as zero
        if(colFlag)
        {
            for(int row = 0; row < N; row++)
            {
                matrix[row][0] = 0;
            }
        }
    }
}