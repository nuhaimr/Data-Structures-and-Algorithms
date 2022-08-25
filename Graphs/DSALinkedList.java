import java.util.*;
import java.io.*;


public class DSALinkedList implements Iterable, Serializable{
    private class DSAListNode implements Serializable { // Private inner class //Every node has a value and pointing to next
        private Object value; // node data
        private DSAListNode next;// new node
        private DSAListNode prev; // previous node

        // could make the classfields public as they can
        // only be seen inside DSALinkedList
        public DSAListNode(Object inValue) {
            value = inValue;
            next = null;
            prev = null;// to create a new node you initialise next as null because there prolly is no
                        // next
        }

        public Object getValue() {
            return value;// get the data
        }

        public void setValue(Object inValue) {
            value = inValue;
        }

        public DSAListNode getNext() {
            return next; // get the next
        }

        public void setNext(DSAListNode newNext) {
            next = newNext;
        }

    }

    public DSAListNode head;
    public DSAListNode tail;

    // Default constructor
    public DSALinkedList() {
        head = null;
        tail = null;
    }
    
    public void insertLast(Object newValue) {
        DSAListNode newNd = new DSAListNode(newValue);
        if (isEmpty()) {
            head = newNd;
        } else {
        //new node added after tail tails next pointer poiting to new node
            tail.setNext(newNd);
            //new nd prev pointing to tail
            newNd.prev = tail;
        }
        //new node is new tail
        tail = newNd;
    }

    public void insertFirst(Object newValue) {
        DSAListNode newNd = new DSAListNode(newValue);
        if (isEmpty()) {
            tail = newNd;
        } else {
        //new node added before head heads pointer poiting to prev node
            head.prev = newNd;

        }
        //new node is new head
        newNd.setNext(head);
        head = newNd;
    }

    public boolean isEmpty() {
        boolean empty;
        if (head == null) {
            empty = true;
        } else {
            empty = false;
        }
        return empty;
    }

    public Object peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            Object nodeValue = head.getValue();
            return nodeValue;
        }

    }

    public Object peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            Object nodeValue = tail.getValue();
            return nodeValue;
        }

    }

    public Object removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        DSAListNode currNd = head;
        Object nodeValue = currNd.getValue();
        if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        currNd.next = null;
        return nodeValue;

    }

    public Object removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        DSAListNode currNd = tail;
        Object NodeValue = currNd.getValue();
        if (head == tail) {
            head = null;
        } else {
            tail.prev.setNext(null);
        }
        tail = tail.prev;
        currNd.prev = null;
        return NodeValue;
    }

   
   
  
    
         
                public Iterator iterator() { 
                        return new DSALinkedListIterator(this); 
                } 
        private class DSALinkedListIterator implements Iterator { 
                private DSAListNode iterNext; 
                        public DSALinkedListIterator(DSALinkedList theList) { 
                                iterNext = theList.head; 
                                         }
                                        // Iterator interface implementation
                                        public boolean hasNext() {
                                         return (iterNext != null); 
                                         }
                                        public Object next() { 
                                        Object value; 
                                        if (iterNext == null) 
                                                value = null; 
                                        else { 
                                                value = iterNext.getValue(); 
                                                        iterNext = iterNext.getNext(); 
                                        } 
                                        return value; 
                                } 
                                public void remove() {
                                throw new UnsupportedOperationException("Not supported"); 
                                } 
                        } 
                        
                        
        }
        
      
        
        
        
   
