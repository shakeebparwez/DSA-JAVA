// defining a tuple class
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

// defining a comparator for the min heap configuration of priority queue
class My implements Comparator<Tuple>
{
    public int compare(Tuple t1, Tuple t2) // compares t2 (new) with t1 (old)
    {
        if(t1.first > t2.first) return 1; // if the t2.first is smaller make it on top
        else if(t1.first < t2.first) return -1; // else keep it below
        else return 0; // in case of equality do nothing
    }
}

class Solution 
{
    
    int MinimumEffort(int heights[][]) 
    {
        // initializing the starting configuration
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new My());
        
        int n = heights.length;
        int m = heights[0].length;
        
        
        int effort[][] = new int[n][m];
        
        
        for(int arr[] : effort)
        {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        effort[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        
        // initializing the delta arrays for the movements within the grid
        int deltaRow[] = {-1, 0, 1, 0};
        int deltaCol[] = {0, -1, 0, 1};
        
        while(!pq.isEmpty())
        {
            Tuple t = pq.poll(); // take out the point
            
            int diff = t.first;
            int row = t.second;
            int col = t.third;
            
            if(row == n - 1 && col == m - 1) // check for destination while taking out from priority queue and not while inserting since coming out of priority queue tells automatically that it will be the minimal
            {
                return diff;
            }
            
            
            for(int i = 0; i < 4; i++) // traverse the four directions
            {
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];
                
                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) // check if the movement is possible
                {
                    int newEffort = Math.max(diff, Math.abs(heights[row][col] - heights[newRow][newCol])); // find the new effort comparing the already existing difference and new difference between the heights of the adjacent cells
                    
                    if(newEffort < effort[newRow][newCol]) // if it is minimal then update the effort grid of that cell
                    {
                        effort[newRow][newCol] = newEffort;
                        pq.add(new Tuple(newEffort, newRow, newCol)); // add this cell in the priority queue
                    }
                }
            }
        }
        
        
        return effort[n - 1][m - 1];
    }
}