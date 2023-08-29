class Solution {
    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = null;
        ListNode fast = head;

        while(fast != null)
        {
            prev = curr;
            curr = fast;
            fast = fast.next;

            curr.next = prev;
        }

        return curr;
    }

    public ListNode removeNodes(ListNode head) {
        // reverse the linked list
        ListNode revHead = reverseLL(head);

        // two pointers inorder to remove the elements
        ListNode curr = revHead;
        ListNode prev = revHead;

        // store the maximum from left side for the reverse list as it will be same as getting the maximum from right side for the actual list
        int max_element = 0;
        max_element = Math.max(max_element, curr.val);
        curr = curr.next;

        // iterate the linked list
        while(curr != null)
        {
            // if the node value is lesser than the max value delete the curr node
            if(curr.val < max_element)
            {
                prev.next = curr.next;
                curr = curr.next;
            }
            // else simply increment both the prev and curr pointers and update the max element value found on left side
            else
            {
                max_element = Math.max(max_element, curr.val);
                prev = curr;
                curr = curr.next;
            }
        }

        // reverse the linked list again to form the required answer
        head = reverseLL(revHead);

        return head;
    }
}