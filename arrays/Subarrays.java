// Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

import java.util.HashMap;
import java.util.Map;

public class Subarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        int targetSum = threshold * k;

        // 1. Calculate the sum of the first window of size k
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // Check the first window
        if (sum >= targetSum) {
            count++;
        }

        // 2. Slide the window across the rest of the array
        for (int i = k; i < arr.length; i++) {
            // Add the new element entering the window and subtract the old element leaving
            sum = sum + arr[i] - arr[i - k];

            // Check if the current window satisfies the condition
            if (sum >= targetSum) {
                count++;
            }
        }

        return count;
    }

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 1. Add current element to the window
            currentSum += nums[i];
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            // 2. Remove element leaving the window from the left
            if (i >= k) {
                int leftNum = nums[i - k];
                currentSum -= leftNum;
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);

                // Clean up map so size reflects UNIQUE element count
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
            }

            // 3. If window size is k and all elements are distinct
            if (i >= k - 1 && freqMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
