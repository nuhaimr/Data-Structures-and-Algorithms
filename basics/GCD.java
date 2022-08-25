import java.util.Scanner;
import java.util.*;

public class GCD {

    public static void main(String args[]) {
try{
        // Enter two number whose GCD needs to be calculated.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first number to find GCD?");
        int a = scanner.nextInt();
        System.out.println("Please enter second number to find GCD?");
        int b = scanner.nextInt();

        System.out.println("GCD of two numbers " + a + " and "
                + b + " is :" + validate(a, b));

        scanner.close();
        }
        catch(IllegalArgumentException e){
System.out.println("Please dont enter a negative number");
        }
        catch(InputMismatchException e){
        System.out.println("Please enter integers only");
        }
        
    }

    public static int validate(int number1, int number2) {
        if (number1 < 0 || number2 < 0) {
            throw new IllegalArgumentException("No negative numbers please!");
        } else {
            return findGCD(number1, number2);
        }
    }

    private static int findGCD(int number1, int number2) {
        // base case to stop stackoverflow
        if (number2 == 0) {
            return number1;
        }
        // method calling itself
        else {
            return findGCD(number2, number1 % number2);
        }
    }
}

