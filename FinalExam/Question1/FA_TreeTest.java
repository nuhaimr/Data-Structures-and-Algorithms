/**
 * DSA Final Assessment Question 1 - FA_TreeTest.java
 *
 * Name : Nuha Imran
 * ID   : 20696366
 *
 **/
public class FA_TreeTest
{
	public static void main(String args[])
	{
		System.out.println("\n##### Question 1: Testing Trees #####\n");
               DSAqueue que1 = new DSAqueue();
		FA_BinarySearchTree tree = new FA_BinarySearchTree();
		
		tree.insert(10);
		tree.insert(6);
		tree.insert(11);
		tree.insert(2);
		tree.insert(3);
		tree.insert(12);
		tree.insert(13);
		
		System.out.println("Is tree empty: " + tree.isEmpty());
		System.out.println("");
		tree.colourOddValuesWrapper();
		tree.inOrdWrapper();
		
		
		System.out.println("");
		tree.printOddLevels();
		
			
		System.out.println("\n##### Tests Complete #####\n");

	}
	
}
