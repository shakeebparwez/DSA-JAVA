public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // inititalize two pointers on respective heads
        ListNode tempA = headA;
        ListNode tempB = headB;

        // iterate while they do not intersect
        while(tempA != tempB)
        {
            // if one of the list finishes assign the temporary pointer of that list to the other list head
            if(tempA == null)
            {
                tempA = headB;
            }
            else
            {
                tempA = tempA.next;
            }

            if(tempB == null)
            {
                tempB = headA;
            }
            else
            {
                tempB = tempB.next;
            }
            // else keep moving the temporary pointer till they point same node or become null at the same time
        }

        // this works based on length difference approach
        // the shorter list finishes early while the pointer on longer list still has some nodes to cover
        // the shorter list pointer then covers the larger list steps while the larger list finishes thus compensating the length difference
        // then the larger list pointer starts on shorter list making it in sync with smaller list pointer on longer list

        return tempA;
    }
}