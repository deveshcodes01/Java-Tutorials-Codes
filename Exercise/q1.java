import java.util.Scanner;

public class q1 {
    public static int calAvg(int a, int b, int c) {
        int av = (a + b + c) / 3;
        return av;
    }

    public static void main(String args[]) {
        int a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter three numbers: ");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        int fa=calAvg(a, b, c);
        System.out.println("average of three numbers is: "+fa);
        sc.close();
    }
}
