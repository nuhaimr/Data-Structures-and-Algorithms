import java.util.*;

public class DSAqueueTest{
        public static void main(String[] args){
                //creating object
                DSAqueue queue1 = new DSAqueue();

                queue1.enqueue(4);
                queue1.enqueue(9);
                queue1.enqueue(10);
                queue1.enqueue(19);

                
                
         

                System.out.println("Stack is empty: " + queue1.isEmpty());

                

                queue1.dequeue();
                
                queue1.iterator();
           for(Object ob : queue1){
           System.out.println(ob);
           }
                
                
        }
}

