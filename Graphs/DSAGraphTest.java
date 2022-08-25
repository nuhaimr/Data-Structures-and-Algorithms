import java.util.*;

public class DSAGraphTest{
        public static void main(String[] args){
                DSAGraph graph = new DSAGraph();

                //vertices
                graph.addVertex("0");
                graph.addVertex("1");
                graph.addVertex("2");
                graph.addVertex("3");
                graph.addVertex("4");

                graph.addEdge("0","1");
                graph.addEdge("1","2");
                graph.addEdge("2","3");
                graph.addEdge("3", "4");
                graph.addEdge("0", "4");
                graph.addEdge("1", "3");
                graph.addEdge("1", "4");



                graph.displayAsList();

                DSALinkedList list = graph.breadthfirst();
                for(Object ob: list){
                        System.out.println(ob);
                }

                System.out.println(" ");

                DSALinkedList list1 = graph.depthfirst();
                for(Object obj: list1){
                        System.out.println(obj);
                }
                
                System.out.println(" ");



                String filename;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your file name?");
                filename = sc.next();
                graph.FileIO(filename);
        }

}
