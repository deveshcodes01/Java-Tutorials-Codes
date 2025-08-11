package functions;

import java.util.Scanner;

public class sum {
    public static  int calSum(int a,int b)
    {
        int sum=a+b;
        return sum;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int sum=calSum(a, b);
        System.out.println("sum of 2 numbers is: "+sum);
        sc.close();
    }
}
