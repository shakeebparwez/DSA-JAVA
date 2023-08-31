class Solution {
    // recursive inorder function
    // inorder => left -> print -> right
    private void recursiveInorder(TreeNode root, List<Integer> inorder) {
        // if the pointer is not null
        if(root != null)
        {
            // then keep calling on the left child 
            recursiveInorder(root.left, inorder);

            // while returning from left add the value
            inorder.add(root.val);

            // then call the right child
            recursiveInorder(root.right, inorder);
        }
        // else terminate the function call
    }

    // iterative inorder function
    // inorder => left -> print -> right
    private void iterativeInorder(TreeNode root, List<Integer> inorder) {
        // assign a temporary pointer to root node
        TreeNode temp = root;

        // create a stack in order to return back from the left call
        Stack<TreeNode> stk = new Stack<>();

        // keep iterating till the pointer is null as well as the stack becomes empty
        while(temp != null || !stk.isEmpty())
        {
            // if it is a node then push the node in stack and go to left child
            if(temp != null)
            {
                stk.push(temp);
                temp = temp.left;
            }
            // once the left child iteration is over and it points to null
            else
            {
                // pop the previous node from the stack and add its value
                temp = stk.pop();
                inorder.add(temp.val);

                // and go to the right child of it and repeat the same process
                temp = temp.right;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        // recursiveInorder(root, inorder);
        iterativeInorder(root, inorder);

        return inorder;
    }
}