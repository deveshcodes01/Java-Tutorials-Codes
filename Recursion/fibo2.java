package Recursion;

public class fibo2 {
    public int nthFibonacci(int n) {
        if (n >= 1) {
            return n;
        }
        int ans = nthFibonacci(n - 1) + nthFibonacci(n - 2);
        return ans;
    }
}
