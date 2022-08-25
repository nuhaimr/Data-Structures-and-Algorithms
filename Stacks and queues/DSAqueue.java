import java.util.*;

public class DSAqueue{

        
        protected Object queueArray[] ;
        protected int front;
        protected int rear;
        protected int size;
        protected int len;
        final int DEFAULT_CAPACITY = 100;
        protected int count;

        // Default Constructor
        public DSAqueue()
        {
               
                size = DEFAULT_CAPACITY;
                len = 0;
                queueArray = new Object[DEFAULT_CAPACITY];
                front = -1;
                rear = -1;

                count = 0;
        }

        //Constructor with paramters
        public DSAqueue(int n)
        {
                size = n;
                len = 0;
                queueArray = new Object[size];
                front = -1;
                rear = -1;

                count = 0;
        }

        public int getCount()
        {
                return count;
        }

        public int length()
        {
                return queueArray.length;
        }
        
        public boolean isEmpty()
        {
                boolean empty;

                if (count == 0) {
                        empty = true;
                } else {
                        empty = false;
                }
                return empty;
        }

      
        public boolean isFull()
        {
                return front == 0 && rear == size - 1 ;
        }

        public Object getSize()
        {
                return len ;
        }

     
        public Object peek()
        {
                Object value = 0;
                try
                {
                        if (isEmpty())
                                throw new IndexOutOfBoundsException();
                        value = queueArray[0];
                }

                catch(IndexOutOfBoundsException ie)
                {
                        System.out.println("Queue: Underflow Exception");
                }

                return value;
        }

       
        public void insert(Object value)
        {
                try
                {
                        if (rear == -1)
                        {
                                front = 0;
                                rear = 0;
                                queueArray[rear] = value;
                        }

                     
                        else if (rear + 1 >= size)
                                throw new IndexOutOfBoundsException();
                        else if ( rear + 1 < size)
                               
                                queueArray[++rear] = value;
                        len++;
                }

                catch(IndexOutOfBoundsException ie)
                {
                        System.out.println("Queue: Overflow Exception");
                }
        }

        public void enqueue(Object value)
        {
                if (isFull()) {
                        throw new StackOverflowError("Queue: Queue is full");
                } else {
                        queueArray[count] = value;
                        count += 1;
                }
        }

        public void dequeue()
        {
                if (isEmpty()) {
                        System.out.println("Queue: Queue is empty");
                        throw new EmptyStackException();
                } else {
                        for (int i = 0; i < queueArray.length-1; i++) {
                                queueArray[i] = queueArray[i+1];
                        }
                        count -=1;
                }
        }

        
        public Object remove()
        {
                Object value = null;
                try
                {
                        if (isEmpty())
                                throw new IndexOutOfBoundsException();
                        else
                        {
                                len-- ;
                                Object element = queueArray[front];
                                if ( front == rear)
                                {
                                        front = -1;
                                        rear = -1;
                                }

                              
                                else
                                        front++;
                                value = element;
                        }
                }
                catch(IndexOutOfBoundsException ie)
                {
                        System.out.println("Queue: Underflow Exception");
                }
                return value;
        }

        public void printStack()
        {
                for (int i = 0; i < count; i++) {
                        System.out.println(queueArray[i]);
                }
        }
}
