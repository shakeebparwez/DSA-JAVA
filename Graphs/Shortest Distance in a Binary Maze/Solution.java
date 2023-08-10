// creating a tuple class
class Tuple
{
    int first;
    int second;
    int third;
    
    Tuple(int first, int second, int third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        
        // if the source and destination are same
        if(source[0] == destination[0] && source[1] == destination[1])
        {
            return 0;
        }
        
        // initializing the starting configuration
        Queue<Tuple> q = new LinkedList<>();
        
        int n = grid.length;
        int m = grid[0].length;
        
        int dist[][] = new int[n][m];
        
        
        for(int arr[] : dist)
        {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0, source[0], source[1]));
        
        // initializing the delta arrays for the movements within the grid
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, 1, 0, -1};
        
        while(!q.isEmpty())
        {
            Tuple t = q.poll(); // take out the point
            
            int distance = t.first;
            int row = t.second;
            int col = t.third;
            
            for(int i = 0; i < 4; i++) // traverse the four directions
            {
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];
                
                // check if the movement is possible and are we getting lesser distance then the previous distance for the adjacent cell
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && distance + 1 < dist[newRow][newCol])
                {
                    dist[newRow][newCol] = distance + 1; // update the distance matrix
                    
                    if(newRow == destination[0] && newCol == destination[1]) // if we reached the destination cell then return
                    {
                        return distance + 1;
                    }
                    
                    q.add(new Tuple(distance + 1, newRow, newCol)); // add the adjacent cell into the queue
                }
            }
        }
        
        return -1; // if we didn't reached the destination cell
    }
}