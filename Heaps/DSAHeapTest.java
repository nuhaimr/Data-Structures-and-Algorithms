import java.util.*;
import java.io.*;

public class DSAHeapTest{


    public static DSAHeap FileIO(String filename,int size) {
        DSAHeap heap = new DSAHeap(size);
        try {
            Scanner input = new Scanner(new File(filename));

            
            while (input.hasNextLine()) {
                String data = input.nextLine();

                String entry[] = data.split(",");
                
                heap.add(Integer.parseInt(entry[0]), entry[1]);
            }
            
           
          

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return heap;
    }
    
    public static void writer(DSAHeap heap, String filename) {
        Scanner sc1 = new Scanner(System.in);
        try {
            FileOutputStream fileStrm = new FileOutputStream(filename);
            PrintWriter pw = new PrintWriter(fileStrm);
            DSAHeapEntry array[] = heap.heapSort();

            for (int i = 0; i < array.length; i++) {
                   
                    pw.println(array[i].getValue() + " " + array[i].getPriority());
                
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc1.close();
    }
    public static void main(String[] args){
    
     Scanner sc = new Scanner(System.in);
     int size;
     System.out.println("Size of your Heap?");
     size = sc.nextInt();

     DSAHeap heap = new DSAHeap(size);
     
     heap.add(1, "Nuha");
     heap.add(2, "Sara");
     heap.add(3, "Sanat");
     heap.add(4, "Fathima");
     heap.add(5, "Pratyay");

     heap.printArray();
     
     System.out.println("\n");
     
     
     System.out.println("Value being removed: " + heap.remove().getValue());
    
     heap.heapSort();
     
     System.out.println("\n");
     
     heap.printArray();
     
     String filename;
        
        System.out.println("Enter your file name?");
        filename = sc.next();
        DSAHeap entry = FileIO(filename,size);

        System.out.println("Enter a filename to write?");

        sc.nextLine();
        filename = sc.nextLine();
        writer(entry, filename);

        sc.close();

}

}
