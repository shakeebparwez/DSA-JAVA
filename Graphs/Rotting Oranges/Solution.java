class Tuple {
    int row;
    int col;
    int time;

    Tuple(int row, int col, int time)
    {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        Queue<Tuple> queue = new LinkedList<>();

        int visited[][] = new int[M][N];

        // store the initial rotten oranges coordinates with initial time as zero and mark them as spoiled in visited matrix
        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(grid[i][j] == 2)
                {
                    queue.add(new Tuple(i, j, 0));
                    visited[i][j] = 2;
                }
                else
                {
                    visited[i][j] = 0;
                }
            }
        }

        int maxTime = 0;
        
        // for bfs traveral
        while(!queue.isEmpty())
        {
            // take out the rotten orange
            Tuple tup = queue.poll();

            int row = tup.row;
            int col = tup.col;
            int time = tup.time;

            // update max time with the time it took to rot the taken out orange
            maxTime = Math.max(maxTime, time);

            int deltaRow[] = {-1, 0, 1, 0};
            int deltaCol[] = {0, -1, 0, 1};

            for(int i = 0; i < 4; i++)
            {
                // move 4 directionally
                int neighbourRow = row + deltaRow[i];
                int neighbourCol = col + deltaCol[i];

                // rot the fresh oranges and mark them spoiled in the visited matrix so that it does not get spoiled again and push it into the queue for further spreading the rot
                if(neighbourRow >= 0 && neighbourRow < M && neighbourCol >= 0 && neighbourCol < N)
                {
                    if(visited[neighbourRow][neighbourCol] == 0 && grid[neighbourRow][neighbourCol] == 1)
                    {
                        // increase the time taken to rot this orange by 1
                        queue.add(new Tuple(neighbourRow, neighbourCol, time + 1));
                        visited[neighbourRow][neighbourCol] = 2;
                    }
                }
            }
        }

        // check if a fresh orange is still left without getting spoiled marked
        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(visited[i][j] == 0 && grid[i][j] == 1)
                {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}