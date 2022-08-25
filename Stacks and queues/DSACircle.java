public class DSACircle extends DSAqueue{
public DSACircle(int maxc){
super(maxc);
}

        private int maxc;


        public DSACircle()
        {
                queueArray = new Object[DEFAULT_CAPACITY];
                count = 0;
                maxc = 100;
        }

public void enqueue(Object item){
        if(isFull()){
                throw new IllegalArgumentException("queue is full");
        }
        else
        {
                if ((rear == front) && (front == -1))
                {
                        front += 1;
                }
                rear = (rear + 1) % maxc;
                queueArray[rear] = item;
                count += 1;
        }
}

public void dequeue(){
        if(isEmpty()){
                throw new IllegalArgumentException("queue is empty");
                }
        else
        {
                System.out.println("The element removed is  " + peek());
                if (rear == front) {
                        rear = 1;
                        front = 1;
                } else {
                        front = (front + 1) % maxc;
                }
                count -= 1;
                }
        }

        public void printStack() {
                for (int i = 0; i < count; i++) {
                        System.out.println(queueArray[i]);
                }
        }
}


