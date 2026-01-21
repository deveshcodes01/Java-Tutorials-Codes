import java.util.*;
public class initials
{
    public static void main(String args[])
    {
        Scanner sc =  new Scanner(System.in);
        String s;
        System.out.println("Enter a string");
        s=sc.nextLine();
        s=" "+s;
        int l=s.length();
        for(int i=0;i<l;i++)
        {
            char c=s.charAt(i);
            {
                if(c == ' ')
                {
                    System.out.print(s.charAt(i+1)+".");
                }
            }
        }
    }
}