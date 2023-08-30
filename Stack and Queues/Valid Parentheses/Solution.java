class Solution {
    public boolean isValid(String s) {
        
        // create a stack to store opening brackets
        Stack<Character> stk = new Stack();

        // iterate the string
        for(int i = 0; i < s.length(); i++)
        {
            char bracket = s.charAt(i);

            // if opening bracket is found we push it into the stack
            if(bracket == '(' || bracket == '{' || bracket == '[')
            {
                stk.push(bracket);
            }
            else
            {
                // if closing bracket is found we check for same opening bracket type for that particular closing bracket type
                if(!stk.isEmpty())
                {
                    // if the same opening bracket is found simply pop the opening bracket from the stack
                    if((stk.peek() == '(' && bracket == ')') || (stk.peek() == '{' && bracket == '}') || (stk.peek() == '[' && bracket == ']'))
                    {
                        stk.pop();
                    }
                    // else the expression is invalid
                    else
                    {
                        return false;
                    }
                }
                // if no bracket is present in stack and we encountering a closing bracket then also the expression is false
                else
                {
                    return false;
                }
            }
        }

        // if the the stack is empty after the full iteration that means all parentheses are balanced
        if(stk.isEmpty())
        {
            return true;
        }
        // else the expression is invalid since some extra opening brackets are present
        else
        {
            return false;
        }
    }
}