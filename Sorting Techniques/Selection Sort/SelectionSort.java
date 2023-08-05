class SelectionSort
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        
        // initalize the pointers to the point to begin searching from
        int j = i;
        int k = i;
        
        while(j < arr.length)
        {
            if(arr[j] < arr[k]) // updating k whenever a smaller element is found than previous one
            {
                k = j;
            }
            j++;
        }
        
        return k;
	}
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    for(int i = 0; i < n - 1; i++) // total number of passes
	    {
	        int small = select(arr, i); // select the smallest element index
	        
	        // swap it with current element
	        int temp = arr[i];
	        arr[i] = arr[small];
	        arr[small] = temp;
	    }
	}
}

// Time Complexity: O(n^2)
// Properties: Not Adaptive, Not Stable