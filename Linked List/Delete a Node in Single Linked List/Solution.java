class Solution
{
    Node deleteNode(Node head, int x)
    {
	    // Your code here
	    // two pointers required for deleting a node in linked list
	    
	    Node curr = head;
	    Node prev = null;
	    
	    // if it is the first node to be deleted simply increment the head pointer
	    if(x == 1)
	    {
	        curr = curr.next;
	        head.next = null;
	        head = curr;
	    }
	    else
	    {
	        int count = 1;
	        
	        // reach the node to be deleted with a tailing previous pointer
	        while(count != x)
	        {
	            prev = curr;
	            curr = curr.next;
	            count++;
	        }
	        
	        // join the previous next to curr next and make the curr next to null
	        prev.next = curr.next;
	        curr.next = null;
	    }

	    return head;
    }
}