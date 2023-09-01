class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // this code is similar to Binary Tree Level Order Traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // stack data structure is used to store the normal level order traversal and then again pop back to store in bottom up fashion         
        Stack<TreeNode> stk = new Stack<>();

        List<List<Integer>> levelorder = new ArrayList<>();

        TreeNode temp = root;

        if(temp != null)
        {
            queue.add(temp);
        }

        while(!queue.isEmpty())
        {
            int size = queue.size();
            // null is pushed in stack so that it can help to identify new level starting point
            stk.push(null);
    
            for(int i = 0; i < size; i++)
            {
                temp = queue.poll();
                // element is added in stack
                stk.push(temp);

                // first right is traversed then left because when we pop from stack left will come first and then right
                if(temp.right != null)
                {
                    queue.add(temp.right);
                }

                if(temp.left != null)
                {
                    queue.add(temp.left);
                }
            }
        }

        ArrayList<Integer> level = new ArrayList<>();

        // now create the level order traversal till stack is empty 
        while(!stk.isEmpty())
        {
            temp = stk.pop();

            // if the node is not null add it in the level array list
            if(temp != null)
            {
                level.add(temp.val);
            }
            // when null is obtained that means one level finished so add that level in 2d level order array list and assign the level array list a new empty array list
            else
            {
                levelorder.add(level);
                level = new ArrayList<>();
            }
        }

        return levelorder;
    }
}