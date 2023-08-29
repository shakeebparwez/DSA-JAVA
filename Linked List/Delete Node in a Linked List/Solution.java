class Solution {
    public void deleteNode(ListNode node) {
        // deleting of the given node is not possible but we can delete the next node by storing its value in the given node
        int data = node.next.val;
        node.val = data;

        // join the given node next to the next of next node thus deleting the next node
        ListNode next_of_next_node = node.next.next;
        node.next = next_of_next_node;
    }
}