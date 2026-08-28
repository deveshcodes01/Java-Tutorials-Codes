public class ReplaceConsecutiveTwoSamewithOne {
    public String removeDuplicates(String s) {
        int n = s.length();
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        char[] ch = s.toCharArray();
        for (int end = 0; end < ch.length; end++) {
            // Skip all consecutive duplicates
            while (end + 1 < ch.length && ch[end] == ch[end + 1]) {
                end++;
            }
            // Retain exactly one instance
            ch[start++] = ch[end];
        }
        return new String(ch, 0, start);
    }
}
