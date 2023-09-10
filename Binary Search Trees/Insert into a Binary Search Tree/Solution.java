class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // if empty tree just create the node and return
        if(root == null)
        {
            return new TreeNode(val);
        }

        // two pointers one to find the appropriate location and one tailing in order to insert
        TreeNode prev = root;
        TreeNode curr = root;

        // reach the location to insert
        while(curr != null)
        {
            prev = curr;

            if(val < curr.val)
            {
                curr = curr.left;
            }
            else if(val > curr.val)
            {
                curr = curr.right;
            }
        }

        // create the new node
        TreeNode newNode = new TreeNode(val);

        // connect with appropriate pointer
        if(val < prev.val)
        {
            prev.left = newNode;
        }
        else if(val > prev.val)
        {
            prev.right = newNode;
        }

        // return root
        return root;
    }
}