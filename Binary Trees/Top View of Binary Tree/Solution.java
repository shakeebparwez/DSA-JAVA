class Pair 
{
    Node node;
    int horizontal_dist;
        
    Pair(Node node, int horizontal_dist)
    {
        this.node = node;
        this.horizontal_dist = horizontal_dist;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        
        // queue to do traversal level wise
        Queue<Pair> queue = new LinkedList<>();
        
        // hashmap to store node along with its horizontal distance
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // min max variable to keep track of tree's horizontal distance range
        int min = 0;
        int max = 0;
        
        // put the root node in queue with horizontal distance as zero to begin
        queue.add(new Pair(root, 0));
        
        // traverse till the queue is empty
        while(!queue.isEmpty())
        {
            // take out the node from queue
            Pair curr = queue.remove();
            
            // if it the the first node to be encountered with the given horizontal distance then put it inside the map
            if(!map.containsKey(curr.horizontal_dist))
            {
                map.put(curr.horizontal_dist, curr.node.data);
            }
            
            // if left child of the node is present add it to the queue
            if(curr.node.left != null)
            {
                // left child means reduce the horizontal distance of given node by 1
                queue.add(new Pair(curr.node.left, curr.horizontal_dist - 1));
                
                // update min
                min = Math.min(min, curr.horizontal_dist - 1);
            }
            
            // if right child of the node is present add it to the queue
            if(curr.node.right != null)
            {
                // right child means increase the horizontal distance of given node by 1
                queue.add(new Pair(curr.node.right, curr.horizontal_dist + 1));
                
                // update max
                max = Math.max(max, curr.horizontal_dist + 1);
            }
        }
        
        // prepare the answer array just by getting the first encountered elements of given horizontal distance in the range of min to max from the hash map
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = min; i <= max; i++)
        {
            ans.add(map.get(i));    
        }
        
        return ans;
        
    }
}