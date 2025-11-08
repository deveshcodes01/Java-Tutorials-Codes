public class revString {
    public static void main(String args[])
    {
        String s="devesh";
        StringBuilder sb=new StringBuilder("devesh");
        // sb.reverse();
        int i=0,j=sb.length();
        while (i<=j) {
            char temp1=sb.charAt(i);
            char temp2=sb.charAt(j);
            sb.setCharAt(i, temp2);
            sb.setCharAt(j, temp1);
            i++;
            j--;
        }
        System.out.println(sb);


        // for(int i=0; i<sb.length()/2; i++)
        // {
        //     int front=i;
        //     int back=sb.length()-i-1;

        //     char frontChar=sb.charAt(front);
        //     char backChar=sb.charAt(back);

        //     sb.setCharAt(front, backChar);
        //     sb.setCharAt(back, frontChar);
        // }
        // System.out.println(sb);
    } 
}
