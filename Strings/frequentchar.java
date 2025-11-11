import java.util.Arrays;

public class frequentchar {
    public static char getMaxOccuringChr(String s) {
        int n = s.length();
        int maxFreq = -1;
        char ans = s.charAt(0);
        // ---SLIDING WINDOW TECHNIQUE---
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int i = 0, j = 0;
        while (j < n) {
            if (arr[i] == arr[j])
                j++;
            else {
                int freq = j - i;
                if (freq > maxFreq) {
                    maxFreq = freq;
                    ans = arr[i];
                }
                i = j;
            }
        }
        int freq = j - i;
        if (freq > maxFreq) {
            maxFreq = freq;
            ans = arr[i];
        }
        return ans;
        // ---BRUTE FORCE APPROACH----
        // int n = s.length();
        // int maxFreq = -1;
        // char ans = s.charAt(0);
        // for (int i = 0; i < n; i++) {
        // int freq = 1;
        // char ch = s.charAt(i);
        // for (int j = i + 1; j < n; j++) {
        // if (s.charAt(j) == ch)
        // freq++;
        // }
        // if (freq > maxFreq) {
        // maxFreq = freq;
        // ans = ch;
        // } else if (freq == maxFreq && ch < ans) {
        // ans = ch;
        // }
        // }
        // return ans;
    }
    public static void main(String[] args) {
        String s="understanding";
        System.out.println(getMaxOccuringChr(s));
    }
}
