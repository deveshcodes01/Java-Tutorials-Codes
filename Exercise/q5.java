import java.util.Scanner;

public class q5 {

    public static int Age(int a)
    {
        if (a>18) {
            System.out.println("eligible to vote");

        }
        else{
            if(a<18)
            {
                System.out.println("not eligible to vote");
            }

        }
        return a;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter age");
        int age=sc.nextInt();
        int vote=Age(age);
        System.out.println("age of voter is "+vote);
        sc.close();
    }
}