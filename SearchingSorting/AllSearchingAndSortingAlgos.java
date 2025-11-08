/*
This document contains implementations of Searching and Sorting algorithms like
Selection Sort, Bubble Sort, Merge Sort, and (to be added) Linear Search, Binary Search.
*/

public class AllSearchingAndSortingAlgos {

    // Helper method to print an array
    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " "); // Use print() to stay on the same line
        }
        System.out.println(); // Use println() once to move to the next line
    }

    // --- 1. SELECTION SORT ---
    public static void selectionSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[smallest] > a[j]) {
                    smallest = j;
                }
            }
            // Swap
            int temp = a[smallest];
            a[smallest] = a[i];
            a[i] = temp;
        }
    }

    // --- 2. BUBBLE SORT ---
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // --- 3. MERGE SORT (Conquer/Merge) ---
    // This method merges two sorted halves
    /**
     * This is the main recursive function for Merge Sort, implementing the "divide" part.
     * It recursively splits the array into two halves.
     *
     * @param arr The array to be sorted.
     * @param si  The starting index (inclusive) of the segment to divide.
     * @param ei  The ending index (inclusive) of the segment to divide.
     */
    public static void divide(int arr[], int si, int ei) {
        // Base case: If the segment has 0 or 1 element, it's already sorted.
        if (si >= ei) {
            return;
        }

        // Calculate the middle index to split the array.
        // Using (ei - si) / 2 avoids potential integer overflow for very large arrays.
        int mid = si + (ei - si) / 2;

        // Recursively sort the left half (from si to mid).
        divide(arr, si, mid);
        
        // Recursively sort the right half (from mid + 1 to ei).
        divide(arr, mid + 1, ei);

        // After the two halves are sorted, merge them.
        conquer(arr, si, mid, ei);
    }

    /**
     * This function implements the "conquer" part of Merge Sort.
     * It merges two sorted subarrays (left and right) into a single sorted subarray.
     *
     * @param arr The original array containing the subarrays.
     * @param si  The starting index of the left subarray.
     * @param mid The ending index of the left subarray.
     * @param ei  The ending index of the right subarray.
     */
    public static void conquer(int arr[], int si, int mid, int ei) {
        // Create a temporary array to store the merged result.
        // The size is the total number of elements in the two subarrays.
        int merged[] = new int[ei - si + 1];

        // Pointers for the start of the left and right subarrays.
        int idx1 = si;    // Pointer for the left subarray (si to mid)
        int idx2 = mid + 1; // Pointer for the right subarray (mid+1 to ei)
        
        // Pointer for the temporary 'merged' array.
        int x = 0;

        // --- Main Merge Loop ---
        // Compare elements from both subarrays and copy the smaller one to 'merged'.
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                // Element from the left subarray is smaller or equal.
                merged[x++] = arr[idx1++];
            } else {
                // Element from the right subarray is smaller.
                merged[x++] = arr[idx2++];
            }
        }

        // --- Copy Leftover Elements ---
        // If the right subarray finished first, copy the rest of the left subarray.
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        // If the left subarray finished first, copy the rest of the right subarray.
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // --- Copy Back to Original Array ---
        // Copy the sorted elements from the temporary 'merged' array
        // back into the original 'arr' at the correct position.
        for (int i = 0; i < merged.length; i++) {
            // 'si + i' maps the 'merged' array index 'i'
            // back to the correct starting position 'si' in the original 'arr'.
            arr[si + i] = merged[i];
        }
    }


    // --- 3. QUICK SORT () ---
    public static void quickSort(int arr[],int low,int high)
    {
        if (low<high) {
            int pi=partition(arr,low,high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    public static int partition(int arr[],int low,int high)
    {
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++)
        {
            if (arr[j]<pivot) {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        // swap with pivot
        i++;
        int temp=arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
        return i;
    }
    // ----FOR QUICK SORT---
    // public static void main(String[] args) {
    //     int arr[]={7,8,3,1,2};
    //     quickSort(arr, 0, arr.length-1);
    //     for (int v : arr)System.out.print(v+" ");
    //     System.out.println();
    // }

    // --- 4. LINEAR SEARCH  ---
    static boolean search(int[] a,int n,int target,int idx)
    {
        // base case
        if (idx>=n) {
            return false;
        }
        // self work
        if (a[idx] == target) {
            return true;
        }
        // recursive work
        return search(a, n, target, idx+1);

    }
    public static void main(String[] args) {
        int[] a={1,2,4,6};
        int target = 4;
        if (search(a, a.length, target, 0)) {
            System.out.println("found");
        }else{
            System.out.println("not found");
        }
    }
}