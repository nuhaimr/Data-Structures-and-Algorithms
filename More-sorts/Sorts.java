import java.util.*;
/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
      int n = A.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (A[j] > A[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
     
    }//bubbleSort()

    // selection sort
    //sorts Reference:GeeksforGeeks
    public static void selectionSort(int[] A)
    {
     int n = A.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (A[j] < A[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = A[min_idx];
            A[min_idx] = A[i];
            A[i] = temp;
        }
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
    int n = A.length;
        for (int i = 1; i < n; ++i) {
            int key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
        }
     
    }// insertionSort()
    public static void mergeSort(int[] A)
    {
     mergeSortRecurse( A, 0, A.length - 1 );
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    int midIdx;

        if( leftIdx < rightIdx )
        {
            midIdx = ( leftIdx + rightIdx ) / 2;

            mergeSortRecurse( A, leftIdx, midIdx );
            mergeSortRecurse( A, midIdx + 1, rightIdx );
            merge( A, leftIdx, midIdx, rightIdx );
        }

    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
     int[] tempArr = new int[ rightIdx - leftIdx + 1 ];
        int i = leftIdx;
        int j = midIdx + 1;
        int k = 0;

        while( ( i <= midIdx ) && ( j <= rightIdx ) )
        {
            if( A[i] <= A[j] )
            {
                tempArr[k] = A[i];
                i++;
            }
            else
            {
                tempArr[k] = A[j];
                j++;
            }
            k++;
        }

        for( int ii = i; i <= midIdx; i++ )
        {
            tempArr[k] = A[i];
            k++;
        }

        for( int jj = j; j <= rightIdx; j++ )
        {
            tempArr[k] = A[j];
            k++;
        }

        for( int kk = leftIdx; kk <= rightIdx; kk++ )
        {
            A[kk] = tempArr[ kk - leftIdx ];
        }
    }//merge()


    public static void quickSort(int[] A)
    {
    quickSortRecurse( A, 0, A.length - 1 );
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    int pivIdx;
        int newPivIdx;
        if( rightIdx > leftIdx )
        {
            pivIdx = leftIdx;
            newPivIdx = doPartitioning( A, leftIdx, rightIdx, pivIdx );

            quickSortRecurse( A, leftIdx, newPivIdx - 1 );
            quickSortRecurse( A, newPivIdx + 1, rightIdx );
        }
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
    {
        int currIdx;
        int pivVal;
        int temp;
        int newPivIdx;
        
        pivVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivVal;

        currIdx = leftIdx;

        for( int i = leftIdx; i <= rightIdx - 1; i++ )
        {
            if( A[i] < pivVal )
            {
                temp = A[i];
                A[i] = A[currIdx];
                A[currIdx] = temp;

                currIdx++;
            }
        }

        newPivIdx = currIdx;
        A[rightIdx] =  A[newPivIdx];
        A[newPivIdx] = pivVal;

        return newPivIdx;
		
    }//doPartitioning


}
  public static void quickSortMedian3( int[] A )
    {
        quickSortMedian3Recurse( A, 0, A.length - 1 );
    }
 
    // Recursive algortithm for quick sort
    private static void quickSortMedian3Recurse( int[] A, int leftIdx, int rightIdx )
    {
        int pivIdx;
        int newPivIdx;

        // Check that the array length is > 1
        if( rightIdx > leftIdx )
        {
            pivIdx = med3( A, leftIdx, rightIdx, ( leftIdx + rightIdx ) / 2 );
                // Median of three pivot selection
            newPivIdx = doPartitioning( A, leftIdx, rightIdx, pivIdx );

            quickSortRecurse( A, leftIdx, newPivIdx - 1 );
                // Recurse Left
            quickSortRecurse( A, newPivIdx + 1, rightIdx );
                // Recurse Right
        }
        
        // Recursive base case is if the `if` is never entered   
    }
     private static int med3( int[] A, int a, int b, int c )
    { 
        int med;

        if( A[a] > A[b] && A[a] > A[c] )
        {
            med = a;
        }
        else if( A[b] > A[a] && A[b] > A[c] )
        {
            med = b;
        }
        else
        {
            med = c;
        }

        return med;
    }
    
    
    //Reference geekforgeeks
    public static void RandomQuickSort( int[] A )
    {
        randomQuickSort( A, 0, A.length - 1 );
    }
    
    private static void random(int A[],int leftidx,int rightidx)
    {
     
        Random rand= new Random();
        int pivot = rand.nextInt(rightidx-leftidx)+leftidx;
         
        int temp1=A[pivot]; 
        A[pivot]=A[rightidx];
        A[rightidx]=temp1;
    }
    private static int partition(int A[], int leftidx, int rightidx)
    {
        random(A,leftidx,rightidx);
        int pivot = A[rightidx];
     
 
        int i = (leftidx-1);
        for (int j = leftidx; j < rightidx; j++)
        {
            if (A[j] < pivot)
            {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[rightidx];
        A[rightidx] = temp;
 
        return i+1;
    }
 
    private static void randomQuickSort(int A[], int leftidx, int rightidx)
    {
        if (leftidx < rightidx)
        {
            int pi = partition(A, leftidx, rightidx);
            randomQuickSort(A, leftidx, pi-1);
            randomQuickSort(A, pi+1, rightidx);
        }
    }
 
    
    
}
//end Sorts calss
