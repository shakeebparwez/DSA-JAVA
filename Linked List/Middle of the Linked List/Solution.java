class Solution {
    public ListNode middleNode(ListNode head) {
        // assign two pointer slow and fast to the linked list
        ListNode slow = head;
        ListNode fast = head;

        // iterate the linked list by moving fast pointer twice and slow pointer once
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // after the iteration slow pointer will be pointing to the middle of the linked list
        return slow;
    }
}