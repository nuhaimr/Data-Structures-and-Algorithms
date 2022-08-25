import java.util.*;

public class DSAQueueTest{
        public static void main(String[] args){
                //creating object
                DSAQueue<Integer> queue = new DSAQueue<Integer>();
                
                queue.add(1);
                queue.add(6);
                queue.add(10);
                queue.add(12);
                queue.add(20);
                
                System.out.println("Elements in queue: " + queue.size());
                 
                System.out.println("Removing element: " + queue.poll());
                
               System.out.println("Display first element of queue: " + queue.peek());
               
               
            
                
               for(Object ob: queue){
               System.out.println("Displaying the queue: " + ob);
               }
               
         
               
               
               

      
        }
}

