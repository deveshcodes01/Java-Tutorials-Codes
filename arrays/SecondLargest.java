import java.util.Scanner;

public class SecondLargest {
    static int findMax(int[] arr)
    {
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>mx)
            {
                mx=arr[i];
            }
        }
        return mx;
    }
     static int findSecondMax(int arr[])
    {
        int mx=findMax(arr);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==mx)
            {
                arr[i]=Integer.MIN_VALUE;
            }
        }
        int secondMax=findMax(arr);
        return secondMax;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("enter " + n + " elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Maximum element " + findMax(arr));
        System.out.println("Second Maximum element " + findSecondMax(arr));
        sc.close();
    }
}    
