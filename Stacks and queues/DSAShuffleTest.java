import java.util.*;

public class DSAShuffleTest{
        public static void main(String[] args){
                DSAShuffle queue1 = new DSAShuffle();

                queue1.enqueue(4);
                queue1.enqueue(9);
                queue1.enqueue(10);
                queue1.enqueue(19);

                
                
                System.out.println("Elements in queue " + queue1.getCount() + "\n");

                System.out.println("Stack is empty: " + queue1.isEmpty());

                System.out.println("Stack is full: " + queue1.isFull()); 

                queue1.dequeue();

                System.out.println("Elements in queue " + queue1.getCount()     + "\n");
                
                queue1.dequeue();
                
                System.out.println("Elements in queue " + queue1.getCount()     + "\n");
                
                
        }
}
