class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // if empty list return null
        if(head == null)
        {
            return head;
        }
        
        // find the length of linked list and form a circular linked list connecting the last node to first node
        ListNode tempHead = head;
        int length = 1;

        while(tempHead.next != null)
        {
            length++;
            tempHead = tempHead.next;
        }

        tempHead.next = head;

        // number of roatations actually needed is k modulo length
        int number_of_rotations_required = k % length;

        // now we have to reach the length - number_of_rotations node in order to make that the head node and its previous as ending node
        int count = length - number_of_rotations_required;

        ListNode prev = null;
        ListNode curr = head;
        
        while(count > 0)
        {
            prev = curr;
            curr = curr.next;
            count--;
        }

        prev.next = null;
        head = curr;

        // return the new head
        return head;
    }
}