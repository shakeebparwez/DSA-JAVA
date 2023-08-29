public class Solution {
    public ListNode detectCycle(ListNode head) {
        // using fast and slow pointer first detect the loop
        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                hasCycle = true;
                break;
            }
        }

        // if the linked list has cycle

        // intuition is observed as follow

        // distance by fast pointer = 2 * distance by slow pointer
        // A + x * C + B = 2 * (A + y * C + B)

        // A -> non cycle distance
        // x and y -> number of cycles moved
        // C -> full cycle distance
        // B -> the distance moved within cycle before meeting

        // A + B = k * C
        // C = B - A;

        if(hasCycle == true)
        {
            // therefore we make slow pointer go to head and make it move A distance to reach the starting point
            slow = head;

            // after both slow and fast pointer moving A distance will definitely meet at the starting point of cycle
            while(slow != fast)
            {
                slow = slow.next;

                // fast starting from B distance also has to move A distance in order to complete the cycle
                fast = fast.next;
            }
            
            // return either slow or fast as they both will be pointing at the same
            return slow;
        }
        else
        {
            // if no cycle found then return null
            return null;
        }
    }
}