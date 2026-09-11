import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currEl = num;
                int currLen = 0;
                while (set.contains(currEl)) {
                    currEl++;
                    currLen++;
                }
                longest = Math.max(longest, currLen);
            }
        }
        return longest;
    }
}
