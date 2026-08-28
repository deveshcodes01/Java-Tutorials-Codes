import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            // Record first occurrence index of each character
            if (!m1.containsKey(c1)) {
                m1.put(c1, i);
            }

            if (!m2.containsKey(c2)) {
                m2.put(c2, i);
            }

            // Compare their first appearance positions
            if (!m1.get(c1).equals(m2.get(c2))) {
                return false;
            }
        }

        return true; // Return true if all character positions matched

    }
}
