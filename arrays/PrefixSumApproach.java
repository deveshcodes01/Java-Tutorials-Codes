import java.util.Scanner;

public class PrefixSumApproach {
      static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 
    }

    static int[] makePrefixSumArray(int[] arr){
        int n=arr.length;
        // int[] pref=new int[n];
        // pref[0]=arr[0];   // creating a prefix array
        for(int i=1;i<n;i++)
        {
            // pref[i]=pref[i-1]+arr[i];  
            arr[i]+=arr[i-1];   // without creating a prefix array 
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array size");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("enter"+n+"elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("input array");
        printArray(arr);

        int[] pref=makePrefixSumArray(arr);
        printArray(pref);
        sc.close();
    }
}
