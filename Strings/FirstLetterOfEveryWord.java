public class FirstLetterOfEveryWord {
    String firstAlphabet(String s) {
        int n = s.length();
        String res = "";
        if (s.charAt(0) != ' ') {
            res += s.charAt(0);
        }
        for (int i = 0; i < n; i++) {
            if (i != n - 1 && s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                res += s.charAt(i + 1);
            }
        }
        return res;
    }
}
