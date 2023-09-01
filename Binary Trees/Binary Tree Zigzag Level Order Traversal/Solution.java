class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        
        // dequeue data structure is used in order to facilatate the left to right as well as right to left
        Deque<TreeNode> dq = new ArrayDeque<>();
        
        TreeNode temp = root;

        // root node is added in dequeue
        if(temp != null)
        {
            dq.add(temp);
        }

        // first traversal begins from left to right
        boolean isLeftToRight = true;

        // iterate till the queue becomes empty
        while(!dq.isEmpty())
        {
            ArrayList<Integer> level = new ArrayList<>();

            int size = dq.size();

            // level iteration
            for(int i = 0; i < size; i++)
            {
                // if left to right is the direction
                if(isLeftToRight)
                {
                    // take the node from front of queue
                    temp = dq.removeFirst();

                    // add the value
                    level.add(temp.val);

                    // put its left and then right child at the back of the queue
                    if(temp.left != null)
                    {
                        dq.addLast(temp.left);
                    }

                    if(temp.right != null)
                    {
                        dq.addLast(temp.right);
                    }
                }
                // if right to left is the direction
                else
                {
                    // take the node from back of queue
                    temp = dq.removeLast();

                    // add the value
                    level.add(temp.val);

                    // put its right and then left child at the front of the queue
                    if(temp.right != null)
                    {
                        dq.addFirst(temp.right);
                    }

                    if(temp.left != null)
                    {
                        dq.addFirst(temp.left);
                    }

                }
            }

            // add one level to the 2d array list
            zigzag.add(level);

            // reverse the direction of traversal after each iteration
            isLeftToRight = !isLeftToRight;
        }

        return zigzag;
    }
}