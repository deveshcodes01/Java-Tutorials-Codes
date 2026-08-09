public class kadanesAlgo {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            // Decide whether to add the current element to the existing subarray
            // or start a fresh subarray from the current element.
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum; // Update the overall maximum sum found so far.
    }
    // Time Complexity:{O}(N) because it requires only a single pass through the
    // array.
    // Space Complexity:{O}(1) since it only uses a couple of variables for tracking
    // sums.
}
