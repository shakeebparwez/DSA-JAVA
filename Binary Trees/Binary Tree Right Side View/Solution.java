class Solution {
    private void recursiveRightView(TreeNode root, int level, List<Integer> rightview) {
        // if the root is not null
        if(root != null)
        {
            // and if that node is the first to be encountered in that level then add it to the view arraylist
            if(rightview.size() == level)
            {
                rightview.add(root.val);
            }

            // go to right side first and keep on incrementing the level every time you go
            recursiveRightView(root.right, level + 1, rightview);

            // if the right side gets finished then go to left side
            recursiveRightView(root.left, level + 1, rightview);
        }
        // function call terminates
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightview = new ArrayList<>();
        // pass root and level as zero to the recursive function call
        recursiveRightView(root, 0, rightview);
        return rightview;
    }
}