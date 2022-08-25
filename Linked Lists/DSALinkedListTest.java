import java.util.*;
import java.util.Scanner;
import java.io.*;

public class DSALinkedListTest implements Serializable{

        public static void save(DSALinkedList objToSave, String filename)
        {
                FileOutputStream fileStrm;
                ObjectOutputStream objStrm;
                try {
                        fileStrm = new FileOutputStream(filename);  
                        objStrm = new ObjectOutputStream(fileStrm); 
                        objStrm.writeObject(objToSave);  

                        objStrm.close();  
                } 
                catch (Exception e) { 
                        throw new IllegalArgumentException("Unable to save object to file"); 
                }
        } 

        public static DSALinkedList load(String filename) throws IllegalArgumentException 
        {
                FileInputStream fileStrm;
                ObjectInputStream objStrm; 
                DSALinkedList inObj = null;
                try {
                        fileStrm = new FileInputStream(filename); 
                        objStrm = new ObjectInputStream(fileStrm); 
                        inObj = (DSALinkedList)objStrm.readObject();
                        objStrm.close();
                } 
                catch (ClassNotFoundException e) {
                        System.out.println("Class ContainerClass not found");
                } 
                catch (Exception e) {
                        throw new IllegalArgumentException("Unable to load object from file"); 
                } 
                return inObj;
        } 


        public static void main(String[] args){
                DSALinkedList list = new DSALinkedList();
                String filen;
                int choice;

                list.insertLast(1);
                list.insertLast(2);
                list.insertLast(3);
                list.insertLast(6);
                list.insertFirst(4);
                list.insertFirst(5);

                System.out.println("First val: " + list.peekFirst());
                System.out.println("Last val: " + list.peekLast());


                list.removeLast();
                list.removeFirst();

                Scanner sc = new Scanner(System.in);
                try{

                        System.out.println("Menu option \n 1.Write a serialised file \n 2. Display the list \n 3.Read a serialised file");
                        choice = sc.nextInt();
                        if(choice == 1){
                                System.out.println("Enter a filename?");
                                filen = sc.next();

                                save(list, filen);
                        }

                        else if(choice == 2){
                                for(Object ob: list){
                                        System.out.println(ob);
                                }
                        }

                        else if(choice == 3){
                                System.out.println("Enter a filename?");
                                filen = sc.next();
                               
                                DSALinkedList list1 = load(filen);
                                for(Object ob: list1){
                                System.out.println(ob);
                                }
                                
                        }
                        
                        else{
                        System.out.println("Invalid choice");
                        }
                }
                catch(Exception e){
                        System.out.println("File not found");
                }
        }
}

