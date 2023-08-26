class Solution {
    private ListNode iterativeReverse(ListNode head) {
        // initialize three pointers
        ListNode prev = null;
        ListNode curr = null;
        ListNode fast = head;

        // iterate while the fast pointer does not becomes null
        while(fast != null)
        {
            // use the fast pointer to move the curr pointer ahead as curr.next will be changed on modifying the links
            prev = curr;
            curr = fast;
            fast = fast.next;

            // modify the links using the mid pointer that is curr.next to point to prev node and thus reversing the links
            curr.next = prev;
        }

        // return the mid pointer curr as it will be the new head of the reversed linked list
        return curr;
    }

    private ListNode recursiveReverse(ListNode prev, ListNode curr) {
        // when the current pointer reaches null
        if(curr == null)
        {
            // then return the prev pointer as it is the head of new reversed list
            return prev;
        }

        // store the next node pointer
        ListNode nextNode = curr.next;

        // reverse the curr.next point to prev pointer
        curr.next = prev;

        // again recursively call for next node and reverse the links and finally return the prev pointer of the final call
        return recursiveReverse(curr, nextNode);
    }

    public ListNode reverseList(ListNode head) {
        // head = iterativeReverse(head);

        // in recursive we pass two pointer prev and curr
        ListNode prev = null;
        ListNode curr = head;
        head = recursiveReverse(prev, curr);

        return head;
    }
}