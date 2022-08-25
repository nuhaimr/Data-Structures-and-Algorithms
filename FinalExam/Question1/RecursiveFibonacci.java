//submitted in Prac02 by me
public class RecursiveFibonacci{    

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
        public static int getFibonacci(int a)
        {
                if(a < 0)
                        throw new IllegalArgumentException("Please enter positive integer?");
                else
                        return fibRecursive(a);
        }
}
