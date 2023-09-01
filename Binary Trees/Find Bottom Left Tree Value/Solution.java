class Solution {
    private int maxDepth;
    private int leftmost;

    private void recursiveLeftView(TreeNode root, int depth) {
        if(root != null)
        {
            if(depth > maxDepth)
            {
                maxDepth = depth;
                leftmost = root.val;
            }
            recursiveLeftView(root.left, depth + 1);
            recursiveLeftView(root.right, depth + 1);
        }
    } 

    // it is same as left view of binary tree just keep two global variables max depth and leftmost instead of using a whole arraylist
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        leftmost = -1;

        recursiveLeftView(root, 0);

        return leftmost;
    }
}