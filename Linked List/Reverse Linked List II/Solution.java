class Solution {
    // function to reverse the linked list
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


    public ListNode reverseBetween(ListNode head, int left, int right) {
        // prev pointer points before the first in order to fix the connections after reversing using the first as head
        ListNode prev = null;
        
        // first and last pointers to point on the range of linked list to be reversed
        ListNode first = head;
        ListNode last = head;

        // count used to bring the first and last to their required position
        int count = 1;

        while(count < left)
        {
            prev = first;
            first = first.next;
            count++;
        }

        last = first;

        while(count < right)
        {
            last = last.next;
            count++;
        }

        // tail pointer points after the last and is used to make the connection complete after reversing the middle portion of linked list
        ListNode tail = last.next;
        last.next = null;

        if(prev != null)
        {
            // if prev is present then its next will point to the new first returned after reversing
            prev.next = reverseLL(first);
        }
        else
        {
            // if first is itself the head node then update the head accordingly
            head = reverseLL(first);
        }

        // now join the first which became last after reversing to the tail of linked list
        first.next = tail;

        return head;
    }
}