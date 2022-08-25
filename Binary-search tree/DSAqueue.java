import java.io.Serializable;
import java.util.*;

public class DSAqueue implements Iterable, Serializable{
/*if you enqueue 1,2,3 itll put as 1,2,3 when you dequeue it will remove 1 queue FIFO*/
         private DSALinkedList list;
         
         public DSAqueue(){
         list = new DSALinkedList();
         }
        
      

        
        
        public boolean isEmpty()
        {
                return list.isEmpty();
        }

     
        public Object peek()
        {
            return list.peekFirst();   
        }

       
        public void enqueue(Object value)
        {
                list.insertLast(value);
        }

        public Object dequeue()
        {       
                Object element;
                list.peekFirst();
                element = list.removeFirst();
                return element;
        }

        
        public Object remove()
        {
              return list.removeLast();
        }

        public Iterator iterator() {
                return list.iterator(); // Expose list’s iterator
        }
        
      
        }

