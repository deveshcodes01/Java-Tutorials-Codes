import java.util.ArrayList;

public class FirstAndLastOccurence {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        // first occurence
        int low = 0, high = arr.length - 1, idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else if (arr[mid] > x)
                high = mid - 1;
            else {
                idx = mid;
                high = mid - 1;
            }
        }
        ans.add(idx);
        // last occurence
        low = 0;
        high = arr.length - 1;
        idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else if (arr[mid] > x)
                high = mid - 1;
            else {
                idx = mid;
                low = mid + 1;
            }
        }
        ans.add(idx);
        return ans;
    }
}
