class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // initializzing the head and last pointers of result list to be made
        ListNode l3 = null;
        ListNode last = null;

        // initial carry is zero
        int carry = 0;

        // iterate till either of the lists gets over
        while(l1 != null || l2 != null)
        {
            // if the list has not become null then store the node value else store a zero
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;

            // sum will be l1 node + l2 node + carry generated from previous sum
            int result = l1_val + l2_val + carry;

            // carry can be obtained by dividing the result by 10
            carry = result / 10;

            // after getting carry update the result on 0 - 9 scale by dividing with mod 10
            result = result % 10;

            // create a node with the the result value
            ListNode temp = new ListNode(result);

            // if l3 is null temp is the first node so bring l3 and last on the temp node
            if(l3 == null)
            {
                l3 = temp;
                last = temp;
            }
            // else just join the last next pointer to temp and bring last on the temp
            else
            {
                last.next = temp;
                last = temp;
            }

            // keep on moving the pointers on both the list while they don't become null
            if(l1 != null)
            {
                l1 = l1.next;
            }

            if(l2 != null)
            {
                l2 = l2.next;
            }
        }

        // after the whole addition if there is some carry present
        if(carry > 0)
        {
            // create a node with the value of carry
            ListNode temp = new ListNode(carry);

            // attach it to the resultant list
            last.next = temp;
            last = temp;
        }

        return l3;
    }
}