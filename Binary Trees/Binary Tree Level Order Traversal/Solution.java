class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // create a queue for storing the nodes at a particular level
        Queue<TreeNode> queue = new LinkedList<>();
        // 2d arraylist to store answer
        List<List<Integer>> levelorder = new ArrayList<>();
        // assign a temporary pointer to root
        TreeNode temp = root;
        // add the level 0 node to queue
        if(temp != null)
        {
            queue.add(temp);
        }
        // keep on iterating till the queue is empty that is the levels are finished
        while(!queue.isEmpty())
        {
            // arraylist to store nodes at a given level
            ArrayList<Integer> level = new ArrayList<>();
            // the current queue size gives idea for numder of nodes at a given level
            int sizeOfLevel = queue.size();
            // iterate the nodes at this level
            for(int i = 0; i < sizeOfLevel; i++)
            {
                // take out the node
                temp = queue.poll();
                // add the value
                level.add(temp.val);

                // add the left and right child of the node if present to the queue for next level iteration 
                if(temp.left != null)
                {
                    queue.add(temp.left);
                }

                if(temp.right != null)
                {
                    queue.add(temp.right);
                }
            }
            // add the particular level arraylist obtained to 2d answer array list;
            levelorder.add(level);
        }

        return levelorder;
    }
}
