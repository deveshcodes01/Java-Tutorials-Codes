package Maps_and_Sets;

import java.util.HashSet;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int maxSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int right = 0; right < n; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
