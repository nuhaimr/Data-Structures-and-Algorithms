import java.util.*;

public class callStack
{
        public static void main(String[] args)
        {
                DSAstack stack = new DSAstack();
                call1(stack);
                int a = 1;
                recursion(a, stack);
        }
         //function calling a function
        public static void call1(DSAstack stack){
                stack.push("call1(DSAstack stack)");
                stack.printStack();

                System.out.println("");
                call2(stack);
                stack.pop();
                System.out.println("");
                stack.printStack();
        }

        public static void call2(DSAstack stack){
                stack.push("call2(DSAstack stack)");
                stack.printStack();

                System.out.println("");
                call3(stack);
                stack.pop();
                System.out.println("");
                stack.printStack();
        }

        public static void call3(DSAstack stack){
                stack.push("call3(DSAstack stack)");
                stack.printStack();

                System.out.println("");
                stack.pop();
                System.out.println("");
                stack.printStack();
        }
    //recursion call
       public static void recursion(int a,DSAstack stack){
               if(a < 3){
                       stack.push("recursion(" + "int" + a + ",DSAstack stack)");

                       System.out.println("");
                       stack.printStack();
                       recursion(a + 1,stack);
}
                       else if(a >= 3 && a <= 4){
                               stack.pop();
                               System.out.println("");
                               stack.printStack();
                               recursion(a + 1, stack);
                       }

               }
       


}



