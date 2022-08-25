import java.util.*;

public class DSAQueue<E> extends AbstractQueue<E>
{
    //classfield
    private LinkedList<E> queue;
    
    public DSAQueue()
    {
        queue = new LinkedList<E>();
    }

    public int size()
    {
        return queue.size();
    }

    public String toString()
    {
        return queue.toString();
    } 

    // add an element to the back of the queue
    public boolean offer( E inValue )
    {
        queue.addLast( inValue );

        return true;
    }
     
    //returns element at front returns null when queue is empty
    public E poll()
    {
        return (E)queue.pollFirst();
    }

    //gives first values
    public E peek()
    {
        return (E)queue.peekFirst();
    }
    
       public Iterator<E> iterator()
    {
        return queue.iterator();
    }

}
