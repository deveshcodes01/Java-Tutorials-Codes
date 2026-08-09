package Maps_and_Sets;

import java.util.HashMap;

public class LongestRepeatingCharacter {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // checking if j is smaller than string length
        while (j < s.length()) {
            // populate the map
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            // calculate the frequency of characters
            maxFreq = Math.max(maxFreq, map.get(s.charAt(j)));
            // character replacement condition  =  WindowSize - Maximum Frequency
            while ((j - i + 1) - maxFreq > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0)
                    map.remove(s.charAt(i));
                i++; // increase the pointer 
            }
            ans = Math.max(ans, j - i + 1); // taking out the maximum answer
            j++;
        }
        return ans;
    }
}
