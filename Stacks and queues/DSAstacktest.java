import java.util.*;

public class DSAstacktest{

       public static void main(String[] args) {
           //pushing elements into the stack
           DSAstack stack1 = new DSAstack(4);
           stack1.push(6);
           stack1.push(7);
           stack1.push(8);  
           stack1.push(10); 

           System.out.println("Stack has " + stack1.getCount() + "elements \n");
           System.out.println("Is the stack empty:" + stack1.isEmpty() + "\n");
           System.out.println("Is the stack full:" + stack1.isFull() + "\n ");
           stack1.printStack();
          
           System.out.println("Element has been removed " + stack1.pop() + "\n");
           System.out.println("Element is on top of stack " + stack1.top() + "\n");
           System.out.println("Total number of elements now: " + stack1.getCount() + "\n");
           stack1.printStack();
       }
}

