class Pair {
    TreeNode node;
    boolean flag;

    Pair(TreeNode node)
    {
        this.node = node;
        this.flag = false;
    }
}

class Solution {
    // iterative postorder function
    // postorder => left -> right -> print
    private void iterativePostorder(TreeNode root, List<Integer> postorder) {
        // assign a temporary pointer to root node
        TreeNode temp = root;

        // create a stack in order to return back from the left and right calls
        Stack<Pair> stk = new Stack<>();

        // keep iterating till the pointer is null as well as the stack becomes empty
        while(temp != null || !stk.isEmpty())
        {
            // if it is a node then push the node in stack and go to left child
            if(temp != null)
            {
                stk.push(new Pair(temp));
                temp = temp.left;
            }
            // once the left child iteration is over and it points to null
            else
            {
                // pop the previous node from the stack
                Pair p = stk.pop();
                temp = p.node;

                // if the flag of the node is false that means it is poped for the first time
                if(p.flag == false)
                {
                    // mark the flag as true and again push the node into the stack and go to the right child
                    p.flag = true;
                    stk.push(p);
                    temp = temp.right; 
                }
                // if the flag of the node is true that means we already visited the right child also so now we have to add the value and go back by making temp as null
                else
                {
                    postorder.add(temp.val);
                    temp = null;
                }
            }
        }
    }

    // recursive postorder function
    // postorder => left -> right -> print
    private void recursivePostorder(TreeNode root, List<Integer> postorder) {
        // if the pointer is not null
        if(root != null)
        {
            // first call the left child
            recursivePostorder(root.left, postorder);
            // then call the right child
            recursivePostorder(root.right, postorder);
            // on returning from both the calls add the value
            postorder.add(root.val);
        }
        // else terminate the function call
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();

        // recursivePostorder(root, postorder);
        iterativePostorder(root, postorder);

        return postorder;    
    }
}