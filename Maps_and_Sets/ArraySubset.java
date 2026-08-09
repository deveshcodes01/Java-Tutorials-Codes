package Maps_and_Sets;

import java.util.HashMap;

public class ArraySubset {
    boolean isSubset(int[] a, int[] b) {
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for (int ele : a) {
            aMap.put(ele, aMap.getOrDefault(ele, 0) + 1);
        }

        HashMap<Integer, Integer> bMap = new HashMap<>();
        for (int ele : b) {
            bMap.put(ele, bMap.getOrDefault(ele, 0) + 1);
        }

        for (int ele : bMap.keySet()) {
            int freq = bMap.get(ele);
            int aFreq = aMap.getOrDefault(ele, 0);
            if (aFreq < freq)
                return false;
        }
        return true;
    }

    int countPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            if (!map.containsKey(ele))
                map.put(ele, 1);
            else
                map.put(ele, map.get(ele) + 1);
        }
        int pairs = 0;
        for (int ele : map.keySet()) {
            int rem1 = ele - k;
            int rem2 = ele + k;
            if (map.containsKey(rem1))
                pairs += map.get(ele) * map.get(rem1);
            if (map.containsKey(rem2))
                pairs += map.get(ele) * map.get(rem2);
        }
        pairs /= 2;
        return pairs;
    }
}
