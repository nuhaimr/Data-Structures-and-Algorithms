import java.util.*;
import java.io.*;
import java.util.Scanner;

public class DSABinarySearchTree implements Serializable {
        private class TreeNode implements Serializable {
                // key iss the largest value in node
                private String m_key;
                // value of the inserts
                private Object m_value;
                // left child of tree
                private TreeNode m_leftChild;
                // right child of tree
                private TreeNode m_rightChild;

                // every node has a key and objects inserted in it
                public TreeNode(String inKey, Object inVal) {
                        if (inKey == null)
                                throw new IllegalArgumentException("Key cannot be null");

                        m_key = inKey;
                        m_value = inVal;
                        m_rightChild = null;
                        m_leftChild = null;
                }

                public String getKey() {
                        return m_key;
                }

                public Object getValue() {
                        return m_value;
                }

                public TreeNode getLeft() {
                        return m_leftChild;
                }

                public void setLeft(TreeNode newLeft) {
                        m_leftChild = newLeft;
                }

                public TreeNode getRight() {
                        return m_rightChild;
                }

                public void setRight(TreeNode newRight) {
                        m_rightChild = newRight;
                }

                // From previous slide
        }

        protected TreeNode m_root;

        public DSABinarySearchTree() {
                m_root = null; // Start with an empty tree
        }
        
        

        // wrapper methods, will call private recursive implementations
        public Object find(String key) {
                return findRec(key, m_root);
        }

        private Object findRec(String key, TreeNode currNode) {
                Object value = null;

                if (currNode == null) // Base case: not found
                        throw new NoSuchElementException("Key " + key + " not found");
                else if (key.equals(currNode.getKey())) // Base case: found
                        value = currNode.getValue();
                else if (key.compareTo(currNode.getKey()) < 0) // Go left (recursive)
                        value = findRec(key, currNode.getLeft());
                else // Go right (recursive)
                        value = findRec(key, currNode.getRight());
                return value;
        }

        public TreeNode insert(Object value, String key) {
                return insertRec(key, value, m_root);
        }

        private TreeNode insertRec(String key, Object value, TreeNode currNode) {
                TreeNode updateNode;
                updateNode = currNode;
                if (m_root == null) {
                        TreeNode newNode = new TreeNode(key, value);
                        m_root = newNode;
                }

                if (currNode == null) {
                        TreeNode newNode = new TreeNode(key, value);
                        updateNode = newNode;
                } else if (key.equals(currNode.getKey())) {
                        throw new NoSuchElementException("Key" + key + "Not found");
                } else if (key.compareTo(currNode.getKey()) < 0) {
                        currNode.setLeft(insertRec(key, value, currNode.getLeft()));
                } else {
                        currNode.setRight(insertRec(key, value, currNode.getRight()));
                }
                return updateNode;
        }

        public void display() {
                Scanner sc = new Scanner(System.in);
                DSAqueue que1 = new DSAqueue();
                int choice;
                System.out.println("Choose \n 1)postOrderTransversal \n 2)preOrderTransversal \n 3)inOrderTransversal");
                choice = sc.nextInt();
                if (choice == 1) {
                        DSAqueue que = postOrderTransversal(m_root, que1);
                        que.iterator();
                        for(Object obj : que){
                        System.out.println(obj);
                        }
                }

                else if (choice == 2) {
                        DSAqueue que = preOrderTransversal(m_root, que1);
                        que.iterator();
                        for(Object obj : que){
                        System.out.println(obj);
                        }
                }

                else if (choice == 3) {
                        DSAqueue que = inOrderTransversal(m_root, que1);
                        que.iterator();
                        for(Object obj : que){
                        System.out.println(obj);
                        }
                }

                else {
                        System.out.println("Invalid choice");
                }
                

        }

        public int height() {
                return heightRec(m_root);
        }

        private int heightRec(TreeNode curNode) {
                int htSoFar, iLeftHt, iRightHt;
                if (curNode == null)
                        htSoFar = -1; // Base case – no more along this branch
                else {
                        iLeftHt = heightRec(curNode.getLeft()); // Calc left height from here
                        iRightHt = heightRec(curNode.getRight()); // Calc right height from here
                        // Get highest of left vs right branches
                        if (iLeftHt > iRightHt)
                                htSoFar = iLeftHt + 1;
                        else
                                htSoFar = iRightHt + 1;
                }
                return htSoFar;
        }

        public DSAqueue preOrderTransversal(TreeNode currNode, DSAqueue que1) {
                if (currNode != null) {
                        que1.enqueue(currNode.getKey());
                        preOrderTransversal(currNode.getLeft(), que1);
                        preOrderTransversal(currNode.getRight(), que1);
                }
                return que1;
        }

        public DSAqueue postOrderTransversal(TreeNode currNode, DSAqueue que1) {
                if (currNode != null) {
                        postOrderTransversal(currNode.getLeft(), que1);
                        postOrderTransversal(currNode.getRight(), que1);
                        que1.enqueue(currNode.getKey());
                }
                return que1;
        }

