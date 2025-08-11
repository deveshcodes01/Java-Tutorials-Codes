// package Advanced Recursion;

public class OccurrenceOfCharacter {
    public static int first=-1;
    public static int last=-1;
    public static void findOccur(String str,int idx,char el)
    {
        if(idx==str.length())
        {
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currChar=str.charAt(idx);
        if(currChar==el)
        {
            if(first==-1)
            {
                first=idx;
            }else{last=idx;}
        }
        findOccur(str, idx+1, el);
    }
    public static void main(String[] args) {
        String str="abaaaffddaaeeab";
        findOccur(str, 0, 'a');
    }
}
