import java.util.Scanner;

public class q3 {
    public static int Great(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers:");

        int a = sc.nextInt();
        int b = sc.nextInt();

        int g = Great(a, b);
        System.out.println("Greatest number is " + g);

        sc.close();
    }
}
