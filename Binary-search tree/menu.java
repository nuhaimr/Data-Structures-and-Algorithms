import java.util.Scanner;
import java.io.*;

public class menu implements Serializable {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                DSABinarySearchTree tree = new DSABinarySearchTree();
                tree.insert(6, "B");
                tree.insert(8, "A");
                tree.insert(10, "C");
                tree.insert(12, "D");
                tree.insert(14, "E");
                System.out.println("Menu: \n 1)Read a csv file \n 2)Read a serialised file \n 3)display the tree \n 4)Write a csv file \n 5)Write a serialised file");
                try {
                        int choice;
                        String filename;
                        choice = sc.nextInt();
                        if (choice == 1) {
                                System.out.println("Enter a filename?");
                                sc.nextLine();
                                filename = sc.nextLine();
                                tree.readfile(filename);
                        } else if (choice == 2) {
                                System.out.println("Enter a filename?");
                                sc.nextLine();
                                filename = sc.nextLine();
                                DSABinarySearchTree tempTree = tree.load(filename);
                                tempTree.display();
                        } else if (choice == 3) {
                                tree.display();
                        } else if (choice == 4) {
                                System.out.println("Enter a filename?");

                                sc.nextLine();
                                filename = sc.nextLine();
                                writer(tree, filename);
                        }

                        else if (choice == 5) {
                                System.out.println("Enter a filename?");
                                sc.nextLine();
                                filename = sc.nextLine();

                                tree.save(tree, filename);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }
                sc.close();
        }

        private static void writer(DSABinarySearchTree tree, String filename) {
                Scanner sc1 = new Scanner(System.in);
                DSAqueue que = new DSAqueue();
                int choice;
                try {
                        FileOutputStream fileStrm = new FileOutputStream(filename);
                        PrintWriter pw = new PrintWriter(fileStrm);
                        System.out.println("Which order you would write in: \n 1.PostOrder \n 2.PreOrder \n 3.InOrder");
                        choice = sc1.nextInt();
                        if (choice == 1) {
                                DSAqueue tempQueue = tree.postOrderTransversal(tree.m_root, que);
                                while (!tempQueue.isEmpty()) {
                                        pw.println(tempQueue.dequeue());
                                }
                        }

                        else if (choice == 2) {
                                DSAqueue tempQueue = tree.preOrderTransversal(tree.m_root, que);
                                while (!tempQueue.isEmpty()) {
                                        pw.println(tempQueue.dequeue());
                                }
                        }

                        else if (choice == 3) {
                                DSAqueue tempQueue = tree.inOrderTransversal(tree.m_root, que);
                                while (!tempQueue.isEmpty()) {
                                        pw.println(tempQueue.dequeue());
                                }
                        } 
                        else {
                                System.out.println("Invalid!!");
                        }
                        pw.close();
                } catch (FileNotFoundException e) {
                        e.printStackTrace();

                }
                sc1.close();
        }
}
