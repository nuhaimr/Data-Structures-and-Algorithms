public class DSAGraphEdge{
 FA_GraphVertex from;
 FA_GraphVertex to;
 Object weight;

 public DSAGraphEdge(FA_GraphVertex from,FA_GraphVertex to,Object weight)
 {
 this.from= from;
 this.to = to;
 this.weight = weight;

 }

 public Object getWeight(){
 return weight;
 }
 
 public FA_GraphVertex getFrom(){
 return from;
 }

 public FA_GraphVertex getTo(){
 return to;
 }

 public boolean isDirected(){
 return true;
 } 
}
