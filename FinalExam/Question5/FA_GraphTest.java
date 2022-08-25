/**
 * DSA Final Assessment Question 5 - GraphTest.java
 *
 * Name : 
 * ID   :
 *
 **/
public class FA_GraphTest
{
	public static void main(String args[])
	{
			System.out.println("\n##### Question 5: Testing Graphs #####\n");

			// put your code here
			FA_Graph g = new FA_Graph();

			g.addEdge("one", "two", 1);
			g.addEdge("one", "three", 2);
			g.addEdge("one", "four", 3);
			g.addEdge("four", "two", 4);
			g.addEdge("four", "three", 5);
			
			g.displayAsList();

		    FA_Graph g1 = new FA_Graph();

			g1.FileIO(g1, "FA_GraphData.txt");

			g1.displayAsList();


			System.out.println("\n##### Tests Complete #####\n");

	}
	
}