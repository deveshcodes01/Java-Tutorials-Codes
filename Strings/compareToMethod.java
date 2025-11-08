public class compareToMethod {
    // public static int compareTo(String a, String b) {
    // int len = Math.min(a.length(), b.length());
    // for (int i = 0; i < len; i++) {
    // if (a.charAt(i) != b.charAt(i)) {
    // return a.charAt(i) - b.charAt(i);
    // }
    // }
    // return a.length() - b.length();
    // }
    public static void main(String[] args) {
        String a = "devesh";
        String b = "krishnani";
        a = a.concat(b);
        System.out.println(a);
    }
}
