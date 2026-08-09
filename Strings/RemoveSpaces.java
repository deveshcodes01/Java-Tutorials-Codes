public class RemoveSpaces {
    public String remSpaces(String s) {

        // METHOD 1
        // int n = s.length();
        // int start = 0, end = 0;
        // char[] ch = s.toCharArray();
        // while (start < n) {
        // if (ch[start] != ' ') {
        // ch[end++] = ch[start];
        // }
        // start++;
        // }
        // return new String(ch, 0, end);

        // METHOD 2;
        s = s.replace(" ", "");
        return s;
    }
}
