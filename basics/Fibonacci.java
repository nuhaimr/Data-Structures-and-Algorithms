import java.util.Scanner;
import java.util.*;
public class Fibonacci
{
        private static int fibRecursive(int n)
        {
                int fibVal = 0;
                if (n == 0)
                        fibVal = 0;
                else if (n == 1)
                        fibVal = 1; 
                else {
                        fibVal = fibRecursive(n-1) + fibRecursive(n-2);
                }
                return fibVal;
        }
        public static int validate(int a)
        {
                if(a < 0)
                        throw new IllegalArgumentException("Please enter positive integer?");
                else
                        return fibRecursive(a);
        }
        public static void main(String[] args)
        {
                try{
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Please enter a new integer?");
                        int n = sc.nextInt();
                        System.out.println(validate(n));
                }catch(IllegalArgumentException e)
                {
                        System.out.println("No negative inputs");
                }
                catch(InputMismatchException e)
                {
                        System.out.println("Enter integers only");
                }

        }
}
