// defining a comparator class to sort the 2d array list according the first element of each arraylist
class My implements Comparator<ArrayList<Integer>>
{
    public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) 
    {
        
        return list1.get(0).compareTo(list2.get(0)); // num1.compareTo(num2) => if num2 < num1 returns 1;
        
        // put list2 above if the list2.get(0) is smaller
    }
}

class Solution
{
    private static int time = 0;
    
    private void dfs(int node, int discovery[], int low[], Stack<Integer> stk, boolean inStack[], ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> ans)
    {
        // stamping the discovery array and low array with time
        discovery[node] = time;
        low[node] = time;
        
        // incrementing time
        time++;
        
        // pushing the node in stack
        stk.push(node);
        inStack[node] = true;
        
        // iterating the adjacent nodes
        for(int adjacentNode : adj.get(node))
        {
            // if the adjacent node is unvisited
            if(discovery[adjacentNode] == -1)
            {
                // perform dfs and on returning update the low array with the minimum accessible time of that node and the adjacent node so that it can be used to track it as part of one scc
                dfs(adjacentNode, discovery, low, stk, inStack, adj, ans);
                low[node] = Math.min(low[node], low[adjacentNode]);
            }
            // if the adjacent node is visited then check whether it is a back edge or cross edge
            else if(inStack[adjacentNode] == true)
            {
                // if it is in stack that means it is a back edge
                // then we update the low array with the discovery of the node since that can be the starting point of cycle
                low[node] = Math.min(low[node], discovery[adjacentNode]);
            }
        }
        
        // now when we get to the node whose lowest accessible time and discovery time are equal that means we found the parent of scc
        if(low[node] == discovery[node])
        {
            ArrayList<Integer> temp = new ArrayList<>();
            int element;
            
            // we start poping the elements from stack till the parent element is obtained and add it to temporary arraylist
            while(stk.peek() != node)
            {
                element = stk.pop();
                temp.add(element);
                inStack[element] = false;
            }
            
            element = stk.pop();
            temp.add(element);
            inStack[element] = false;
            
            // sort the arraylist as the answer required should be sorted
            Collections.sort(temp);
            
            // add one of the scc obtained to the answer arraylist
            ans.add(temp);
        }
    }
    
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph.  
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        
        // discovery array is used for tracking discovery time of a node
        int discovery[] = new int[V];
        Arrays.fill(discovery, -1);
        
        // low array is used to track the what nodes with lowest discovery time is accessible
        int low[] = new int[V];
        Arrays.fill(low, -1);
        
        // the max value of low will be discovery because the minimum discovery time node accesible from a node can be itself
        
        // stack is required to keep track of nodes present in scc
        boolean inStack[] = new boolean[V];
        Arrays.fill(inStack, false);
        
        Stack<Integer> stk = new Stack<>();
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
        {
            // Performing dfs on unvisited nodes
            if(discovery[i] == -1)
            {
                dfs(i, discovery, low, stk, inStack, adj, ans);
            }
        }
        
        // sort the answer arraylist according to the question requirement
        Collections.sort(ans, new My());
        
        return ans;
    }
}