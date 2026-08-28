package Maps_and_Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramsInStrings {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen)
            return res;
        int pCount[] = new int[26];
        int sCount[] = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCount, sCount)) {
            res.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - pLen) - 'a']--;
            if (Arrays.equals(pCount, sCount)) {
                res.add(i - pLen + 1);
            }
        }
        return res;
    }
}
