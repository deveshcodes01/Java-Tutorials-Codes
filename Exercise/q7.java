import java.util.Scanner;

public class q7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, cp = 0, cn = 0, cz = 0;
        System.out.println("enter the value of n: ");
        n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            if (n > 0) {
                cp = cp + 1;
                System.out.println("cout of positive numbers: " + cp);
            } 
            else if (n < 0) {
                cn = cn + 1;
                System.out.println("count of negative numbers: " + cn);
            }
             else if (n == 0) {
                cz = cz + 1;
                System.out.println("count of zeros: " + cz);
            }
             else {
                n = n + 1;
                System.out.println("remaining numbers are: " + n);
            }
        }
        sc.close();
    }
}
