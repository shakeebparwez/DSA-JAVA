class Solution {
    public Node copyRandomList(Node head) {
        // TC: O(N) & SC: O(N) Approach using HashMap
        
        // first simply create a straight clone list using orignal list next pointer
        Node cloneHead = null;
        Node cloneTail = null;

        Node temp = head;

        while(temp != null)
        {
            Node newNode = new Node(temp.val);

            if(cloneHead == null)
            {
                cloneHead = newNode;
                cloneTail = newNode;
            }
            else
            {
                cloneTail.next = newNode;
                cloneTail = newNode;
            }

            temp = temp.next;
        }

        // create a mapping between the orignal list nodes and cloned list nodes
        HashMap<Node, Node> oldNodeToNewNode = new HashMap<>();

        Node orignalNode = head;
        Node clonedNode = cloneHead;

        while(orignalNode != null && clonedNode != null)
        {
            oldNodeToNewNode.put(orignalNode, clonedNode);
            orignalNode = orignalNode.next;
            clonedNode = clonedNode.next;
        }

        // now make the cloned nodes random point to corresponding mapping of orignal node random in the cloned list
        orignalNode = head;
        clonedNode = cloneHead;

        while(orignalNode != null && clonedNode != null)
        {
            clonedNode.random = oldNodeToNewNode.get(orignalNode.random);
            orignalNode = orignalNode.next;
            clonedNode = clonedNode.next;
        }

        return cloneHead;
    }
}