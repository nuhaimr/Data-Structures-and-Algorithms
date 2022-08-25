/**
 * DSA Final Assessment Question 5 - FA_GraphVertex.java                             4
 *
 * Name : 
 * ID   :
 *
 **/
public class FA_GraphVertex {

        private String label;
        private Object value;
        private FA_LinkedList links; //list of links of vertices
        private boolean visited;

        public FA_GraphVertex(String inLabel) {

            links = new FA_LinkedList();
            label = inLabel;
        }

        public void addEdge(String inLabel, FA_LinkedList vertex)
        {
            for (Object o : vertex) {
                FA_GraphVertex vertex1 = (FA_GraphVertex) o;
                if (vertex1.getLabel().equals(inLabel)) {
                    links.insertLast(vertex1);
                }
            }
            links.insertLast(inLabel);
        }

        public FA_LinkedList getAdjacent() {
        return links;
    }

        public String getLabel() 
        {
            return this.label;
        }

        public Object getValue() 
        {
            return this.value; 
        }
		
        public String toString() 
        {
            return this.getLabel();
        }
    } 