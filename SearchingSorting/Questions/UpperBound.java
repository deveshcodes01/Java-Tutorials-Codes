public class UpperBound {
    int upperBound(int[] arr, int target) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int ans = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                ans = mid;// Potential answer found, look further left
                end = mid - 1;
            } else
                start = mid + 1; // Look to the right
        }
        return ans;
    }

}
