import java.util.*;
import java.io.*;

public class DSAGraph{

        private class DSAGraphVertex{
                private String label;
                private DSALinkedList links;
                private boolean visited;


                //constructor
                public DSAGraphVertex(String inLabel){
                        label = inLabel;
                        links = new DSALinkedList();
                        visited = false;
                }

                public String getlabel(){
                        return label;
                }

                public DSALinkedList getAdjacent(){
                        return links;
                }

                public void addEdge(DSAGraphVertex vertex){
                        links.insertLast(vertex);
                        edgeCount++;
                }

                public void setVisited() {
                        visited = true;
                }

                public void clearVisited() {
                        visited = false;
                }

                public boolean getVisited() {
                        return visited;
                }

                public String toString(){
                        String string;
                        string = ("Label = " + label);
                        return string;

                }


        }//end of dsa vertex

        private DSALinkedList vertices;
        private int edgeCount;

        public DSAGraph()
        {
                vertices = new DSALinkedList();
                int edgeCount;
        }

        //taking in import,making it a vertex,adding that vertex to linked list
        public void addVertex(String label){
                DSAGraphVertex v1 = new DSAGraphVertex(label);
                vertices.insertLast(v1);
        }

        public DSAGraphVertex getVertex(String label){
                //setting vertex as null
                DSAGraphVertex vertex = null;
                DSAGraphVertex vertex1 = null;
                //iterating thru vertices
                for(Object object : vertices){
                        //typecasting object to class
                        if ( ( (DSAGraphVertex) object).getlabel().equals(label)){
                                vertex1 = (DSAGraphVertex) object;
                        }
                }

                return vertex1;
        }



        public boolean hasVertex(String label){
                boolean exists = false;

                for(Object object : vertices){
                        if ( ( (DSAGraphVertex) object).getlabel().equals(label)){
                                exists = true;
                        }
                }

                return exists;
        }

        //create 2 null objects call getvertex
        public void addEdge(String label1, String label2){
                if (!hasVertex(label1)){
                        addVertex(label1);
                }
                if (!hasVertex(label2)){
                        addVertex(label2);
                }
                DSAGraphVertex vertex1 = getVertex(label1);
                DSAGraphVertex vertex2 = getVertex(label2);

                vertex2.addEdge(getVertex(label1));
                vertex1.addEdge(getVertex(label2));

                edgeCount++;
        }
        //get vertex count should return the number of vertex that are there in the list
        public int getVertexCount(){
                int count = 0;
                for(Object ob: vertices) {
                        count++;
                }
                return count; 
        }

        public int getEdgeCount(){
                return edgeCount;
        }

        public DSALinkedList getAdjacent(String label){
                //temporary object
                DSAGraphVertex vertex1 = null;
                vertex1 = getVertex(label);
                DSALinkedList list = vertex1.getAdjacent();
                return list;
        }

        public boolean isAdjacent(String label1,String label2){
                DSALinkedList list = null;
                list = getAdjacent(label1);
                for(Object ob: list){
                        if( ((DSAGraphVertex)ob).getlabel() == label2){

                        }

                }
                return true;
        }

        public void displayAsList(){
                DSALinkedList list = null;
                DSAGraphVertex displayVertex = null;
                DSAGraphVertex displayVertex1 = null;
                for(Object ob: vertices){
                        displayVertex = (DSAGraphVertex) ob;
                        System.out.print(displayVertex.getlabel() + " ");
                        list = displayVertex.getAdjacent();
                        for(Object obj : list){
                                displayVertex1 = (DSAGraphVertex) obj;
                                System.out.print(displayVertex1.getlabel() + " ");
                                //System.out.println(displayVertex.getlabel() + "\n");

                        }
                        System.out.println("\n");
                }

        }


        public void FileIO(String filename){

                DSAGraph graph=new DSAGraph();
                try{
                        Scanner input=new Scanner(new File(filename));

                        //read the file
                        while(input.hasNextLine()){
                                String data=input.nextLine();

                                String vertices[]=data.split(" ");
                                //insert the nodes
                                graph.addEdge(vertices[0],vertices[1]);
                        }
                        graph.displayAsList();
                }catch(FileNotFoundException e)
                {
                        System.out.println(e);
                }
        }
        public DSALinkedList depthfirst(){
                DSALinkedList list = new DSALinkedList();
                DSAstack stack = new DSAstack();
                //temporary objects
                DSAGraphVertex n = null;
                DSAGraphVertex u;
                DSALinkedList h = null;
                Iterator newIter = vertices.iterator();
                while (newIter.hasNext()) {
                        n = (DSAGraphVertex) newIter.next();
                        n.clearVisited();
                }
                n = (DSAGraphVertex) vertices.peekFirst();
                n.setVisited();
                stack.push(n);
                while(!stack.isEmpty()){
                        h = n.getAdjacent();
                        Iterator iter = h.iterator();
                        while(iter.hasNext()){
                                u = (DSAGraphVertex) iter.next();
                                if(u.getVisited() == false){
                                        list.insertLast(n);
                                        list.insertLast(u);
                                        u.setVisited();
                                        stack.push(u);
                                        n = u;
                                        h = n.getAdjacent();
                                        iter = h.iterator();
                                }
                        }
                        n = (DSAGraphVertex) stack.pop();
                }
                return list;
        }

        public DSALinkedList breadthfirst(){
                DSALinkedList list1  = new DSALinkedList();
                DSAqueue queue = new DSAqueue();


                DSALinkedList u = null;
                DSAGraphVertex h = null;
                DSAGraphVertex a;

                h = (DSAGraphVertex) vertices.peekFirst();
                h.setVisited();
                queue.enqueue(h);

                while(!queue.isEmpty()){
                        h = (DSAGraphVertex) queue.dequeue();
                        u = h.getAdjacent();
                        for (Object obj : u){
                                a = (DSAGraphVertex) obj;
                                if(a.getVisited() == false){
                                        list1.insertLast(h);
                                        list1.insertLast(a);
                                        a.setVisited();
                                        queue.enqueue(a);   
                                }
                        }
                }
                return list1;
        }

        public Iterator iterator(){
                return vertices.iterator();
        }







}





