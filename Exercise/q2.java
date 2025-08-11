import java.util.Scanner;

public class q2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int sum = 0, n;
        System.out.println("enter the value of n: ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (n % i != 0) {
                sum = sum + i;
            }
        }
        System.out.println("sum of all odd numbers upto n is: " + sum);
        sc.close();
    }
}
