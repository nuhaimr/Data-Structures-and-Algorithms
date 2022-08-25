import java.util.*;
public class TowerofHanoi {
        public static void main(String[] args) {
                int nDisks, src, dest;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the number of disks?");
                nDisks = sc.nextInt();
                System.out.println("Enter source number?");
                src = sc.nextInt();
                System.out.println("Enter destination number?");
                dest = sc.nextInt();
                System.out.println("Towers(" + nDisks + "," + src + "," + dest + ")");
                doTowers(nDisks, 1, 2, 3, "");

        }
        public static void doTowers(int n, int src, int temp, int dest,String ind) {

                if (n == 1) {
                        System.out.println(ind + "Disk 1 from " + src + " to " + dest);

                } else {
                        doTowers(n - 1, src, dest, temp, ind + "    ");
                        System.out.println(ind + "      " + "Disk " + n + " from " + src + " to " + dest);

                        doTowers(n - 1, temp, src, dest,ind + "        ");
                }
        }
}
