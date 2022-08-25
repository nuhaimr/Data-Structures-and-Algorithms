import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*Reading the first column of the csv file,converting that arraylist into an array,sorting it and writting it to the file*/
public class InsertionSort
{
    static List<Integer> studentids = new ArrayList<>();

    static List<Sorting> students = new ArrayList<>();

    public static void main(String[] args)
    {
        //File Reading Reference:JAVATPOINT

        String line = "";
        String splitBy = ",";
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("RandomNames7000.csv"));

            int array[] = new int[1];
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] StudentId = line.split(splitBy);    // use comma as separator
                int n = StudentId.length;
                studentids.add(Integer.parseInt(StudentId[0]));

                Sorting sorting = new Sorting();
                sorting.setStudentName(StudentId[1]);
                sorting.setStudentID(Integer.parseInt(StudentId[0]));
                students.add(sorting);

            }

            //Reference:StackOverflow
            Integer[] arr = new Integer[studentids.size()];

            for (int i = 0; i < studentids.size(); i++)
            {
                arr[i] = studentids.get(i);
            }
            int n = studentids.size();

for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
           


            //Reference:GeekforGeeks
            FileWriter geek_file;

            try

            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("file name: ");
                String filename = scanner.next();
                geek_file = new FileWriter("" + filename);

                BufferedWriter geekwrite = new BufferedWriter(geek_file);

                for (int i = 0; i < arr.length; i++) {
                    geekwrite.write(Integer.toString(arr[i]) + ",");
                    geekwrite.write(getName(arr[i]));
                    geekwrite.newLine();
                }

                geekwrite.close();

                System.out.println("Written successfully");

            }

            catch (IOException except)

            {

                except.printStackTrace();

            }

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    public static String getName(int id)
    {
        String name = "";

        for (Sorting sorting: students)
        {
            if (id == sorting.getStudentID())
            {
                name = sorting.getStudentName();
            }
        }

        return name;
    }



}

