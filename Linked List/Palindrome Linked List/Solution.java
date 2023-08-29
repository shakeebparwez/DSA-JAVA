class Solution {
    private ListNode reverseLL(ListNode head)
    {
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

    public boolean isPalindrome(ListNode head) {
        // use fast and slow pointer approach to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        // maintain a tail pointer in order to separate the linked list into left and right portion
        ListNode tail = head;

        // finding middle of the linked list so that slow points on mid
        while(fast != null && fast.next != null)
        {
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // spearate the list into two portion by making previous of slow next to null
        tail.next = null;

        // prepare the head pointers for two separated linked lists 
        ListNode rightPointer = reverseLL(slow);
        ListNode leftPointer = head;

        // start comparing the values whether they are equal or not until one list finishes
        while(rightPointer != null && leftPointer != null)
        {
            // if values are not found to be equal return false
            if(rightPointer.val != leftPointer.val)
            {
                return false;
            }

            rightPointer = rightPointer.next;
            leftPointer = leftPointer.next;
        }

        // return true if it is a valid palindrome
        return true;
    }
}
