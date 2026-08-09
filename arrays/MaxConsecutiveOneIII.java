public class MaxConsecutiveOneIII {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zc = 0; // zero count
        int maxSize = 0;
        // variable size sliding window
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 1) {
                zc++;
            }
            while (zc > k) {
                if (nums[left] == 0)
                    zc--;
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
        }
        return maxSize;
    }
}
