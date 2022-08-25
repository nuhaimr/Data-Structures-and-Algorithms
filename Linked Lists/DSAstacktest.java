import java.util.*;

public class DSAstacktest{

       public static void main(String[] args) {
           //pushing elements into the stack
           DSAstack stack1 = new DSAstack();
           stack1.push(6);
           stack1.push(7);
           stack1.push(8);  
           stack1.push(10); 

        
           System.out.println("Is the stack empty:" + stack1.isEmpty() + "\n");
         
           
          
           System.out.println("Element has been removed " + stack1.pop() + "\n");
           System.out.println("Element is on top of stack " + stack1.top() + "\n");
          
           stack1.iterator();
           for(Object ob : stack1){
           System.out.println(ob);
           }
       }
}

