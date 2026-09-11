// package Maps_and_Sets.Prefix Sum Pattern;

public class RangeSumQuery {
    private int[] prefixSum;

    public void NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.prefixSum = nums;
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
}
