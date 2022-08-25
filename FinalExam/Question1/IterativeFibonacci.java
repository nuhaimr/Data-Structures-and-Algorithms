//Nuha Imran
//20696366

public class IterativeFibonacci{

        public static int getFibIterative(int a)
        {
                if(a < 0)
                        throw new IllegalArgumentException("Please enter positive integer?");
                else
                        return fibIterative(a);
        }
        private static int fibIterative(int n){
                int fibVal = 0;
                int currVal = 1;
                int lastVal = 0;

                if(n == 0){
                        fibVal = 0;
                }
                else if(n == 1){
                        fibVal = 1;
                }
                else{
                        for(int i = 2;i < n;i++){
                                fibVal = currVal + lastVal;
                                lastVal = currVal;
                                currVal = fibVal;
                        }
                }
                return fibVal;

        }
        /*public static void main(String[] args){
        IterativeFibonacci fib = new IterativeFibonacci();
        System.out.println(fib.getFibIterative(4));
        
        }*/

}
