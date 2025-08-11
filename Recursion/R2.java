package Recursion;
// print numbers from 1 to 5 using recursion
// This code prints numbers from 1 to 5 using recursion
public class R2 {
    public static void printNumb(int n)
    {
        if (n==6) {
            return;
        }
        System.out.println(n);
        printNumb(n+1);
    }
    public static void main(String args[])
    {
        int n=1;
        System.out.println("Printing numbers from 1 to 5:");
        printNumb(n); //n=1, prints 1 to 5
    }
}
