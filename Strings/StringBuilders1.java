// ---FROM APNA COLLEGE---
public class StringBuilders1 {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("Devesh");
    System.out.println("Enter your name: " + sb);
    // sb.append("e");
    // sb.append("l");
    // sb.append("l");
    // sb.append("o");

    // System.out.println(sb.charAt(0));

    // sb.insert(2,'n');
    // System.out.println(sb);
    // sb.setCharAt(0, 'P');
    // System.out.println(sb);

    sb.delete(3,5);
    sb.deleteCharAt(1);
    System.out.println(sb);
  }
}
