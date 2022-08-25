public class TestHarnessFibFac{
        //for average purposes
        private static final int REPEATS = 4;

        private static void usage(){
        System.out.println("Usage : java TestHarnessFibFac n x");
        System.out.println("Where n is number you want analysis for");
        System.out.println("Where x is the choice");
        System.out.println("a - factorial Iterative");
        System.out.println("b - factorial Recursive");
        System.out.println("c - fibonacci Iterative");
        System.out.println("d - fibonacci Recursive");
        }
        
        public static void main(String[] args){
                int n;
                char choiceType;
                if(args.length < 2)
                        usage();
                else
                {
                        n = Integer.parseInt(args[0]);
                        choiceType = args[1].charAt(0);

                
                double runningTotal = 0;
                for (int repeat = 0 ; repeat < REPEATS ; repeat++){
                long startTime = System.nanoTime();
                switch(choiceType)
                {
                        case 'a' : IterativeFactorial.getFactorialIterative(n);
                        break;
                        case 'b' : RecursiveFactorial.getFactorial(n);
                        break;
                        case 'c' : IterativeFibonacci.getFibIterative(n);
                        break;
                        case 'd' : RecursiveFibonacci.getFibonacci(n);
                        break;
                        default : throw new IllegalArgumentException("Unsupported sort type " + choiceType);
                }
                long endTime = System.nanoTime();
                runningTotal += (int)((double)(endTime - startTime) / 1000.0);
             }
             System.out.println((runningTotal/ (REPEATS - 1)));
             }

        }
}
