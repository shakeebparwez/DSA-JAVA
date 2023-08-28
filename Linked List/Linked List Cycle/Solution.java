public class Solution {
    public boolean hasCycle(ListNode head) {
        // use two pointer approach of slow and fast
        ListNode slow = head;
        ListNode fast = head;

        // move fast pointer twice the speed of slow
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            // if slow and fast become equal that means there is a cycle
            if(slow == fast)
            {
                return true;
            }
        }

        // if fast becomes null that means there is no cycle
        return false;
    }
}