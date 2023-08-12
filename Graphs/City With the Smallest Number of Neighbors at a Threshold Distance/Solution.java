class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          
          // initial setup for apply floyd warshall algorithm
          int dist[][] = new int[n][n];
          
          for(int arr[] : dist)
          {
              Arrays.fill(arr, Integer.MAX_VALUE);
          }
          
          for(int i = 0; i < n; i++)
          {
              dist[i][i] = 0;
          }
          
          for(int i = 0; i < m; i++)
          {
              int u = edges[i][0];
              int v = edges[i][1];
              int wt = edges[i][2];
              
              dist[u][v] = wt;
              dist[v][u] = wt;
          }
          
          // applying floyd warhsall algorithm to find out the shortest path for all the cities
          for(int via = 0; via < n; via++)
          {
              for(int i = 0; i < n; i++)
              {
                  for(int j = 0; j < n; j++)
                  {
                      if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE)
                      {
                            continue;    
                      }
                      
                      dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                  }
              }
          }
          
          int cntCity = n;
          int cityNo = -1;
          
          // iterating the dist matrix
          for(int city = 0; city < n; city++)
          {
              int count = 0;
              
              for(int adjCity = 0; adjCity < n; adjCity++)
              {
                  // count the number of cities within the reach of threshold value
                  if(dist[city][adjCity] <= distanceThreshold)
                  {
                      count++;
                  }
              }
              
              // update if the count found is minimum as well the city number because we want the greatest city number as our answer
              if(count <= cntCity)
              {
                    cntCity = count;
                    cityNo = city;
              }
         }
          
         return cityNo;
     }
}