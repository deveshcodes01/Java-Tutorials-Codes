package Recursion;

import java.util.Scanner;

// print numbers from 1 to n using recursion
// This code prints numbers from 1 to n using recursion
public class R2 {
    static int n;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        n = sc.nextInt();
        System.out.println("Printing numbers from 1 to n:");
        printNumb(1,n); // n=1, prints 1 to 5
    }

    // -----METHOD 3-----
    // public static void printNumb(int n) {
    //     if (n == 0) {
    //         return;
    //     }
    //     System.out.print(n + " ");
    //     printNumb(n - 1);
    //     if(n!=1)System.out.print(n + " ");
    // }
    // -----METHOD 1-----
    // public static void printNumb(int x) {
    // if (x > n) { // stopping condition
    // return;
    // }
    // System.out.print(x+" ");
    // printNumb(x + 1);
    // }
    // ------METHOD 2-----
    public static void printNumb(int x,int n) {
    if (x > n) { // stopping condition
    return;
    }
    System.out.print(x+" ");
    printNumb(x + 1,n);
    }
}
