import java.util.*;
import java.io.*;
/**
 * DSA Final Assessment Question 3 - FA_Heap.java
 *
 * Name : Nuha Imran
 * ID   : 20696366
 *
 **/
 
public class FA_MinHeap
{

	public class FA_HeapEntry
	{
	private int priority;
	private Object value;

	public FA_HeapEntry(int priority, Object value)
	{
		this.priority = priority;
		this.value = value;
	}

	public int getPriority()
	{
		return priority;
	}
	
	public Object getValue()
	{
	       return value;
	}

	}

	private FA_HeapEntry[] heap;
	private int count;
	private int MAXSIZE = 17;
	
	
	public FA_MinHeap()
	{
		heap = new FA_HeapEntry[MAXSIZE];
		count = 0;	
	}


	public void add(int priority, Object value) throws PracExamException
	{
	  
	        if(count == MAXSIZE){
	        throw new PracExamException("Heap is full");
	        }
		FA_HeapEntry entry = new FA_HeapEntry(priority,value);
		heap[count] = entry;
		count++;
		trickleUp(count-1);
		
		
	}

	public int remove() throws PracExamException
	{
	        if(count == 0){
	        throw new PracExamException("Heap is Empty!");
	        }
		int retValue;
		FA_HeapEntry entry = heap[0];
		retValue = entry.getPriority();
		heap[0] = heap[count-1];
		heap[count-1] = null;
		count--;
		trickleDown(0);
		return retValue;
	}

	private void trickleDown(int index)
	{
	   int leftIdx = index * 2 + 1;
	   int rightIdx = leftIdx + 1;
	   int largeIdx;
	   FA_HeapEntry temp;

	   if (leftIdx < count)
		{
		largeIdx = leftIdx;			
		if (rightIdx < count)
		{
           //this will be change for minheap because now we want minium not maxium
		   if (heap[leftIdx].getPriority() > heap[rightIdx].getPriority())
			{
				largeIdx = rightIdx;
			}
		}
        //same change here aswell but flipped
		if (heap[largeIdx].getPriority() <  heap[index].getPriority())
		{
              	temp = heap[largeIdx];
              	heap[largeIdx] = heap[index];
              	heap[index] = temp;
			trickleDown(largeIdx);
		}	
	   }
	}
	
	private void trickleUp(int index)
	{
		int parentIndex;
		FA_HeapEntry temp;

		parentIndex = (index-1)/2;

		if (index > 0 )
		{
            //this will be changed aswell for minHeap
			if (heap[index].getPriority() <  heap[parentIndex].getPriority())
			{
				temp = heap[parentIndex];
				heap[parentIndex] = heap[index];
				heap[index] = temp;
				trickleUp(parentIndex);
			}
		}
		
	}
}	
