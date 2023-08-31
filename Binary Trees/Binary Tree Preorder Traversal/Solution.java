class Solution {
    // recursive preorder function
    // preorder => print -> left -> right
    private void recursivePreorder(TreeNode root, List<Integer> preorder) {
        // if the pointer is not null
        if(root != null)
        {
            // first add the value
            preorder.add(root.val);

            // then call the left node
            recursivePreorder(root.left, preorder);

            // if left is over then call the right
            recursivePreorder(root.right, preorder);
        }
        // else terminate the function call
    }

    // iterative preorder function
    // preorder => print -> left -> right
    private void iterativePreorder(TreeNode root, List<Integer> preorder) {
        // assign a temporary pointer to root node
        TreeNode temp = root;

        // create a stack in order to return back from the left call
        Stack<TreeNode> stk = new Stack<>();

        // keep iterating till the pointer is null as well as the stack becomes empty
        while(temp != null || !stk.isEmpty())
        {
            // if it is a node then add the value and push the node in stack and go to left child
            if(temp != null)
            {
                preorder.add(temp.val);
                stk.push(temp);
                temp = temp.left;
            }
            // once the left child iteration is over and it points to null
            else
            {
                // pop the previous node from the stack
                temp = stk.pop();

                // and go to the right child of it and repeat the same process
                temp = temp.right;
            }
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        recursivePreorder(root, preorder);
        // iterativePreorder(root, preorder);

        return preorder;        
    }
}
