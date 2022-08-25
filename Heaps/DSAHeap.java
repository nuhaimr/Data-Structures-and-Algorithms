import java.util.*;


class DSAHeapEntry{
        private int priority;
        private Object value;

        //default constructor
        public DSAHeapEntry(){
                priority = 0;
                value = null;
        }

        public DSAHeapEntry(int inPriority,Object inValue){
                priority = inPriority;
                value = inValue;
        }

        public Object getValue(){
                return value;
        }

        public void setValue(Object inValue){
                value = inValue;
        }

        public int getPriority() {
                return priority;
        }

        public void setPriority(int inPriority){
                priority = inPriority;
        }
}

public class DSAHeap{
        private DSAHeapEntry heapArray[];
        private int count;
        private int size;

        public DSAHeap(int maxsize){
                heapArray = new DSAHeapEntry[maxsize];
                for(int i = 0; i < maxsize; i++){
                        heapArray[i] = new DSAHeapEntry();
                }
        }

        private void trickup(int curIdx){
                int parentIdx = (curIdx - 1)/2;
                if (curIdx > 0){
                        if (heapArray[curIdx].getPriority() > heapArray[parentIdx].getPriority()){
                                DSAHeapEntry temp = heapArray[parentIdx];
                                heapArray[parentIdx] = heapArray[curIdx];
                                heapArray[curIdx] = temp;
                                trickup(parentIdx);
                        }
                }
                
        }

        private void trickdown(int curIdx){
                int lchildidx = (curIdx * 2) + 1;
                int rchildidx = (lchildidx + 1);
                int largeidx;
                //base case
                if (lchildidx < size){
                        largeidx = lchildidx;
                        if(rchildidx < size){
                                if(heapArray[lchildidx].getPriority() < heapArray[rchildidx].getPriority()){
                                        largeidx = rchildidx;

                                }
                        }

                
                if(heapArray[largeidx].getPriority() > heapArray[curIdx].getPriority()){
                        DSAHeapEntry temp = heapArray[largeidx];
                        heapArray[largeidx] = heapArray[curIdx];
                        heapArray[curIdx] = temp;
                        trickdown(largeidx);
                }
              
                }
        }
        
        public void add(int priority,Object value){
        DSAHeapEntry entry = new DSAHeapEntry(priority,value);
        heapArray[count] = entry;
        trickup(count);
        count++;
        size++;
        }
        
        public DSAHeapEntry remove(){
        DSAHeapEntry temp = heapArray[0];
        heapArray[0] = heapArray[count];
        int ind = 0;
        trickdown(ind);
        count--;
        size--;
        return temp;
        }
        
        public void printArray(){
        
        for(int i = 0; i < heapArray.length;i++){
        if(heapArray[i].getValue() != null){
        System.out.println(heapArray[i].getPriority());       
        System.out.println(heapArray[i].getValue());
        }
        }
        }
        
        public DSAHeapEntry[] display(){
        heapSort();
        return heapArray;
        }
        
       public void heapify(){
        for(int i = (count/2) -1; i >= 0; i--){
        trickdown(i);
        }
        
        
        }
        
        public DSAHeapEntry[] heapSort(){
        heapify();
        for(int i = (count - 1);i >= 1;i--){
        DSAHeapEntry temp = heapArray[0];
        heapArray[0] = heapArray[i];
        heapArray[i] = temp;
        size--;
        trickdown(0);
        
        }
      
        return heapArray;
        }
        
       
        
        
        
        
        
       
        
        
}











