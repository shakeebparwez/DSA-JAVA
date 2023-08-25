import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
       // 2d list to store the pascal triangle
       List<List<Integer>> pascalTriangle = new ArrayList<>();

       // add first row containing one element
       pascalTriangle.add(new ArrayList<>(Arrays.asList(1)));

       // adding further rows required
       for(int i = 2; i <= numRows; i++)
       {
            // temp array list to store the new row
            ArrayList<Integer> temp = new ArrayList<>();

            // index to previous row
            int lastRow = pascalTriangle.size() - 1;

            // generating the new row with elements equivalent to row number
            for(int j = 0; j < i; j++)
            {
                int numOne = 0;
                int numTwo = 0;

                // logic to get the two numbers directly above the number to be generated using previous row
                if(j - 1 >= 0)
                {
                    numOne = pascalTriangle.get(lastRow).get(j - 1);
                }
                if(j <= pascalTriangle.get(lastRow).size() - 1)
                {
                    numTwo = pascalTriangle.get(lastRow).get(j);
                } 

                // adding the two numbers to get the required element and adding to the temporary array list
                temp.add(numOne + numTwo);
            }

            // finally adding the generated row to 2d list
            pascalTriangle.add(temp);
       }

       return pascalTriangle; 
    }
}