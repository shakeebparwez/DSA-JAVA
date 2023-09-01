class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // assign a temporary pointer to root
        TreeNode temp = root;

        // search for the key
        while(temp != null)
        {
            // if node value is same as key then return the pointer
            if(temp.val == val)
            {
                return temp;
            }
            // if node value is lesser than key then we go to right child of bst
            else if(temp.val < val)
            {
                temp = temp.right;
            }
            // if node value is greater than key then we go to left child of bst
            else if(temp.val > val)
            {
                temp = temp.left;
            }
        }

        return temp;
    }
}