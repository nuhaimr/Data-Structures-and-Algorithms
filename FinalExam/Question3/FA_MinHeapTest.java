public class FA_MinHeapTest
{
	public static void main(String args[])
	{
		System.out.println("\n##### Question 3: Testing Heaps #####\n");
		
		FA_MinHeap testHeap = new FA_MinHeap();
		try{
		for (int i=0; i<10; i++)
		{
			testHeap.add(i,i);
			System.out.println("Added "+i);
		}
		}catch(PracExamException e){
		System.out.println("Heap is full");
		}
		try{
		int temp;
		
		for (int i=0; i<10; i++)
		{
			temp = (Integer)testHeap.remove();
			System.out.println(temp);
		}
		}
		catch(PracExamException e){
		System.out.println("Heap is empty");
		}
		System.out.println("\n##### Tests Complete #####\n");
	}
}
