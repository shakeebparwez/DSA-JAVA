class Clone {
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        
        // TC: O(N) & SC: O(1) Approach using Link Modification
        
        // first simply create a straight clone list using orignal list next pointer
        Node cloneHead = null;
        Node cloneTail = null;
        
        Node temp = head;
        
        while(temp != null)
        {
            Node newNode = new Node(temp.data);
            
            if(cloneHead == null)
            {
                cloneHead = newNode;
                cloneTail = newNode;
            }
            else
            {
                cloneTail.next = newNode;
                cloneTail = newNode;
            }
            
            temp = temp.next;
        }
        
        // add cloned nodes in between the orignal list
        Node orignalNode = head;
        Node cloneNode = cloneHead;
        
        Node front = null;
        
        while(orignalNode != null && cloneNode != null)
        {
            front = orignalNode.next;
            
            orignalNode.next = cloneNode;
            orignalNode = front;
            
            front = cloneNode.next;
            
            cloneNode.next = orignalNode;
            cloneNode = front;
        }
        
        // set the random pointers as the links can be used as mapping now
        temp = head;
        
        while(temp != null)
        {
            if(temp.arb == null)
            {
                temp.next.arb = null;
            }
            else
            {
                temp.next.arb = temp.arb.next;
            }
            
            temp = temp.next.next;
        }
        
        // separate the orignal and cloned lists
        orignalNode = head;
        cloneNode = cloneHead;
        
        while(orignalNode != null && cloneNode != null)
        {
            orignalNode.next = cloneNode.next;
            orignalNode = orignalNode.next;
            
            if(orignalNode != null)
            {
                cloneNode.next = orignalNode.next;
                cloneNode = cloneNode.next;
            }
            else
            {
                cloneNode.next = null;
                cloneNode = cloneNode.next;
            }
        }
        
        return cloneHead;
    }
}
