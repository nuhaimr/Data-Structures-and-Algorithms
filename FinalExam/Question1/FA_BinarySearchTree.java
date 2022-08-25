/**
 * DSA Final Assessment Question 1 - FA_BinarySearchTree.java
 *
 * Name : Nuha Imran
 * ID   : 20696366
 *
 **/

public class FA_BinarySearchTree {   
	// Inner class FA_TreeNode
	private class FA_TreeNode {
		public int value;
		public FA_TreeNode left;
		public FA_TreeNode right;
		public String colour;
		
		public FA_TreeNode(int inVal)
		{
			value = inVal;
			left = null;
			right = null;
			colour = "black";
		}
	}
	// Class FA_BinarySearchTree
	private FA_TreeNode root;
	
	
	public FA_BinarySearchTree()
	{
		root = null;
	}
	
	public void insert(int val)
	{
		if (isEmpty())
		{
			root = new FA_TreeNode(val);
		}
		else
		{
			root = insertRec(val, root);
		}
	}

	public Boolean isEmpty()
	{
		return root == null;
	}

	private FA_TreeNode insertRec(int inVal, FA_TreeNode cur)
	{
		if (cur == null)
		{
			cur = new FA_TreeNode(inVal);
		}
		else
		{
			if (inVal < cur.value)
			{
				cur.left = insertRec(inVal, cur.left);
			}
			else	
			{
				cur.right = insertRec(inVal, cur.right);
			}
		}
		return cur;
	}
	
        public DSAqueue inOrdWrapper(){
	DSAqueue que = new DSAqueue();
	inOrderTransversal(root, que);
                     
                        for(Object obj : que){
                        System.out.println(obj);
                        }
                        return que;
                        }
	
	    private DSAqueue inOrderTransversal(FA_TreeNode currNode, DSAqueue que) {
                if (currNode != null) {
                        inOrderTransversal(currNode.left, que);
                        que.enqueue(currNode.colour);
                        inOrderTransversal(currNode.right, que);
                }
                return que;
        }


        


        public void colourOddValuesWrapper(){
        colourOddValues(root,"");
        }
        
        private void colourOddValues(FA_TreeNode currNode,String colour){
        //basecase
        if(currNode != null){
        colourOddValues(currNode.left, colour);
        if((currNode.value % 2 )!= 0){
        currNode.colour = "Purple";
        }
        colourOddValues(currNode.right, colour);
        }
        
}
   public void printOddLevels(){
   printOddLevels(root);
   }

   private void printOddLevels(FA_TreeNode currNode){
   if(currNode != null){
   printOddLevels(currNode.left);
   if((currNode.value % 2 )!= 0){
   System.out.println("Value is: " + currNode.value + "|" + "Colour is: " + currNode.colour);
   
   }
    printOddLevels(currNode.right);
    
   }
   }
	
  
}
