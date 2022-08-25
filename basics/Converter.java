import java.util.Scanner;
import java.util.*;
public class Converter {

        private static char symbols[] = new char[] { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T' };

        public static void main ( String args[] )
        {
                try{
                        Scanner sc = new Scanner(System.in);
                        int number;
                        int base;
                        System.out.println("Enter the base you want to convert to?");
                        base = sc.nextInt();
                        System.out.println("Enter the number you want to convert to?");
                        number = sc.nextInt();
                        Converter converter = new Converter ();

                        System.out.println( converter.convert ( number, base ));
                }
                catch(IllegalArgumentException e){
                        System.out.println("No negative numbers");
                }
                catch(InputMismatchException e)
                {
                        System.out.println("Enter integers only");
                }
        }
        //wrapper method
        public String convert ( int number, int base )
        {
                return convert(number, base, 0, "" );
        }

        private String convert ( int number, int base, int position, String result )
        {
                if(number < 0)
                {
                        throw new IllegalArgumentException("No negative numbers please");
                }
                //base case
                else if(number == 0)
                {
                        return Integer.toString(0);
                }
                else if(base > 16)
                {
                        throw new IllegalArgumentException("Sorry you cannot do that");
                }

                else if ( number < Math.pow(base, position + 1) )
                {
                        return symbols[(number / (int)Math.pow(base, position))] + result;
                }
                else
                {
                        int remainder = (number % (int)Math.pow(base, position + 1));
                        return convert (  number - remainder, base, position + 1, symbols[remainder / (int)( Math.pow(base, position) )] + result );
                }
        }
}
