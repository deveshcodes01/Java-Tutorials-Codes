import java.util.Arrays;

public class PalindromeArray {
    public static boolean palinArray(int[] arr) {
        // Step 1: Sort the array -> O(N log N) time complexity
        Arrays.sort(arr);

        // Step 2: Check each element for palindrome property -> O(N * D)
        for (int num : arr) {
            if (!isPalindrome(num)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }

        return original == reversed;
    }
}
