import java.util.*;

public class DSAstack{
        int count;
        // To store stack contents
        Object stack[];
        final int DEFAULT_CAPACITY = 100;

        // Default constructor to create stack
        public DSAstack()
        {
                // Allocates memory of size maxLen
                stack = new Object[DEFAULT_CAPACITY];
                count = 0;
        }

        // constrcutor with parameter to create stack
        public DSAstack(int maxCapacity)
        {
                stack = new Object[maxCapacity];
                count = 0;
        }

        public boolean isFull()
        {
                if(count == stack.length)
                        return true;
                else
                        return false;
        }

        public boolean isEmpty()
        {
                return (count == 0);
        }

        public int getCount()
        {
                return count;
        }

        public void push(Object item)
        {
                try
                {
                        if(isFull())
                                throw new IndexOutOfBoundsException();

                        else
                                stack[count] = item;
                                count += 1;
                }
                catch(IndexOutOfBoundsException ie)
                {
                        System.out.println("Stack: Overflow Exception");
                }
        }

        public Object pop()
        {
                Object value = 0;
                try
                {
                        
                        if(isEmpty())
                                throw new IndexOutOfBoundsException();
                    
                        value = top();
                        count -= 1;
                }
                catch(IndexOutOfBoundsException ie)
                {
                        System.out.println("Stack: Underflow Exception");
                }

                return value;
        }

        public Object top() {

                Object topVal = 0;

                if(isEmpty())
                {
                        System.out.println("Stack is empty");
                        throw new EmptyStackException();
                }
                else
                {
                        topVal = stack[count-1];
                }
                return topVal;
        }

        public void printStack() {
                for (int i = 0; i < count; i++) {
                        System.out.println(stack[i]);
                }
        }
}
