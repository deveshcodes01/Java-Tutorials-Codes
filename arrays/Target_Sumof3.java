import java.util.Scanner;

public class Target_Sumof3 {
    
    static int tripletSum(int arr[],int target)
    {
        int ans=0;
        int n=arr.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                   if(arr[i]+arr[j]+arr[k]==target){
                    ans++;
                   }
                }
            }
        }
        return ans;
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
        System.out.println("Target Triplet Sum "+tripletSum(arr,tripletSum(arr, n)));
        sc.close();
    }
}
