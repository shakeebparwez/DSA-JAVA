class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // if there are no nodes in the linked list
        if(head == null)
        {
            return head;
        }
        

        // assign two pointers slow and fast to the head of the linked list
        ListNode fast = head;
        ListNode slow = head;
        
        // fast stays one step ahead slow
        fast = fast.next;

        // iterate the linked list
        while(fast != null)
        {
            // if fast is pointing to the same value as slow then make slow next point to the fast next and move fast ahead thus removing the duplicate node
            if(fast.val == slow.val)
            {
                slow.next = fast.next;
                fast = fast.next;
            }
            // if it is not duplicate then just simply increment both slow and fast pointer
            else
            {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return head;
    }
}