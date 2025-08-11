public class QuickSort {
    public static void quickSort(int arr[],int low,int high)
    {
        if(low<high)
        {
            int pi=partition(arr,low,high);
            {
                quickSort(arr,low,pi-1);
                quickSort(arr,pi+1,high);
            }
        }
    }

    public static int partition(int arr[], int low, int high) {
        // int arr[]={6,3,9,5,2};
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap with pivot
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}
