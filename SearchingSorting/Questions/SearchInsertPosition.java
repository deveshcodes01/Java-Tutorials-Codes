public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Target is found, return its index directly
            if (nums[mid] == target) {
                return mid;
                // Target is in the right half, discard the left half
            } else if (nums[mid] < target)
                start = mid + 1;
            // Target is in the left half, discard the right half
            else
                end = mid - 1;
        }
        // If not found, 'start' points to the correct insertion index
        return start;
    }
}
