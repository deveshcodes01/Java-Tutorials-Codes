public class LowerBound {
    int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int idx = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target <= arr[mid]) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}
