public class FloorInArray {
    public int FloorValue(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1, idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid > x) {
                high = mid - 1;
            } else {
                idx = mid;
                low = mid + 1;
            }
        }
        return idx;
    }
}
