import java.util.*;
import java.io.*;
/**
 * DSA Final Assessment Question 3 - MaxHeapTest.java
 *
 * Name : Nuha Imran
 * ID   : 20696366
 *
 **/
 
public class MaxHeapTest
{
	public static void main(String args[])
	{
	
	FA_Heap testHeap = new FA_Heap();
	try{
	int temp1;
	FA_Heap tempHeap = new FA_Heap();
	        String filename;
	       Scanner sc = new Scanner(System.in);
	       System.out.println("Enter the file name that needs to be stored as a heap.");
	       filename = sc.next();
	       tempHeap.FileIO(filename, 17);
	       for(int i = 0;i < 17; i++){
	       
	       temp1 = (Integer)tempHeap.remove();
			System.out.println(temp1);
	       }
	       }catch(PracExamException e){
		System.out.println("Unable to remove values");
		}
	       
	       
	      
	       try{
		System.out.println("\n##### Question 3: Testing Heaps #####\n");
		
		
		
		for (int i=0; i<10; i++)
		{
			testHeap.add(i,i);
			System.out.println("Added "+i);
		}
		}
		catch(PracExamException e){
		System.out.println("Heap is full");
		}
		
		try{
		int temp;
		
		for (int i=0; i<10; i++)
		{
			temp = (Integer)testHeap.remove();
			System.out.println(temp);
		}
		System.out.println("\n##### Tests Complete #####\n");
	}
	catch(PracExamException e){
		System.out.println("Heap is empty");
		}
		}
	
	
}
