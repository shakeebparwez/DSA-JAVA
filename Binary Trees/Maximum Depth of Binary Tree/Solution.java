class Solution {
    public int maxDepth(TreeNode root) {
        // if root not null
        if(root != null)
        {
            // get left and right depth recusively
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            // return max of both left and right plus one for the node itself
            return Math.max(leftDepth, rightDepth) + 1;
        }

        // if root is null the depth is zero
        return 0;
    }
}