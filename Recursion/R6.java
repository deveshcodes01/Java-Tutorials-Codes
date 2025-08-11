package Recursion;
// calculate power of a number using recursion
//Stack height: n
public class R6 {
    public static int calPower(int x,int n)
    {
        if (n==0) {
            return 1; // Base case: x^0 = 1
        }
        if(x==0) {
            return 0; // Edge case: 0 raised to any power is 0
        }
        int x_nm1 = calPower(x, n - 1); // Recursive call
        int x_n = x * x_nm1; // Calculate x^n using the result of x^(n-1)
        return x_n; // Return the result
    }
    public static void main(String[] args) {
        int x = 2; // Base
        int n = 5; // Exponent
        int ans = calPower(x, n); // Calculate x^n
        System.out.println("Power of " + x + " raised to " + n + " is: " + ans); // Output the result
    }
}
