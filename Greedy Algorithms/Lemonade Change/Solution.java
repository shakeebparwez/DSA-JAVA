class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count_5 = 0;
        int count_10 = 0;

        for(int i = 0; i < bills.length; i++)
        {
            // keep count of 5 dollar note
            if(bills[i] == 5)
            {
                count_5++;
            }
            
            // check if you can return change for 10 dollar note
            if(bills[i] == 10)
            {
                if(count_5 < 0)
                {
                    return false;
                }
                else
                {
                    count_10++;
                    count_5--;
                }
            }

            // in case of 20 dollar note try first to give 10 dollar note else check for 5 dollar note availability
            if(bills[i] == 20)
            {
                if(count_10 > 0 && count_5 > 0)
                {
                    count_10--;
                    count_5--;
                }
                else if(count_5 > 2)
                {
                    count_5 -= 3;
                }
                else
                {
                    return false;
                }
            }
        }

        return true;
    }
}