import java.util.*;
/**
 * DSA Final Assessment Question 4 - FA_HashTest.java
 *
 * Name : Nuha Imran
 * ID   : 20696366
 *
 **/

public class FA_HashTest
{
	public static void main(String args[])
	{
		System.out.println("\n##### Question 4: Testing Hash Tables #####\n");
                //no longer a need to make object of class
		HashMap<String, Object> tab = new HashMap<String, Object>();

		String[] data = {"11111110", "11111101", "11111011", "11110111", "11101111", "11011111", "10111111", "01111111"};

        for (int i=0; i < data.length; i++)
		{
			tab.put(data[i], "O"+data[i]);
		}		

		System.out.println("Table size is: " + tab.size() );
		
		System.out.println(tab);
		//no such thing as load factor needed in HashMaps no such function in built in hashmaps
		/*System.out.println("Load Factor is: " + tab.getLoadFactor() );*/
		
		System.out.println("\n##### Tests Complete #####\n");
	}
}
