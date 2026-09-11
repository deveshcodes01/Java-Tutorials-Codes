import java.util.Arrays;

public class SticklerThief {

    // --METHOD 1--
    // public int findMaxSum(int[] arr) {
    //     int n = arr.length;
    //     int[] dp = new int[n];
    //     dp[0] = arr[0];
    //     dp[1] = Math.max(arr[0], arr[1]);
    //     for (int i = 2; i < n; i++) {
    //         dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
    //     }
    //     return dp[n - 1];

        // --METHOD 2--
        static int dp[];

        public int findMaxSum(int[] arr) {
        dp = new int[arr.length]; // 0 to n-1
        Arrays.fill(dp, -1);// mark
        return loot(0, arr);
        }

        private int loot(int i, int[] arr) { // i -> 0 to n-1
        if (i >= arr.length)
        return 0;
        if (dp[i] != -1)
        return dp[i];
        int pick = arr[i] + loot(i + 2, arr);
        int skip = loot(i + 1, arr);
        int ans = Math.max(pick, skip);
        dp[i] = ans;
        return ans;
        // return dp[i] = Math.max(pick,skip);
        }
    }

