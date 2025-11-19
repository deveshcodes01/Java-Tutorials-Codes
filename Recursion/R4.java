// calculate factorial using recursion

package Recursion;

public class R4 {
    public static int calFact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int fact_nm1 = calFact(n - 1);
        int fact_n = n * fact_nm1;
        return fact_n;
    }

    public static void main(String[] args) {
        int n = 5;
        int ans = calFact(n);
        System.out.println("Factorial of " + n + " is: " + ans);
    }
}
