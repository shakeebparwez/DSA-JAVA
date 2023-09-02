class Tuple {
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // treemap that stores col mapped to another treemap which maps the row to a priority queue to keep smaller elements at top as we want nodes at same coordinate to be sorted by their value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // queue to do traversal level wise
        Queue<Tuple> queue = new LinkedList<>();

        // put the root node in queue with coordinate as (0,0) to begin
        queue.add(new Tuple(root, 0, 0));

        // traverse till the queue is empty
        while(!queue.isEmpty())
        {
            // take out the node from queue
            Tuple curr = queue.poll();

            // first if the map does not contain the column then put that column configuration in it
            if(!map.containsKey(curr.col))
            {
                map.put(curr.col, new TreeMap<>());
            }

            // now if the subsequent map does not contain the row then put that row configuration in it
            if(!map.get(curr.col).containsKey(curr.row))
            {
                map.get(curr.col).put(curr.row, new PriorityQueue<>());
            }

            // finally get to the priority queue based on the col => row order and add it 
            map.get(curr.col).get(curr.row).add(curr.node.val);

            // if left child of the node is present add it to the queue
            if(curr.node.left != null)
            {
                // left child means reduce the column of given node by 1
                queue.add(new Tuple(curr.node.left, curr.row + 1, curr.col - 1));
            }

            // if right child of the node is present add it to the queue
            if(curr.node.right != null)
            {
                // right child means increase the horizontal distance of given node by 1
                queue.add(new Tuple(curr.node.right, curr.row + 1, curr.col + 1));
            }

            // row in either case will get incremented only
        }

        // create the 2d arraylist to store the traversal
        List<List<Integer>> verticaltraversal = new ArrayList<>();

        // iterate the outer map by taking its inner value portion since the treemap is used the column or say horizontal distance will be sorted based on its integer value
        for(TreeMap<Integer, PriorityQueue<Integer>> vertical : map.values())
        {
            // temporary arraylist to store all nodes at each horizontal distance
            ArrayList<Integer> temp = new ArrayList<>();

            // now iterate the inner map by taking its inner value portion containing priorty queue to obtain the nodes and since the tree map us used the row or say vertical distance will be sorted based on its integer value
            for(PriorityQueue<Integer> horizontal : vertical.values())
            {
                // get each proiroty queue at different rows for a particular column and then add it in the temporary arraylist to store one traversal
                while(!horizontal.isEmpty())
                {
                    temp.add(horizontal.poll());
                }
            }

            // add the traversal obtained for a particular column to the answer 2d array list
            verticaltraversal.add(temp);
        }

        return verticaltraversal;
    }
}
