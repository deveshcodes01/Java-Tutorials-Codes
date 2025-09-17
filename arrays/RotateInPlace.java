import java.util.Scanner;

public class RotateInPlace {

      // Method to swap elements at indices i and j in the array
        static void swapInArray(int arr[], int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
     static void revArray1(int arr[],int i,int j)
    { 
        while(i<j)
        {
            swapInArray(arr,i,j);
            i++;
            j--;
        }
    }
    static void rotateInPlace(int [] arr,int k)
    {
        int n=arr.length;
        k=k%n;
        revArray1(arr,0,n-k-1);
        revArray1(arr,n-k,n-1);
        revArray1(arr,0,n-1);
    }
        static void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]+ " ");
        }
        System.out.println();

    }

      public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array size");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("enter "+n+" elements" );
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("enter k");
        int k=sc.nextInt();
        System.out.println("original array");
        printArray(arr);
        rotateInPlace(arr, k);
        // int[] ans=rotate(arr, k);
        System.out.println("array after rotation");
        printArray(arr);
        sc.close();
}
}  