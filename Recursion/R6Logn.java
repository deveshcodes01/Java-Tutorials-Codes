package Recursion;
// calculate power of a number using recursion
// Stack height: log(n)
public class R6Logn 
{
// Function to calculate x^n using recursion with stack height log(n)
public static int power(int x, int n) {
    if (n == 0) return 1;
    int half = power(x, n / 2);
    if (n % 2 == 0) {
        return half * half;
    } else {
        return x * half * half;
    }
}

public static void main(String[] args) {
    int x = 2;
    int n = 10;
    System.out.println(x + "^" + n + " = " + power(x, n));
}
}
