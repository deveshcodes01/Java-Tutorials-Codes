public class MountainArray {

    public int peakInMountainArray(int[] arr) {
        // METHOD 1
        // int low = 1, high = arr.length - 2;
        // while (low <= high) {
        // int mid = (low + high) / 2;
        // if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        // return mid;
        // } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
        // low = mid + 1;
        // } else
        // high = mid - 1;
        // }
        // return 36785;
        // METHOD 2
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid + 1])
                high = mid;
            else
                low = mid + 1; // inc
        }
        return low;
    }
}
