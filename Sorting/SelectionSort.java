public class SelectionSort {
    public static void printArray(int a[])
    {
        int n=a.length;
       for(int i=0;i<=n;i++)
       {
        System.out.println(a[i]+" ");
       }
       System.out.println();
    }
    public static void main(String args[])
    {
        int a[] = { 7, 8, 3, 1, 2 };
        // time complexity
        // space complexity
        //selection sort algorithm
        for(int i=0;i<a.length-1;i++)
        {
            int smallest=i;
            for(int j=i+1;j<a.length;j++)
            {
                if(a[smallest]>a[j])
                {
                    smallest=j;
                }
            }
            int temp=a[smallest];
            a[smallest]=a[i];
            a[i]=temp;
        }
        printArray(a);
    }
}
