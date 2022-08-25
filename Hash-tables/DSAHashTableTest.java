import java.io.*;
import java.util.*;

public class DSAHashTableTest {
    public static void main(String[] args) {
        DSAHashTable table = new DSAHashTable(4);
        table.put("14495655", "Sofia");
        table.put("14224671", "Ashlee");

        Object value = table.get("14495655");
        System.out.println("14495655: " + value);
        System.out.println("");
        table.put("20622086", "Sanat");
        table.put("20696366", "Nuha");
        table.put("12345678", "Sara");
        table.put("87654321", "Fathima");
        table.put("51015200", "Pratyay");
        table.put("61218243", "Random");

        table.export();
        System.out.println("");
        table.remove("61218243");
        table.remove("14224671");
        table.remove("14495655");
        table.remove("51015200");
        table.remove("87654321");

        table.export();

        System.out.println("\n\n\n\n\n\n");



        String filename;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your file name?");
        filename = sc.next();
        DSAHashTable entry = FileIO(filename);

        System.out.println("Enter a filename to write?");

        sc.nextLine();
        filename = sc.nextLine();
        writer(entry, filename);

        sc.close();
    }


    public static DSAHashTable FileIO(String filename) {
        DSAHashTable table = new DSAHashTable(7000);
        try {
            Scanner input = new Scanner(new File(filename));

            // read the file
            while (input.hasNextLine()) {
                String data = input.nextLine();

                String entry[] = data.split(" ");
                // insert the nodes
                table.put(entry[0], entry[1]);
            }
            // table.export();
            table.export();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return table;
    }
    
    public static void writer(DSAHashTable table, String filename) {
        Scanner sc1 = new Scanner(System.in);
        try {
            FileOutputStream fileStrm = new FileOutputStream(filename);
            PrintWriter pw = new PrintWriter(fileStrm);
            DSAHashEntry array[] = table.printArray();

            for (int i = 0; i < array.length; i++) {
                if (array[i].getState() == 1) {
                    pw.println(array[i].getKey() + array[i].getValue());
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc1.close();
    }
}
