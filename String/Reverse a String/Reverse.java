class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        
        // convert the string to char array
        char ch[] = str.toCharArray();
        char temp;
        
        // run the loop upto half of the string length
        for(int i = 0; i < str.length() / 2; i++)
        {
            // swap the left side character with the right side of the character
            temp = ch[i];
            ch[i] = ch[str.length() - 1 - i];
            ch[str.length() - 1 - i] = temp;
        }
        
        // create the new reverse string and return
        return new String(ch);
    }
}