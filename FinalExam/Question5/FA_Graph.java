/**
 * DSA Final Assessment Question 5 - FA_Graph.java                             4
 *
 * Name : Nuha Imran
 * ID   : 20696366
 *
 **/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FA_Graph 
{
    private FA_LinkedList edges;
    private FA_LinkedList vertices;
    private int vertexCount;
    private int edgeCount;

    public FA_Graph() 
    {
        edges = new FA_LinkedList();
        vertices = new FA_LinkedList();
        vertexCount = 0;
        edgeCount = 0;
    }

    public FA_GraphVertex addVertex(String label)
    {
        FA_GraphVertex vertex = new FA_GraphVertex(label);
        if (!(hasVertex(label))) 
        {
            vertices.insertLast(vertex);
            vertexCount++;
        }

        return vertex;
    }

    public void addEdge(String label1, String label2, Object weight)
    {
        FA_GraphVertex v1, v2;

        Iterator iterator = vertices.iterator();
        
        v1 = getVertex(label1); 
        v2 = getVertex(label2);

        if (!hasVertex(label1)) {
            v1 = addVertex(label1);
        } else {
            while (iterator.hasNext()) {
                FA_GraphVertex vertex = (FA_GraphVertex) iterator.next();
                if(vertex.getLabel().equals(label1)) {
                    v1 = vertex;
                }
            }
        }

        if (!hasVertex(label2)) {
            v2 = addVertex(label2);
        } else {
            Iterator iterator1 = vertices.iterator();
            while (iterator1.hasNext()) {
                FA_GraphVertex vertex1 = (FA_GraphVertex) iterator1.next();
                if (vertex1.getLabel().equals(label2)) {
                    v2 = vertex1;
                }
            }
        }
        v1.addEdge(label2,vertices);
        DSAGraphEdge gr = new DSAGraphEdge(v1, v2, weight);
        edges.insertLast(gr);
        edgeCount++;
    }

    public boolean hasVertex(String label) 
    {
        boolean has = false;
        for (Object v : vertices) 
        {
		   FA_GraphVertex vg = (FA_GraphVertex) v;
           if (vg.getLabel().equals(label))
			   has = true;
        }
        return has;
    }

    public FA_GraphVertex getVertex(String label) 
    {
        FA_GraphVertex theVertex = null;
        for (Object v : vertices) 
        {
		   FA_GraphVertex vg = (FA_GraphVertex) v;
           if (vg.getLabel().equals(label))
			   theVertex = vg;
        }
		return theVertex;    
	}

    public void displayAsList() 
    {
        DSAGraphEdge edge;
        for(Object o : edges) {
            edge = (DSAGraphEdge) o;
            System.out.println(edge.getFrom().getLabel() + " : " + edge.getTo().getLabel() + " : " + edge.getWeight());
        }

    }
    
   public void FileIO(FA_Graph graph, String filename){

                try{
                    Scanner input=new Scanner(new File(filename));

                    while(input.hasNextLine()){
                        String data=input.nextLine();

                        String vertices[] = data.split(" ");

                        graph.addEdge(vertices[0], vertices[1], vertices[2]);
                    }
                }catch(FileNotFoundException e)
                {
                        System.out.println(e);
                }
        }
        

}  
