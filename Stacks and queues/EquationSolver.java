import java.util.Scanner;

public class EquationSolver {


        //just a method to check precedence
        private static int precedenceOf(char theOp) {
                int num = 0;

                if ((theOp == '+') || (theOp == '-')) {
                        num = 1;
                } else if ((theOp == '*') || (theOp == '/')) {
                        num = 2;
                }
                return num;
        }

        private static double evaluatePostfix(DSAqueue queue) {
                DSAstack stack1 = new DSAstack();

                double num = 0;
                double num1 = 0;
                double num2 = 0;

                while (!queue.isEmpty()) {
                        if ((String.valueOf(queue.peek()).equals("+")) || (String.valueOf(queue.peek()).equals("-")) || (String.valueOf(queue.peek()).equals("*")) || (String.valueOf(queue.peek()).equals("/"))) {
                                num1 = Double.parseDouble(String.valueOf(stack1.pop()));
                                num2 = Double.parseDouble(String.valueOf(stack1.pop()));
                                num = solve(String.valueOf(queue.peek()), num1, num2);
                                stack1.push(num);
                        } else {
                                stack1.push(queue.peek());
                        }
                        queue.dequeue();
                        stack1.printStack();
                }
                return Double.parseDouble(String.valueOf(stack1.top()));
        }

        public static double solve(String op, double b, double a) {
                switch (op) {
                        case "+":
                                return a + b;
                        case "-":
                                return a - b;
                        case "*":
                                return a * b;
                        case "/":
                                if (b == 0)
                                        throw new
                                                UnsupportedOperationException("Cannot divide by zero");
                                return a / b;
                }
                return 0;
        }


        public static void solveEQ(String equation) {
                System.out.println("---------------------------");
                System.out.println("Equation: " + equation);
                DSAqueue q = new DSAqueue(12);
                q = parseInfix2Postfix(equation);
                q.printStack();
                Object n = evaluatePostfix(q);
                System.out.println("Answer: " + n);
        }

        private static DSAqueue parseInfix2Postfix(String equation) {
                //queues and stacks to store operands and operators
                DSAstack stack = new DSAstack();
                DSAqueue queue = new DSAqueue();
                //this string is for user input basically
                String[] array = equation.split(" "); 
                for (String ob : array) {
                        /*checking if it is not all this then it is a number then just parse it and add it to the queue*/
                        if (!ob.equals("+") && !ob.equals("-") && !ob.equals("/") && !ob.equals("*") && !ob.equals("(")
                                        && !ob.equals(")")) {
                                queue.enqueue(Double.parseDouble(ob));
                                /*if its these operators add to stacks and queues accordinly*/  
                        } else if (ob.equals("(")) {
                                char val = ob.charAt(0);
                                stack.push(val); 
                        } else if (ob.equals(")")) {
                                char val = ob.charAt(0);
                                while (!stack.isEmpty()) {
                                        char p = (char) stack.pop(); 
                                        if (p != '(') {

                                                queue.enqueue(p);
                                        } else {
                                                break;
                                        }
                                }
                                /* if its equal to all this and stack is empty push it all to stack then check the precedence and push and pop accordinly*/
                        } else if (ob.equals("+") || ob.equals("-") || ob.equals("/") || ob.equals("*")) {
                                char ch = ob.charAt(0);
                                if (stack.isEmpty()) {
                                        stack.push(ch); 
                                } else {
                                        while (!stack.isEmpty()) {
                                                char p = (char) stack.pop();
                                                if (p == '(') {
                                                        stack.push(p);
                                                        break;
                                                } else if (p == '+' || p == '-' || p == '*' || p == '/') {
                                                        if (precedenceOf(p) < precedenceOf(ch)) {
                                                                stack.push(p);
                                                                break;
                                                        } else {

                                                                queue.enqueue(p); 
                                                        }
                                                }
                                        }
                                        stack.push(ch);
                                }
                        }
                }

                while (!stack.isEmpty()) {

                        queue.enqueue(stack.pop());
                }

                return queue;
        }

        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                String s1 = "( 10.3 * ( 14 + 3.2 ) ) / ( 5 + 2 - 4 * 3 )";
                String s2 = "2 * 3 * 4";
                String s3 = "100 * 2 + 12";
                String s4 = "100 * ( 2 + 12 )";
                String s5 = "100 * ( 2 + 12 ) / 14";


                solveEQ(s1);
                solveEQ(s2);
                solveEQ(s3);
                solveEQ(s4);
                solveEQ(s5);
        }
}
