package Recursion;

// print numbers from 5 to 1 using recursion
public class R1 {
    public static void printNumb(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumb(n - 1);
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println("Printing numbers from 5 to 1:");
        printNumb(n);
    }
}