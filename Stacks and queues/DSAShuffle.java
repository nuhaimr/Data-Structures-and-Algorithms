import java.util.*;

public class DSAShuffle extends DSAqueue{

        public DSAShuffle(int maxc){
                super(maxc);
        }

        public DSAShuffle()
        {
                queueArray = new Object[DEFAULT_CAPACITY];
                count = 0;
        }

        //ACCESSSOR (GETTER)
        public int getCount()
        {
                return count;
        }

        public int getLength()
        {
                return queueArray.length;
        }

        public boolean isEmpty() {
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
                boolean full;

                if (count == getLength()) {
                        full = true;
                } else {
                        full = false;
                }
                return full;
        }

        //MUTATOR (SETTER)
        public void enqueue(Object value)
        {
                if (isFull()) {
                        throw new StackOverflowError("ErrorQueue is full");
                } else {
                        queueArray[count] = value;
                        count += 1;
                        System.out.println(value + " has been added");
                }
        }

        public void dequeue()
        {
                if (isEmpty()) {
                        System.out.println("Error  Queue is empty");
                        throw new EmptyStackException();
                } else {
                        System.out.println("The element removed is  " + peek());
                        for (int ii = 0; ii < queueArray.length-1; ii++) {
                                queueArray[ii] = queueArray[ii+1];
                        }
                        count -=1;
                }
                
        }

        public Object peek() {
                Object frontVal = 0;

                if (isEmpty()) {
                        System.out.println("Error Queue is empty");
                        throw new EmptyStackException();
                } else {
                        frontVal = queueArray[0];
                }
                return frontVal;
        }

        public void printStack() {
                for (int i = 0; i < count; i++) {
                        System.out.println(queueArray[i]);
                }
        }
}





