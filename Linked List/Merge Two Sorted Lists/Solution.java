class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if both lists are empty return null
        if(list1 == null && list2 == null)
        {
            return null;
        }
        // if one list is empty then return other list
        else if(list1 == null)
        {
            return list2;
        }
        else if(list2 == null)
        {
            return list1;
        }
        // if both list are not null
        else
        {
            // make a new pointer head for merged list and a last pointer for adding elements to the list
            ListNode list3 = null;
            ListNode last = null;

            // for the first node bring both head and last on them and make last next null and increment the respective list pointer
            if(list1.val < list2.val)
            {
                list3 = list1;
                last = list1;
            
                list1 = list1.next;
                last.next = null;
            }
            else
            {
                list3 = list2;
                last = list2;

                list2 = list2.next;
                last.next = null;
            }

            // now continue the process of merging until one list ends
            while(list1 != null && list2 != null)
            {
                // increase the merged list size by connecting the last next to the respective list pointer and bring last on that respective list node and then increment the respective list pointer to its next and make the last next as null
                if(list1.val < list2.val)
                {
                    last.next = list1;
                    last = list1;

                    list1 = list1.next;
                    last.next = null;
                }
                else
                {
                    last.next = list2;
                    last = list2;

                    list2 = list2.next;
                    last.next = null;
                }
            }

            // if any list is non empty then just attach the whole list to the last next adn form the complete merged list as list3 pointer being the head
            if(list1 != null)
            {
                last.next = list1;
            }
            else if(list2 != null)
            {
                last.next = list2;
            }

            return list3;
        }

        // the node merged should hold smaller value so compare between the nodes of list1 and list2
    }
}
