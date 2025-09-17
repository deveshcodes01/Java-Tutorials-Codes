import java.util.Scanner;

public class Target_Sum {
    
    static int pairSum(int[] arr,int target)
    {
        int n=arr.length;
        int ans=0;

        for(int i=0;i<n;i++) // first number
        {
            for(int j=i+1;j<n;j++) // second number
            {
                if (arr[i]+arr[j]==target) {
                    ans++;
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

        System.out.println("enter" +n+ "elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Target  Sum "+pairSum(arr,pairSum(arr, n)));
        sc.close();
}
}

