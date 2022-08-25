import java.util.*;

public class DSAstack implements Iterable{

        // To store stack contents
        /*push 1,2,3 in stack stores as 3 2 1 value put first stored as last,when pop itll remove 3 STACK LIFO*/
        private DSALinkedList list;
        
        public DSAstack(){
        list = new DSALinkedList();
        }

        public boolean isEmpty()
        {
                return list.isEmpty();
        }

        public void push(Object item)
        {
                list.insertFirst(item);
        }

        public Object pop()
        {
                list.peekFirst();
                return list.removeFirst();
        }

        public Object top() {
                return list.peekFirst();

        }

        public Iterator iterator() {
                return list.iterator(); // Expose list’s iterator
        }
}

