package functions;

import java.util.Scanner;

public class product {
    public static int Prod(int a, int b) {
        int mul = a * b;
        return mul;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // int mul = Prod(a, b);
        System.out.println("product of 2 numbers is: "+Prod(a, b));
        sc.close();
    }
}
