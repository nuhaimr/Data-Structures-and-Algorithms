import java.util.Scanner;
import java.util.*;
public class Factorial
{
        //wrapper method
        public static long validate(int a)
        {
                if (a < 0)
                {
                        throw new IllegalArgumentException("Dont enter a negative value.");
                }
                else
                {
                        return Factorial(a);
                }
        }

        private static long Factorial( int n )
        {
                long factorial = 1; 
                //base case
                if ( n == 0 ) 
                        factorial = 1; 
                else
                        factorial = n * Factorial( n-1 ); 
                return factorial;
        }
        public static void main(String []args)
        {
                try{
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Enter an Integer please?");
                        int n = sc.nextInt();
                        System.out.println(validate(n));
                }catch(IllegalArgumentException e){
                        System.out.println("No negative numbers");
                }
                catch(InputMismatchException e)
                {
                        System.out.println("Enter integers only");
                }
        }
}
