class Solution  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2)  
    { 
         // code here.
         
         // two empty trees are isomorphic
         if(root1 == null && root2 == null)
         {
             return true;
         }
         
         // one empty and one non empty tree are not isomorphic
         if(root1 == null || root2 == null)
         {
             return false;
         }
         
         // if both trees are non empty we check for 3 condtions
         
         // condition 1 => data of r1 == data of r2
         if(root1.data != root2.data)
         {
             return false;
         }
         
         // left child of r1 ~ left child of r2 && right child of r1 ~ right child of r2
         boolean condition2 = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
         
         // left child of r1 ~ right child of r2 && right child of r1 ~ left child of r2
         boolean condition3 = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
         
         // if either of condition 2 and condition 3 is true then return true
         if(condition2 || condition3)
         {
             return true;
         }
         else
         {
             return false;
         }
    }
    
} 