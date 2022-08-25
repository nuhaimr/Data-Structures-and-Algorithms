import java.util.*;

public class DSABinarySearchTest {
  public static void main(String[] args) {
    DSABinarySearchTree tree = new DSABinarySearchTree();

    tree.insert(6, "E");
    tree.insert(8, "B");
    tree.insert(10, "C");
    tree.insert(12, "A");
    tree.insert(14, "G");
    tree.insert(19, "F");
    tree.insert(4, "H");


    tree.balanced();
    System.out.println("");
    tree.display();
    System.out.println("A's value is: " + tree.find("A"));

    tree.insert(20, "S");
    

    System.out.println("");
    tree.balanced();

    //tree.display();

    System.out.println("");
    tree.delete("S");

    
    System.out.println("");
    tree.balanced();
    System.out.println("");
    tree.display();

    System.out.println("The height of the tree is: " + tree.height());
    System.out.println("The minium key is: " + tree.min());
    System.out.println("The maxium height is: " + tree.max());
  }
}
