class BubbleSort
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
        //code here
        for(int i = 0; i < n; i++) // number of passes
        {
            boolean flag = false;
            
            for(int j = 0; j < n - 1 - i; j++) // start from first element upto the element that is not at its right place
            {
                if(arr[j] > arr[j + 1]) // if the current element is greater then next element
                {
                    // swap it downwards so that smaller elements bubble up
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    
                    flag = true;
                }
            }
            
            // if no swap happened that means it is already sorted
            if(flag == false) break;
        }
    }
    
    // Time Complexity: O(n^2), O(n) [Already sorted]
    // Properties: Adaptive, Stable
}