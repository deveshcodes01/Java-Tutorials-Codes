import java.util.Arrays;

public class minCostClimbingStairs {
    static int dp[];

    public static int minCostClimbstairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        minCost(0, cost);
        return Math.min(dp[0], dp[1]);
    }

    private static int minCost(int i, int[] cost) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        return cost[i] + Math.min(minCost(i + 1, cost), minCost(i + 2, cost));
    }
}
