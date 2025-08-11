// package Advanced Recursion;

public class SortedArray {
    public static boolean isSorted(int arr[],int idx){
        if (idx == arr.length - 1) {
            return true; // Base case: reached the end of the array
        }
        if (arr[idx] <= arr[idx + 1]) {
            // If current element is less than or equal to the next, continue checking
            return isSorted(arr, idx + 1);
        } else {
            return false; // Found an unsorted pair
        }
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(isSorted(arr, 0)); // Should print true for a sorted array
    }
}
