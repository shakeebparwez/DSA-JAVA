class Pair {
    int height;
    int diameter;

    Pair(int height, int diameter)
    {
        this.height = height;
        this.diameter = diameter;
    }
}

class Solution {
    private Pair diameterFinder(TreeNode root) {
        // if root is null it will have 0 height and 0 diameter
        if(root == null)
        {
            return new Pair(0,0);
        }

        // else get the inforamtion of left child and right child
        Pair leftPart = diameterFinder(root.left);
        Pair rightPart = diameterFinder(root.right);

        // now the options for selecting largest diameter is either the left part diameter or right part diameter
        int option1 = leftPart.diameter;
        int option2 = rightPart.diameter;

        // or if considering the node itself then you have to take both left and right height plus one for the node itself
        int option3 = leftPart.height + rightPart.height + 1;

        // choose max of all options for the node
        int maxDiameter = Math.max(option3, Math.max(option1, option2));

        // also maintain height count
        int maxHeight = Math.max(leftPart.height, rightPart.height) + 1;

        // return the max diameter and height for the given root node
        return new Pair(maxHeight, maxDiameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // get the count of nodes in the longest path
        int totalNodes = diameterFinder(root).diameter;

        // count of edges will be 1 less than the nodes
        int totalEdges = totalNodes - 1;

        // return number of edges obtained
        return totalEdges;
    }
}