public class SearchInRotatedSortedArray {
    static int Search(int[] arr, int tar) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == tar)
                return mid;

            // If the left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= tar && tar < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // If the right half is sorted
            else {
                if (arr[mid] < tar && tar <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}