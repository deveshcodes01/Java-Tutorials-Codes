import java.util.*;
public class pattern
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = "BLUEJ";
        int l=s.length();
        // rows
        for(int i = 0 ; i<=4;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print("BLUEJ");
            }
            System.out.println();
        }
    }
}