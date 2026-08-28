public class MoveZerosToEnd {
    public void moveZeros(int[] nums) {
        int n = nums.length;
        int lastNonZeroFoundAt = 0;
        for (int cur = 0; cur < n; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt, cur);
                lastNonZeroFoundAt++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
