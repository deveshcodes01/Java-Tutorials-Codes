public class MaxElementInArray {
    
    void maxOfArray()
    {
        int[] arr ={10,5,3,4,7,8};
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>ans)
            {
                ans=arr[i];
            }
        }
        System.out.println("max "+ans);
    }
    public static void main(String[] args) {
        MaxElementInArray obj=new MaxElementInArray();
        obj.maxOfArray();
    }
}
