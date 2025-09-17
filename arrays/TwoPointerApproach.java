import java.util.Scanner;

public class TwoPointerApproach {

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortArrayByParity(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left < right) {
            if (arr[left] % 2 == 1 && arr[right] % 2 == 0) {
                swap(arr, left, right);
                left++;
                right--;
            }
            if (arr[left] % 2 == 0) {
                left++;
            }
            if (arr[right] % 2 == 1) {
                right--;
            }
        }
    }

    // static void sortZerosAndOnes(int[] arr) {
    //     int n = arr.length;
    //     int left = 0, right = n - 1;
    //     while (left < right) {
    //         if (arr[left] == 1 && arr[right] == 0) {
    //             swap(arr, left, right);
    //             left++;
    //             right--;
    //         }
    //         if (arr[left] == 0) {
    //             left++;
    //         }
    //         if (arr[right] == 0) {
    //             right--;
    //         }
    //     }

        static int[] sortSquares(int[] arr)
        {
            int n=arr.length;
            int left=0,right=n-1;
            int[] ans=new int[n];
            int k=0;
            while(left<=right)
            {
                if(Math.abs(arr[left])>Math.abs(arr[right]))
                {
                    ans[k++]=arr[left]*arr[left];
                    left++;
                }else{
                    ans[k++]=arr[right]*arr[right];
                    right--;
                }
            }
            return ans;

        }
        // int n=arr.length;
        // int zeros=0;
        // // count number of zeroes
        // for(int i=0;i<n;i++)
        // {
        // if(arr[i]==0)
        // {
        // zeros++;
        // }
        // }
        // // 0 to zeros-1:0,zeros to n-1:1
        // for(int i=0;i<n;i++)
        // {
        // if(i<zeros)
        // {
        // arr[i]=0;
        // }else{
        // arr[i]=1;
        // }
        // }
    // }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("enter " + n + " element");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("original array");
        printArray(arr);
        int[] ans=sortSquares(arr);
        // sortZerosAndOnes(arr);
        // sortArrayByParity(arr);
        System.out.println("sorted array");
        printArray(ans);
        sc.close();
    }
}
