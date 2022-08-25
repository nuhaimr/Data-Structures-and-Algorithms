//Nuha Imran
//20696366

public class IterativeFactorial{

 public static int getFactorialIterative(int a)
        {
                if(a < 0)
                        throw new IllegalArgumentException("Please enter positive integer?");
                else
                        return FactorialIterative(a);
        }
 private static int FactorialIterative(int n){
 int nFactorial = 1;
 for(int i = n;i >= 2;i--){
 nFactorial  *= i;

 }
 return nFactorial;
 }



/*public static void main(String[] args){
        IterativeFactorial fac = new IterativeFactorial();
        System.out.println(fac.getFactorialIterative(4));

}*/
}
