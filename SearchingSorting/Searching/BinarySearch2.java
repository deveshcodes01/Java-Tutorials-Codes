// program to find first occurence of an element in a sorted array using binary search
public class BinarySearch2 {
    static int firstOcc(int[] a, int x) {
        int n = a.length;
        int start = 0, end = n - 1;
        int fo = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == x) {
                fo = mid;
                end = mid - 1;
            } else if (x < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return fo;
    }

    public static void main(String[] args) {
        int[] a = { 1, 5, 5, 5, 6, 2, 4 };
        int x = 5; // target element
        System.out.println(firstOcc(a, x)); // function call
    }
}
