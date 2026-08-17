package Maps_and_Sets;

import java.util.HashSet;

public class countDistinctElements {
    static int distinct(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr)
            set.add(ele);
        return set.size();
    }
}
