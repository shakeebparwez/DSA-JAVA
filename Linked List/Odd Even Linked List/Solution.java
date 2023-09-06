class Solution {
    public ListNode oddEvenList(ListNode head) {
        // handle 0 size and 1 size linked list case
        if(head == null)
        {
            return null;
        }

        if(head.next == null)
        {
            return head;
        }

        // maintain odd and even heads and tails respectively
        ListNode oddHead = null;
        ListNode oddTail = null;

        ListNode evenHead = null;
        ListNode evenTail = null;

        // iterate the list using temporary pointer
        ListNode temp = head;
        
        int index = 1;

        while(temp != null)
        {
            // if odd then add it in the odd list
            if(index % 2 == 1)
            {
                if(oddHead == null)
                {
                    oddHead = temp;
                    oddTail = temp;
                }
                else
                {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }
            // if even then add it in the even list
            else
            {
                if(evenHead == null)
                {
                    evenHead = temp;
                    evenTail = temp;
                }
                else
                {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            }

            temp = temp.next;
            index++;
        }

        // merge both the list using the odd tail and even head
        oddTail.next = evenHead;
        evenTail.next = null;

        return oddHead;
    }
}