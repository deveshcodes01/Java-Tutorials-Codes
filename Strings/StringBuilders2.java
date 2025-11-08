// ---FROM GFG TAYYARI BATCH---
// import java.util.ArrayList;
public class StringBuilders2 {
    public static void main(String[] args) {
        // ArrayList<Character> str = new ArrayList<>();
        // str.add('a');
        // str.set(0,'r');
        // StringBuilder s = new StringBuilder("devesh");
        // System.out.println(s.length()+" "+s.capacity());
        // System.out.println(s);
        // s.append(" krishnani");
        // System.out.println(s);
        // s.append("IONSFoiwbegoiwWEJ GOWEGBUbw");
        // System.out.println(s.length()+" "+s.capacity());
        String s="raj";
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        s=sb.toString();
        System.out.println(s);

    }
}
