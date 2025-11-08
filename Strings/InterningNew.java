public class InterningNew {
public static boolean equals(String s1,String s2)
{
   if (s1.length()!=s2.length())return false;
   for(int i=0;i<s1.length();i++)
   {
      if (s1.charAt(i)!=s2.charAt(i))return false; 
   }
   return true;
}
   public static void main(String args[]) {
      //   String s1=new String("devesh");
      //   String s2=new String("devesh");
      //  System.out.println(s1==s2); // false
      String s1=new String("devesh");
      String s2=new String("devesh");
      System.out.println(s1.equals(s2));  // true

    }
}