        public DSAqueue inOrderTransversal(TreeNode currNode, DSAqueue que1) {
                if (currNode != null) {
                        inOrderTransversal(currNode.getLeft(), que1);
                        que1.enqueue(currNode.getKey());
                        inOrderTransversal(currNode.getRight(), que1);
                }
                return que1;
        }

        public String min() {
                return minRec(m_root);
        }

        private String minRec(TreeNode curNode) {
                String minKey;
                if (curNode.getLeft() != null) // not base case
                        minKey = minRec(curNode.getLeft()); // Recursive call
                else {
                        minKey = curNode.getKey();
                }
                return minKey;
        }

        public String max() {
                return maxRec(m_root);
        }

        private String maxRec(TreeNode curNode) {
                String maxKey;
                if (curNode.getRight() != null) // not base case
                        maxKey = maxRec(curNode.getRight()); // Recursive call
                else {
                        maxKey = curNode.getKey();
                }
                return maxKey;
        }

        
          public void balanced(){
          balanceRec(m_root);
          }
         
          private void balanceRec(TreeNode curNode){
          double rig, lef;
          rig = heightRec(curNode.getRight());
          lef = heightRec(curNode.getLeft());
          rig = rig + 1;
          lef = lef + 1;
          double n;
          if(Math.abs(lef - rig) <= 1){
          if(lef > rig){
          n = ((rig/lef) * 100);
          System.out.println("Tree not balanced by: " + n);
          }
          else if(lef < rig){
          n = ((lef/rig) * 100);
          System.out.println("Tree not balanced by: " + n);
          }
          }
          
          else if(lef == rig){
          System.out.println("The tree is balanced");
          }
          
          
          }
         
        private TreeNode deleteRec(String key, TreeNode cur) {
                TreeNode updateNode = cur;
                if (cur == null) {
                        throw new NoSuchElementException();
                } else if (key.equals(cur.getKey())) {
                        updateNode = deleteNode(key, cur);

                } else if (key.compareTo(cur.getKey()) < 0) {
                        cur.setLeft(deleteRec(key, cur.getLeft()));
                } else {
                        cur.setRight(deleteRec(key, cur.getRight()));
                }
                return updateNode;
        }

        private TreeNode promoteSuccessor(TreeNode cur) {

                TreeNode successor = cur;

                if (cur.getLeft() == null) {
                        successor = cur;
                } else {
                        if (cur.getLeft() != null) {
                                successor = promoteSuccessor(cur.getLeft());
                                if (successor == cur.getLeft()) {
                                        cur.setLeft(successor.getRight());
                                }

                        }
                }
                return successor;
        }

        public TreeNode delete(String key) {
                return deleteRec(key, m_root);
        }

        private TreeNode deleteNode(String key, TreeNode delNode) {
                TreeNode updateNode;
                updateNode = null;
                if (delNode.getLeft() == null && delNode.getRight() == null) {
                        updateNode = null;
                } else if (delNode.getLeft() != null && delNode.getRight() == null) {
                        updateNode = delNode.getLeft();
                } else if (delNode.getLeft() == null && delNode.getRight() != null) {
                        updateNode = delNode.getRight();
                } else {
                        updateNode = promoteSuccessor(delNode.getRight());
                        if (updateNode != delNode.getRight())
                                ;
                        {
                                updateNode.setRight(delNode.getRight());
                        }
                        updateNode.setLeft(delNode.getLeft());
                }
                return updateNode;
        }

        
          public void readfile(String filename) throws Exception
          {
          //parsing a CSV file into Scanner class constructor
          Scanner sc = new Scanner(new File(filename));
          sc.useDelimiter(","); //sets the delimiter pattern
          while (sc.hasNext()) //returns a boolean value
          {
          System.out.print(sc.next()); //find and returns the next complete token from
           //this scanner
          }
          sc.close(); //closes the scanner
          }
         

       

        
        public void save(DSABinarySearchTree objToSave, String filename)
         {
         FileOutputStream fileStrm;
         ObjectOutputStream objStrm;
         try {
         fileStrm = new FileOutputStream(filename);
         objStrm = new ObjectOutputStream(fileStrm);
         objStrm.writeObject(objToSave);
        
         objStrm.close();
         }
         catch (Exception e) {
         throw new IllegalArgumentException("Unable to save object to file");
         }
         }
         
         public DSABinarySearchTree load(String filename) throws
         IllegalArgumentException
         {
         FileInputStream fileStrm;
         ObjectInputStream objStrm;
         DSABinarySearchTree inObj = null;
         try {
         fileStrm = new FileInputStream(filename);
         objStrm = new ObjectInputStream(fileStrm);
         inObj = (DSABinarySearchTree)objStrm.readObject();
         objStrm.close();
         }
         catch (ClassNotFoundException e) {
         System.out.println("Class ContainerClass not found");
          }
          catch (Exception e) {
          throw new IllegalArgumentException("Unable to load object from file");
          }
          return inObj;
          }
           }
          
          
         
        

         


