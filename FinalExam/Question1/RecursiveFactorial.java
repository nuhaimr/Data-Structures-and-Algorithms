//Nuha Imran
//20696366
//submitted in Prac02 by me
public class RecursiveFactorial{
        public static long getFactorial(int a)
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
}
