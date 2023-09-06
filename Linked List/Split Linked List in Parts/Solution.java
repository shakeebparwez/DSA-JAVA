class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // create the split array to store the heads of each split portion
        ListNode[] split = new ListNode[k];

        // if list is empty simply return the array containing null
        if(head == null)
        {
            return split;
        }

        // calculate the length of linked list
        ListNode temp = head;
        int length = 0;

        while(temp != null)
        {
            length++;
            temp = temp.next;
        }

        // find the quotient that is the minimum number of nodes in each sub list
        int quotient = length / k;

        // remainder will be the extra nodes that are left out
        int remainder = length % k;

        // start splitting the list into k parts
        ListNode curr = head;
        ListNode prev = null;

        for (int i = 0; i < k; i++) 
        {
            // add the current head of the list
            split[i] = curr;

            // spread the remainder equally to all starting sublists till the remainder is finished
            int partSize = quotient + (i < remainder ? 1 : 0);

            // create the sub list of required part size
            for (int j = 0; j < partSize; j++) 
            {
                prev = curr;
                curr = curr.next;
            }

            // terminate the list so that it is independent list
            prev.next = null;
        }

        return split;
    }
}